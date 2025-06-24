# 💻 Sistema de Análise de Sentimentos em Comentários de Produtos com IA Brasileira.

![](https://media.beehiiv.com/cdn-cgi/image/fit=scale-down,format=auto,onerror=redirect,quality=80/uploads/asset/file/7c810313-5150-49ba-8c7d-7fa5971bbb65/maritaca-ai-4-1920x1080.png?t=1743194476)

## 📖 Descrição do Projeto

Este projeto é uma API REST desenvolvida em Java com Spring Boot, focada na análise de sentimentos em comentários de produtos. Usuários podem cadastrar-se, criar produtos e enviar comentários, que são automaticamente avaliados por uma IA (Maritaca AI) para identificar o sentimento e a qualidade do texto. O sistema armazena essas informações e oferece endpoints para consulta, filtragem e relatórios estatísticos.

---

## 🚀 Como Rodar o Projeto

1. **Pré-requisitos**:
   - Java 17 ou superior (recomendado Java 24) ☕
   - PostgreSQL em execução (recomendo fazer o download do [PgAdmin4](https://www.pgadmin.org/download/) ou utilizar uma conexão com o [Supabase](https://supabase.com/)) 🐘
   - Chave da API da [MARITACA AI](https://www.maritaca.ai/) 🦜
   - IntelliJ IDEA (recomendado) 

2. **Configuração**:
   - Clone o repositório.
   - Crie um arquivo chamado `.env` na raiz do projeto com as variáveis de ambiente, siga a estrutura do arquivo [`example.env`](example.env).
   - Certifique-se de que as variáveis fora configuradas corretamente
   - Crie as tabelas no banco de dados disponíveis em [`00001_create_initial_state_database.sql`](db/migrations/00001_create_initial_state_database.sql) 

3. **Execução**:
   - Abra o projeto no IntelliJ IDEA.
   - Aguarde o carregamento das dependências Maven.
   - Execute a classe [`br.com.cesurgmarau.trabalho_final.TrabalhoFinalApplication`](src/main/java/br/com/cesurgmarau/trabalho_final/TrabalhoFinalApplication.java) como uma aplicação Spring Boot.
   - A API estará disponível em `http://localhost:8080`.

---

## 🛠️ Como Usar os Endpoints

💡**Dica:** Utilize um Cliente HTTP (Insomnia, Postman, Bruno...) para executar as rotas da API, com essas ferramentas você pode criar uma request através de um comando `cURL`.

### Usuários

- **Criar usuário**
  ```sh
  curl -X POST http://localhost:8080/account -H "Content-Type: application/json" -d '{"username":"user1","name":"Usuário 1"}'
  ```
- **Buscar usuário por ID**
  ```sh
  curl http://localhost:8080/account/1
  ```
- **Listar todos os usuários**
  ```sh
  curl http://localhost:8080/account
  ```
- **Atualizar usuário**
  ```sh
  curl -X PUT http://localhost:8080/account/1 -H "Content-Type: application/json" -d '{"username":"user1","name":"Novo Nome"}'
  ```
- **Remover usuário**
  ```sh
  curl -X DELETE http://localhost:8080/account/1
  ```

### Produtos

- **Criar produto**
  ```sh
  curl -X POST http://localhost:8080/product -H "Content-Type: application/json" -d '{"name":"Produto X","price":100,"description":"Descrição"}'
  ```
- **Buscar produto por ID**
  ```sh
  curl http://localhost:8080/product/1
  ```
- **Listar todos os produtos**
  ```sh
  curl http://localhost:8080/product
  ```
- **Atualizar produto**
  ```sh
  curl -X PUT http://localhost:8080/product/1 -H "Content-Type: application/json" -d '{"name":"Produto Y","price":150,"description":"Nova descrição"}'
  ```
- **Remover produto**
  ```sh
  curl -X DELETE http://localhost:8080/product/1
  ```

### Comentários

- **Enviar comentário (com análise automática)**
  ```sh
  curl -X POST http://localhost:8080/review -H "Content-Type: application/json" -d '{"accountID":1,"productID":1,"comment":"Ótimo produto, recomendo!"}'
  ```
- **Buscar comentário por ID**
  ```sh
  curl http://localhost:8080/review/1
  ```
- **Listar todos os comentários**
  ```sh
  curl http://localhost:8080/review
  ```http://localhost:8080/review?productID=1
- **Filtrar por produto**
  ```sh
  curl http://localhost:8080/review?productID=1
  ```
- **Filtrar por usuário**
  ```sh
  curl http://localhost:8080/review?accountID=1
  ```
- **Filtrar por sentimento**
  ```sh
  curl http://localhost:8080/review?classification=RUIM
  ```

### Relatórios

- **Total de comentários por sentimento**
  ```sh
  curl http://localhost:8080/report/classification
  ```
- **Classificações por produto**
  ```sh
  curl http://localhost:8080/report/product
  ```
- **Ranking de usuários mais ativos**
  ```sh
  curl http://localhost:8080/report/account
  ```
- **Visão geral do sistema**
  ```sh
  curl http://localhost:8080/report/general
  ```

## 🧩 Aplicação dos Princípios SOLID

- **Single Responsibility Principle (SRP):** Cada classe tem uma responsabilidade única, separando controllers, use cases e repositórios.
- **Open/Closed Principle (OCP):**  As interfaces permitem extensão de funcionalidades sem modificar implementações existentes.
- **Liskov Substitution Principle (LSP):** Não foi em sua essência esse princípio.
- **Interface Segregation Principle (ISP):** Interfaces específicas para cada contexto (ex: `ProductRepository`, `ReviewRepository`).
- **Dependency Inversion Principle (DIP):** Uso de injeção de dependências do Spring para desacoplar as camadas.

---

## 💡 Desafios e Aprendizados
Tive vários desafios nesse projeto; acredito que os principais foram a questão da conexão com a IA, organização do projeto - principalmente em relação as rotas de relatórios - e aplicação dos princípios SOLID. Mas, em resumo aprendi muitas coisas durante o desenvolvimento do projeto como: melhores formas de se estruturar um projeto e como utilizar um serviço de terceiro em uma aplicação Spring Boot.
