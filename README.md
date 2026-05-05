# 📊 Olist E-commerce: Análise de Dados e Previsão Logística

Este projeto consiste numa solução completa de Ciência de Dados aplicada ao ecossistema da **Olist**. Abrange desde a análise exploratória (EDA) de dados reais de e-commerce brasileiro até à implementação de um modelo de Machine Learning exposto via API para prever prazos de entrega.

## 🏗️ Arquitetura do Sistema

O projeto está dividido em três camadas principais:
1.  **Data Science & EDA**: Notebooks Jupyter para limpeza, análise e treino do modelo preditivo.
2.  **API de Previsão (Python)**: Desenvolvida com **FastAPI**, utiliza um modelo *Random Forest* para calcular o tempo estimado de entrega.
3.  **Backend (Java)**: Desenvolvido com **Spring Boot**, gere o fluxo de pedidos, integração com a API de IA e persistência em base de dados MySQL.

## 🛠️ Tecnologias Utilizadas

### Ciência de Dados & API
* **Python 3.10+**
* **Pandas & NumPy**: Manipulação de dados.
* **Matplotlib & Seaborn**: Visualização de dados e sazonalidade.
* **Scikit-Learn**: Modelação preditiva.
* **FastAPI**: Interface de comunicação com o modelo de IA.

### Backend & Infraestrutura
* **Java 21 / Spring Boot 4.0.6**
* **MySQL 8.0**: Armazenamento de dados.
* **Docker & Docker Compose**: Orquestração de contentores para a base de dados.

## 📂 Estrutura do Repositório

```text
.
├── analise_ecommerce/          # Core de Ciência de Dados
│   ├── notebooks/              # EDA e Treino do Modelo
│   ├── src/                    # Scripts Python e Modelos (joblib)
│   ├── data/raw/               # Datasets originais da Olist
│   └── docker-compose.yml      # Configuração do MySQL
└── backend/                    # Aplicação Spring Boot (Java)
    ├── src/main/java/...       # Controladores e Serviços
    └── pom.xml                 # Dependências Maven
```

## 📈 Insights da Análise Exploratória (EDA)

Durante a fase de exploração:
* **Processamento**: Conversão de 5 colunas de timestamps e limpeza de pedidos não entregues.
* **Geografia**: Mapeamento da densidade de clientes por estado e cidade brasileira.
* **Faturamento**: Identificação de tendências temporais e picos de vendas.
* **Consolidação**: Criação de uma tabela mestre unificando pedidos, produtos e clientes.

## 🚀 Como Executar

### 1. Base de Dados (Docker)
Na pasta `analise_ecommerce`, sobe o MySQL:
```bash
docker-compose up -d
```

### 2. API de Previsão (Python)
Instala as dependências e inicia o servidor FastAPI:
```bash
pip install -r requirements.txt
uvicorn src.api_previsao:app --reload
```

### 3. Backend (Java)
Certifica-te de ter o Maven instalado e executa a aplicação:
```bash
cd backend
./mvnw spring-boot:run
```

## 🔌 Endpoints Principais

* **API Python**: `POST /prever` - Recebe dados do pedido e retorna os dias estimados para entrega.
* **Backend Java**: `POST /api/pedidos/checkout` - Realiza o fluxo completo: recebe o pedido, consulta a IA, guarda no banco e retorna o checkout finalizado.

## 📚 Referências
* Dataset original: [Olist E-commerce no Kaggle](https://www.kaggle.com/olistbr/brazilian-ecommerce).

---

**Nota:** Este projeto foi desenvolvido para fins educacionais e de demonstração de fluxo *end-to-end* em Engenharia e Ciência de Dados.