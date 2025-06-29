# 💻 Análise de Sentimentos com Spring Boot e OpenAI (Trabalho Final)

## 🎯 Objetivo

Este projeto consiste em uma aplicação backend desenvolvida em **Java com Spring Boot**, que recebe **comentários de usuários** sobre produtos e utiliza a **API da OpenAI** para classificar automaticamente o sentimento dos comentários. O sistema permite gerenciar produtos, comentários e gerar relatórios analíticos com base nos sentimentos.

---

## 🚀 Descrição do Projeto

- **Cadastro de Produtos e Comentários**
- **Classificação automática de sentimento via OpenAI (GPT-3.5)**
- **Relatórios de análise de sentimentos por produto**
- **Destaque de produtos mais bem avaliados**
- **Destaque de usuários mais positivos**

---

## 🛠 Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **OpenAI API**
- **PostgreSQL**

---

## 📌 Como rodar o projeto
1. **Clone o repositório:**
   ```bash
   https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01.git
    ```
2. **Configure o banco de dados**

3. **Configure as variáveis de ambiente:**
   - `OPENAI_API_KEY`: Sua chave de API da OpenAI.

4. **Execute o projeto**


## ✅ Funcionalidades presentes

- Cadastro de usuários
- CRUD de produtos
- CRUD de comentários
- Integração de IA para análise de sentimento
- Armazenamento do sentimento junto com o comentário
- Filtros para buscar comentários por:
  - Produto
  - Sentimento
  - Usuário

---

## 📚 Aplicação dos Princípios SOLID

| Princípio | Aplicação Esperada                                                                 |
|----------|------------------------------------------------------------------------------------|
| **S** - Single Responsibility | Cada classe tem uma responsabilidade clara (ex: ComentarioService, OpenAIService). |
| **O** - Open/Closed           | Lógica de sentimento pode ser expandida sem modificar os serviços existentes.      |
| **L (se aplicavel)** - Liskov Substitution   | Sem aplicação                                                                      |
| **I** - Interface Segregation | As interfaces são específicas, evitando obrigar implementações desnecessárias.                                 |
| **D** - Dependency Inversion  | OpenAIService é injetado nos use cases, desacoplando o serviço externo da lógica de negócio.                  |

---

### 📌 Endpoints presentes

#### 🧑 Usuários
###### POST
- `/usuarios` — Cadastrar novo usuário, passando "nome", "email" e "senha" no corpo da requisição.
###### GET
- `/usuarios/{id}` — Buscar usuário por ID, passando o ID na URL.  
- `/usuarios` — Listar todos os usuários  
###### PUT
- `/usuarios/{id}` — Atualizar dados do usuário, passando os novos dados no corpo da requisição.
###### DELETE
- `/usuarios/{id}` — Remover usuário, passando o ID do usuário que irá ser removido na URL.

#### 📦 Produtos
###### POST
- `/produtos` — Cadastrar novo produto, passando "nome" e "preco" no corpo da requisição.
###### GET
- `/produtos` — Listar todos os produtos 
###### PUT
- `/produtos/{id}` — Atualizar informações do produto, passando os novos dados no corpo da requisição.
###### DELETE
- `/produtos/{id}` — Remover produto, passando o ID do produto que irá ser removido na URL.

#### 💬 Comentários
###### POST
- `/comentarios` — Criar comentário para um produto específico, passando "produtoId", "usuarioId" e "texto" no corpo da requisição.
###### GET
- `/comentarios` — Listar todos os comentários  
- `/comentarios/{id}` — Buscar comentário por ID, passando o ID na URL. 
- `/comentarios/produto?produtoId=1` — Filtrar por produto, passando o ID do produto como parâmetro na URL.
- `/comentarios/usuario?usuarioId=1` — Filtrar por usuário, passando o ID do usuário como parâmetro na URL.
- `/comentarios/sentimento?feeling=positivo` — Filtrar por sentimento, passando o sentimento como parâmetro na URL (ex: positivo, negativo, neutro).
###### PUT
- `/comentarios/{id}` — Atualizar comentário, passando o novo texto no corpo da requisição.
###### DELETE
- `/comentarios/{id}` — Remover comentário, passando o ID do comentário que irá ser removido na URL.
#### 📊 Relatórios
- `/relatorios/sentimentos` — Retorna total de comentários por sentimento  
- `/relatorios/produto/{id}` — Média de sentimento por produto, passando o ID do produto na URL.
- `/relatorios/usuarios` — Ranking de usuários mais ativos (Com mais comentários)
#### Ranking
###### GET
- `/ranking/produtos` — Retorna os produtos com mais comentários positivos
- `/ranking/usuarios` — Retorna os usuários com mais comentários positivos
---

### 📌 Regras de Negócio

- **Classificação com 5 tipos de sentimentos distintos**
  - Muito positivo
  - Positivo
  - Neutro
  - Negativo
  - Muito negativo
---

## 🧠 Desafios
- Implementar a lógica de classificação de sentimentos utilizando a OpenAI API.
- Implementar todos os princípios SOLID.
- Realizar as regras de negócio de forma que abranja todos os casos de uso.



