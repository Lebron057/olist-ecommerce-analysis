# Arquivo: src/config/database.py
from sqlalchemy import create_engine
import logging

logging.basicConfig(level=logging.INFO)

# Configurações do Banco (Exatamente como colocamos no docker-compose)
USER = 'root'
PASSWORD = 'root'
HOST = 'localhost'
PORT = '3306'
DATABASE = 'olist_db'

# String de conexão no padrão SQLAlchemy
DATABASE_URI = f"mysql+pymysql://{USER}:{PASSWORD}@{HOST}:{PORT}/{DATABASE}"

def get_engine():
    """Cria e retorna o motor de conexão com o banco de dados."""
    try:
        engine = create_engine(DATABASE_URI)
        logging.info("Conexão com o banco de dados criada com sucesso!")
        return engine
    except Exception as e:
        logging.error(f"Erro ao conectar no MySQL: {e}")
        return None

# Teste simples de conexão
if __name__ == "__main__":
    engine = get_engine()
    if engine:
        # Testa se a conexão abre e fecha sem erros
        with engine.connect() as conn:
            logging.info("Teste de conexão executado com sucesso.")