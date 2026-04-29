# 📊 Análise de E-commerce - OLIST

Uma análise exploratória completa dos dados de e-commerce da **Olist**, uma plataforma de vendas online brasileira. Este projeto utiliza dados reais contendo informações sobre clientes, pedidos, produtos e entregas.

---

## 🎯 Objetivo

Explorar e compreender o comportamento dos clientes, padrões de vendas e performance da plataforma através de análises descritivas e visualizações de dados.

---

## 🛠️ Ferramentas Utilizadas

| Ferramenta | Versão | Propósito |
|-----------|--------|----------|
| **Python** | 3.x | Linguagem principal |
| **Pandas** | - | Manipulação e análise de dados |
| **NumPy** | - | Operações numéricas e estatísticas |
| **Matplotlib** | - | Criação de gráficos estáticos |
| **Seaborn** | - | Visualizações estatísticas avançadas |
| **Jupyter Notebook** | - | Desenvolvimento interativo |

---

## 📈 Insights Principais Extraídos

Durante a análise exploratória, foram identificados:

### ✅ Processamento de Dados
- **Conversão de Tipos**: Transformação de 5 colunas de timestamps para formato datetime
- **Limpeza de Dados**: Filtragem de pedidos por status (foco em pedidos entregues)
- **Consolidação**: Merge de múltiplas tabelas (pedidos, itens, clientes)

### 📊 Análises Realizadas
- **Status de Pedidos**: Distribuição de pedidos por status (delivered, cancelled, pending, etc.)
- **Faturamento Mensal**: Série temporal de receita por mês
- **Dados Geográficos**: Análise de clientes por estado e cidade
- **Valores de Transação**: Análise de preços de produtos e custos de frete

### 🔍 Dados Consolidados
- Criação de tabela "master" unificando pedidos, itens do pedido e informações de clientes
- Seleção de **8 colunas-chave** para análise: `order_id`, `customer_id`, `order_purchase_timestamp`, `order_delivered_customer_date`, `price`, `freight_value`, `customer_state`, `customer_city`

---

## 📁 Estrutura do Projeto

```
analise_ecommerce/
│
├── 01_exploracao_inicial.ipynb      # Análise exploratória inicial
├── requirements.txt                  # Dependências do projeto
├── README.md                          # Este arquivo
├── .gitignore                         # Configurações Git
│
└── data/
    └── raw/
        ├── olist_customers_dataset.csv
        ├── olist_geolocation_dataset.csv
        ├── olist_order_items_dataset.csv
        ├── olist_order_payments_dataset.csv
        ├── olist_order_reviews_dataset.csv
        ├── olist_orders_dataset.csv
        ├── olist_products_dataset.csv
        ├── olist_sellers_dataset.csv
        └── product_category_name_translation.csv
```

---

## 🚀 Como Executar na Máquina Local

### 📋 Pré-requisitos

- Python 3.7 ou superior
- pip (gerenciador de pacotes Python)
- Git

### ⚙️ Passos para Configuração

#### 1. **Clone o Repositório**
```bash
git clone https://github.com/seu-usuario/analise_ecommerce.git
cd analise_ecommerce
```

#### 2. **Crie um Ambiente Virtual**

No Windows:
```bash
python -m venv venv
venv\Scripts\activate
```

No macOS/Linux:
```bash
python3 -m venv venv
source venv/bin/activate
```

#### 3. **Instale as Dependências**
```bash
pip install -r requirements.txt
```

#### 4. **Inicie o Jupyter Notebook**
```bash
jupyter notebook
```

#### 5. **Abra e Execute o Notebook**
- Clique no arquivo `01_exploracao_inicial.ipynb`
- Execute as células usando `Shift + Enter` ou clique em "Run All"

---

## 📊 Dataset

O dataset é fornecido pela **Olist** e contém informações de:

- **99.441 pedidos** entre 2016 e 2018
- **3.095.513 itens** vendidos
- **~600 categorias** de produtos
- **101 vendedores** (sellers)
- **Multiple payment methods** (crédito, boleto, etc.)

### Tabelas Principais

| Tabela | Descrição |
|--------|-----------|
| `olist_orders_dataset` | Dados dos pedidos (status, datas, etc.) |
| `olist_order_items_dataset` | Itens contidos em cada pedido |
| `olist_customers_dataset` | Informações dos clientes |
| `olist_products_dataset` | Catálogo de produtos |
| `olist_sellers_dataset` | Informações dos vendedores |
| `olist_order_payments_dataset` | Detalhes de pagamentos |
| `olist_order_reviews_dataset` | Avaliações e comentários |

---

## 🔧 Tecnologias & Versões

```
Python 3.10+
pandas 
numpy 
matplotlib 
seaborn 
jupyter 
```

Para versões exatas, consulte `requirements.txt`.

---

## 📝 Metodologia

Este projeto segue a metodologia padrão de **EDA (Exploratory Data Analysis)**:

1. ✅ **Carregamento e Inspeção** dos dados
2. ✅ **Limpeza e Tratamento** de valores faltantes e tipos de dados
3. ✅ **Consolidação e Merge** de múltiplas fontes
4. ✅ **Análises Descritivas** e estatísticas
5. ✅ **Visualizações** gráficas
6. ✅ **Interpretação** de padrões e insights

---

## 🎓 Aprendizados

Este projeto demonstra habilidades em:

- ✨ Manipulação de dados com **Pandas**
- ✨ Processamento de dados temporal (timestamps)
- ✨ Limpeza e validação de dados
- ✨ Merge e consolidação de múltiplas tabelas
- ✨ Visualização de dados com **Matplotlib** e **Seaborn**
- ✨ Análise exploratória de dados (EDA)
- ✨ Storytelling com dados

---

## 🤝 Contribuindo

Este é um projeto de aprendizado pessoal. Fique à vontade para:

- 🔄 Fazer fork do repositório
- 📝 Criar pull requests com melhorias
- 🐛 Reportar problemas (issues)
- 💡 Sugerir novas análises

---

## 📄 Licença

Este projeto utiliza dados públicos da Olist e é compartilhado para fins educacionais.

---

## 📞 Contato

Para dúvidas ou sugestões, entre em contato ou abra uma issue no repositório.

---

## 📚 Referências

- [Dataset Olist - Kaggle](https://www.kaggle.com/olistbr/brazilian-ecommerce)
- [Pandas Documentation](https://pandas.pydata.org/docs/)
- [Matplotlib Documentation](https://matplotlib.org/)
- [Seaborn Documentation](https://seaborn.pydata.org/)

---

**Última atualização:** Abril de 2026  
**Status:** ✅ Em desenvolvimento
