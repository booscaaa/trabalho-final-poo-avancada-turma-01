# API de Análise de Sentimentos em Comentários de Produtos
O objetivo é permitir o cadastro de produtos, usuários e comentários, analisando o sentimento associado a cada comentário.

## 🛠️ Tecnologias utilizadas
- Java
- Spring Boot
- PostgreSQL
- OpenAI API (para análise de sentimentos)

## 🚀 Como rodar o projeto localmente

1. Clone o repositório:
   git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01
   cd cassiano-richato


2. Configure o banco de dados PostgreSQL:
   Crie um banco chamado `trabalho_final` e ajuste as credenciais no arquivo `application.properties`:
   spring.datasource.url=jdbc:postgresql://localhost:5432/trabalho_final
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha


3. Adicione sua chave da OpenAI no arquivo `.env`:
   OPENAI_API_KEY=sua_chave_aqui


4. Rode o projeto

Endpoints principais
Produtos
- `POST /produtos` – Criar produto
- `GET /produtos/{id}` – Buscar produto por ID
- `GET /produtos` – Listar todos
- `PUT /produtos/{id}` – Atualizar
- `DELETE /produtos/{id}` – Remover

Usuários
- `POST /usuarios` – Criar usuário
- `GET /usuarios/{id}` – Buscar usuário por ID
- `GET /usuarios` – Listar todos
- `PUT /usuarios/{id}` – Atualizar
- `DELETE /usuarios/{id}` – Remover

Comentários
- `POST /comentarios` – Enviar comentário (com análise automática do sentimento)  
  **Exemplo de body:**
  ```json
  {
    "texto": "Esse produto superou minhas expectativas!",
    "usuarioId": 1,
    "produtoId": 2
  }
  ```

  **Resposta esperada:**
  ```json
  {
    "id": 10,
    "texto": "Esse produto superou minhas expectativas!",
    "sentimento": "muito positivo",
    "usuarioId": 1,
    "produtoId": 2
  }
  ```

- `GET /comentarios` – Listar todos os comentários
- `GET /comentarios/{id}` – Buscar comentário por ID
- `GET /comentarios?produtoId=2` – Filtrar por produto
- `GET /comentarios?usuarioId=1` – Filtrar por usuário
- `GET /comentarios?sentimento=positivo` – Filtrar por sentimento

A análise de sentimento retorna um dos seguintes valores:
- muito positivo
- positivo
- neutro
- negativo
- muito negativo

## 🧱 Aplicação dos Princípios SOLID
- S - Single Responsibility: Separação clara entre camadas (entidade, DTO, use case, controller).
- O - Open/Closed: A lógica de negócio pode ser estendida sem modificar os controladores.
- L - Liskov Substitution: DTOs e entidades seguem contratos claros entre camadas.
- I - Interface Segregation: Interfaces definem comportamentos esperados dos repositórios e use cases.
- D - Dependency Inversion: Injeção de dependência aplicada nos controladores e use cases.

## 📚 Desafios e Aprendizados
Um dos principais desafios foi configurar corretamente as entidades no banco de dados e garantir que os relacionamentos estivessem consistentes. Além disso, foi essencial integrar a API da OpenAI de forma segura e funcional. O projeto proporcionou uma compreensão mais clara da arquitetura em camadas, boas práticas de desenvolvimento com Spring Boot e aplicação real dos princípios SOLID.
