# Arquivo: src/etl/load_data.py
import pandas as pd
from src.config.database import get_engine
import logging

# Configurando o log para vermos o que está acontecendo no terminal
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(message)s')

def executar_etl():
    # 1. Pegando a conexão com o banco
    engine = get_engine()
    if not engine:
        logging.error("Abortando ETL: Sem conexão com o banco.")
        return

    # --- EXTRAÇÃO (Extract) ---
    logging.info("1. Extraindo dados do CSV (Pedidos)...")
    try:
        df_orders = pd.read_csv('data/raw/olist_orders_dataset.csv')
    except FileNotFoundError:
        logging.error("Arquivo CSV não encontrado. Verifique a pasta data/raw/")
        return

    # --- TRANSFORMAÇÃO (Transform) ---
    logging.info("2. Transformando dados (Convertendo tipos de data)...")
    colunas_de_data = [
        'order_purchase_timestamp', 
        'order_approved_at', 
        'order_delivered_carrier_date', 
        'order_delivered_customer_date', 
        'order_estimated_delivery_date'
    ]
    
    for coluna in colunas_de_data:
        # Convertemos para datetime igual fizemos na Fase 1
        df_orders[coluna] = pd.to_datetime(df_orders[coluna])

    # --- CARGA (Load) ---
    logging.info("3. Carregando dados no MySQL. Isso pode levar alguns segundos...")
    # O comando to_sql cria a tabela se não existir e insere as quase 100 mil linhas
    df_orders.to_sql(
        name='pedidos',          # Nome da tabela que será criada no MySQL
        con=engine,              # Nossa conexão
        if_exists='replace',     # Se a tabela já existir, ele apaga e cria de novo
        index=False              # Não queremos que o índice do Pandas vire uma coluna
    )
    
    # --- CARREGANDO ITENS ---
    logging.info("4. Extraindo e carregando dados dos Itens...")
    try:
        df_items = pd.read_csv('data/raw/olist_order_items_dataset.csv')
        df_items.to_sql(name='itens', con=engine, if_exists='replace', index=False)
    except FileNotFoundError:
        logging.error("CSV de itens não encontrado.")

    # --- CARREGANDO CLIENTES ---
    logging.info("5. Extraindo e carregando dados dos Clientes...")
    try:
        df_customers = pd.read_csv('data/raw/olist_customers_dataset.csv')
        df_customers.to_sql(name='clientes', con=engine, if_exists='replace', index=False)
    except FileNotFoundError:
        logging.error("CSV de clientes não encontrado.")

    logging.info("ETL concluído com sucesso! Tabela 'pedidos' criada no banco.")

if __name__ == "__main__":
    executar_etl()