
# 💬 Projeto de API de Comentários com Análise de Sentimento (GPT)

Este projeto é uma API RESTful desenvolvida com **Java 23** e **Spring Boot 3.4.5**, voltada para o gerenciamento de comentários de produtos. A API permite que os comentários sejam analisados com ajuda da inteligência artificial do ChatGPT, atribuindo um valor de sentimento de **0 a 4**, representando o quão positivo é o comentário.

---

## ⚙️ Tecnologias Utilizadas

- Java 23
- Spring Boot 3.4.5
- PostgreSQL
- Maven
- OpenAI GPT-3.5 API
- dotenv-java (para variáveis de ambiente)
- HTTP Client do Java 11+

---

## 📂 Estrutura do Projeto

```
trabalho_final/
├── core/
│   ├── domain/
│   │   ├── entity/
│   │   ├── enums/
│   │   ├── contract/
│   │   │   ├── controller/
│   │   │   ├── gateway/
│   │   │   ├── repository/
│   │   │   └── usecase/
│   ├── dto/
│   │   ├── request/
│   │   └── response/
│   ├── usecase/
│   └── mapper/
├── global/
├── resources/
├── infra/
│   ├── controller/
│   ├── database/
│   └── gateway/
```

---

## 🔐 Configuração da API Key (OpenAI)

Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

```
OPENAI_API_KEY=sk-xxxxxxx
```

---

## 🧪 Endpoints da API

### 🗨️ Comentários

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/comentario` | Criar um novo comentário |
| `GET`  | `/comentario` | Listar todos os comentários |
| `GET`  | `/comentario/{id}` | Buscar comentário por ID |
| `PUT`  | `/comentario/{id}` | Atualizar um comentário |
| `DELETE` | `/comentario/{id}` | Remover um comentário |
| `GET` | `/comentario?produtoId=1` | Listar por produto |
| `GET` | `/comentario?usuarioId=1` | Listar por usuário |
| `POST` | `/comentario/avaliar` | Avalia todos os comentários pendentes com o GPT |

---

### 🛒 Compras

| Método   | Rota             | Descrição                          |
|----------|------------------|------------------------------------|
| `POST`   | `/compra`        | Criar uma nova compra              |
| `GET`    | `/compra`        | Listar todas as compras            |
| `GET`    | `/compra/{id}`   | Buscar uma compra por ID           |
| `PUT`    | `/compra/{id}`   | Atualizar uma compra existente     |
| `DELETE` | `/compra/{id}`   | Remover uma compra por ID          |

---

### 🛍️ Produtos

| Método   | Rota             | Descrição                      |
|----------|------------------|--------------------------------|
| `POST`   | `/produto`       | Criar um novo produto          |
| `GET`    | `/produto`       | Listar todos os produtos       |
| `GET`    | `/produto/{id}`  | Buscar um produto por ID       |
| `PUT`    | `/produto/{id}`  | Atualizar um produto existente |
| `DELETE` | `/produto/{id}`  | Remover um produto por ID      |

---

### 👤 Usuários

| Método   | Rota             | Descrição                      |
|----------|------------------|--------------------------------|
| `POST`   | `/usuario`       | Criar um novo usuário          |
| `GET`    | `/usuario`       | Listar todos os usuários       |
| `GET`    | `/usuario/{id}`  | Buscar um usuário por ID       |
| `PUT`    | `/usuario/{id}`  | Atualizar um usuário existente |
| `DELETE` | `/usuario/{id}`  | Remover um usuário por ID      |

---

### 📊 Relatórios

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/relatorios/sentimentos` | Total de comentários por sentimento |
| `GET` | `/relatorios/produtos` | Média de sentimento por produto |
| `GET` | `/relatorios/usuarios` | Ranking de usuários mais ativos |

---

## 🔄 Sentimento

O sentimento retornado pela IA segue a seguinte escala:

| Valor | Significado |
|-------|-------------|
| 0     | Muito negativo |
| 1     | Negativo |
| 2     | Neutro |
| 3     | Positivo |
| 4     | Muito positivo |

---

## 🧠 Como funciona a análise de sentimento?

1. A rota `/comentario/avaliar` coleta todos os comentários com campo `sentimento` nulo.
2. Para cada um, envia o texto do comentário para a API do ChatGPT.
3. A IA responde com um número de **0 a 4**, que é salvo no banco como `sentimento`.

---

## 🛠️ Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-projeto.git
   ```
2. Configure o arquivo `.env` com sua chave da OpenAI.
3. Crie um banco PostgreSQL e configure as variáveis do `application.properties` ou `application.yml`.
4. Execute o projeto via Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 👥 Créditos

- Leonardo Benedetti Antunes

---

## 📄 Licença

Este projeto é apenas para fins educacionais.
