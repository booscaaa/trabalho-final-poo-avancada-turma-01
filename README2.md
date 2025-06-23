# Trabalho Final - Análise de Sentimentos em Comentários de Produtos

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot, que permite o gerenciamento de comentários de usuários sobre produtos, com análise de sentimentos integrada. Ele segue os princípios SOLID e é estruturado por camadas (Controller, UseCase, Repository).

---

## 🚀 Funcionalidades

  - Cadastro de usuários, produtos e comentários.
  - Análise de sentimentos nos comentários.
  - Relatórios com estatísticas:
  - Média de sentimentos por produto
  - Quantidade de comentários por sentimento
  - Ranking de usuários mais ativos

---

## 🧠 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- PostgreSQL
- Maven

---

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Maven
- PostgreSQL

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01.git
   cd trabalho-final-poo-avancada-turma-01
   ```
2. Abra o projeto no IntelliJ IDEA.

3. Aguarde o carregamento automático das dependências Maven.

4. Configure a conexão com o banco de dados online:

   ```
    Edite o arquivo application.properties ou .env com as credenciais do banco hospedado.
    spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
   ```
   
5.  Rode a aplicação:
    Clicando no botão verde ▶ na classe principal TrabalhoFinalApplication.

    
---

## 📊 Endpoints da API

### 🗣️ Comentários (`/comment`)
| Método   | Rota                        | Descrição                                        |
|----------|-----------------------------|--------------------------------------------------|
| `POST`   | `/comment`                  | Criar novo comentário                            |
| `PUT`    | `/comment/{id}`             | Atualizar um comentário por ID                   |
| `GET`    | `/comment`                  | Listar todos os comentários                      |
| `GET`    | `/comment/{id}`             | Buscar comentário por ID                         |
| `GET`    | `/comment/user/{id}`        | Listar comentários de um usuário específico      |
| `GET`    | `/comment/product/{id}`     | Listar comentários de um produto específico      |
| `GET`    | `/comment/feeling/{id}`     | Listar comentários por sentimento                |
| `DELETE` | `/comment/{id}`             | Deletar um comentário por ID                     |

### 📦 Produtos (`/product`)
| Método   | Rota                 | Descrição                             |
|----------|----------------------|---------------------------------------|
| `POST`   | `/product`           | Criar um novo produto                 |
| `PUT`    | `/product/{id}`      | Atualizar um produto por ID           |
| `GET`    | `/product`           | Listar todos os produtos              |
| `GET`    | `/product/{id}`      | Buscar produto por ID                 |
| `DELETE` | `/product/{id}`      | Deletar um produto por ID             |

### 👤 Usuários (`/user`)
| Método   | Rota             | Descrição                            |
|----------|------------------|----------------------------------------|
| `POST`   | `/user`          | Criar um novo usuário                  |
| `PUT`    | `/user/{id}`     | Atualizar dados de um usuário por ID  |
| `GET`    | `/user`          | Listar todos os usuários               |
| `GET`    | `/user/{id}`     | Buscar usuário por ID                  |
| `DELETE` | `/user/{id}`     | Deletar usuário por ID                 |

### 📈 Relatórios (`/report`)
| Método | Rota                   | Descrição                                                                       |
|--------|------------------------|---------------------------------------------------------------------------------|
| `GET`  | `/report/feeling/{id}` | Retorna total de comentários associados a um sentimento (por ID)                |
| `GET`  | `/report/product/{id}` | Retorna a média dos sentimentos de um produto, com interpretação textual        |
| `GET`  | `/report/user`         | Retorna ranking de usuários mais ativos, do mais para o menos comentador        |
| `GET`  | `/report/overview`     | Retorna visão geral do sistema, total de usuarios, produtos mais comentados,etc |

---

## ✅ Exemplo de Resposta — `/report/product/1`
```json
{
  "produto": "Notebook Gamer",
  "media_sentimento": 2.6,
  "interpretacao": "Very Positive"
}
```

---

## 🧪 Testes

Você pode testar os endpoints com ferramentas como:

- Postman
- Insomnia
- UseBruno

## ✅ Exemplo de testes usando UseBruno — `localhost:8080/product` -- 
    Body
    {
        "name": "Mouse Logitech",
        "quantity": 15,
        "price": 1100
    }

---

## 👨‍💻 Autor

Trabalho final de Programação Orientada a Objetos Avançada – Cesurg Marau  
Desenvolvido por: Alex Batista
