# Arquivo: src/api_previsao.py
from fastapi import FastAPI
from pydantic import BaseModel
import joblib
import pandas as pd

app = FastAPI(title="API de Previsão Logística Olist")

# 1. Carregando o cérebro da nossa IA
modelo = joblib.load('src/modelo_logistico_rf.pkl')

# Extraímos as colunas exatas que o modelo aprendeu no treinamento
colunas_esperadas = modelo.feature_names_in_

class DadosPedido(BaseModel):
    preco_produto: float
    valor_frete: float
    estado_cliente: str
    compra_fim_semana: int

@app.post("/prever")
def prever_entrega(pedido: DadosPedido):
    # Calculando a proporção
    proporcao = pedido.valor_frete / pedido.preco_produto
    
    # 2. O TRUQUE MÁGICO: Criamos um DataFrame vazio apenas com as colunas que o modelo espera, preenchido com ZEROS.
    df_entrada = pd.DataFrame(0, index=[0], columns=colunas_esperadas)
    
    # 3. Preenchemos as colunas numéricas
    df_entrada['price'] = pedido.preco_produto
    df_entrada['freight_value'] = pedido.valor_frete
    df_entrada['frete_proporcao'] = proporcao
    df_entrada['compra_fim_semana'] = pedido.compra_fim_semana
    
    # 4. Tratamos o estado (One-Hot Encoding manual)
    # Ex: Se o cliente mandar "SP", ele procura a coluna "customer_state_SP" e coloca 1.
    coluna_estado = f'customer_state_{pedido.estado_cliente.upper()}'
    if coluna_estado in df_entrada.columns:
        df_entrada[coluna_estado] = 1
    
    # 5. Agora sim, o formato está perfeito! Fazemos a previsão.
    previsao_dias = modelo.predict(df_entrada)[0]
    
    return {
        "status": "sucesso",
        "previsao_entrega_dias": round(previsao_dias, 1),
        "mensagem": f"O pedido chegará em aproximadamente {round(previsao_dias, 1)} dias."
    }