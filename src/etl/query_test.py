# Arquivo: src/etl/query_test.py
import pandas as pd
from src.config.database import get_engine

def testar_banco():
    engine = get_engine()
    
    # Escrevemos nossa consulta SQL em formato de string pura
    query = """
        SELECT 
            order_status, 
            COUNT(*) as total_pedidos 
        FROM pedidos 
        GROUP BY order_status
        ORDER BY total_pedidos DESC;
    """
    
    print("Executando consulta SQL no MySQL...\n")
    
    # O Pandas executa a query lá no banco e já nos devolve o resultado formatado
    df_resultado = pd.read_sql(query, con=engine)
    
    print(df_resultado)

if __name__ == "__main__":
    testar_banco()