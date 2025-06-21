# 🧠 Sistema de Análise de Sentimentos com Relatórios

## 📌 Descrição do Projeto

Este projeto tem como objetivo analisar o **sentimento de comentários** feitos por usuários sobre produtos em um determinado sistema. Além da análise automática por IA, o sistema gera **relatórios úteis**, como:

- Produto mais bem avaliado
- Usuários mais ativos
- Total de comentários por sentimento (positivo, negativo, neutro)

A aplicação foi desenvolvida em **Java** com **Spring Boot**, utilizando **PostgreSQL** como banco de dados e integração com IA para análise de sentimentos.

---

## 🚀 Como Rodar o Projeto

1. **Clone o repositório**:
   ```bash
    git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01.git
   ```
2. **Acesse a pasta do projeto**:
    ```bash
   cd trabalho-final-poo-avancada-turma-01
   ```
   
3. **Altere para minha branch pessoal**:
    ```bash
   git checkout arthur-spolti
   ```
   
4. **Abra o projeto no Intellij IDEA (versão community)**:\
   **Windows**:
    https://www.jetbrains.com/idea/download/?section=windows

   **Linux / macOS**:
   https://www.jetbrains.com/idea/download/?section=mac


 5. **Configure seu banco PostgreSQL, atualize o application.properties se necessário e rode a aplicação pelo IntelliJ.**

--- 

## 🛠️ Estrutura do Banco de Dados

Se as tabelas não forem criadas automaticamente ao rodar o projeto, você pode executá-las manualmente no PostgreSQL. Abaixo estão os comandos SQL para criação das tabelas:

### Tabela `usuarios`

  ```sql
    CREATE TABLE usuarios (
      id_usuario INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
      nome VARCHAR(50),
      idade INT NOT NULL
    );
  ```

### Tabela `produtos`

  ```sql
      CREATE TABLE produtos (
        id_produto INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
        nome VARCHAR(50),
        preco NUMERIC(6, 2) NOT NULL,
        descricao VARCHAR(500)
      );
  ```

### Tabela `comentarios`

  ```sql
       CREATE TABLE comentarios (
          id_comentario INT GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1) PRIMARY KEY,
          comentario VARCHAR(5000) NOT NULL,
          sentimento VARCHAR(5000) NOT NULL,
          usuario INT NOT NULL,
          produto INT NOT NULL,
          sentimento_nota INT,
          FOREIGN KEY (usuario) REFERENCES usuarios(id_usuario),
          FOREIGN KEY (produto) REFERENCES produtos(id_produto)
       );
  ```

> 💡 **Observação:** Você pode executar esses comandos diretamente no terminal do PostgreSQL ou utilizar uma ferramenta como **pgAdmin**.

---

## 📬 Como Usar os Endpoints

Você pode utilizar ferramentas como **Bruno**, **Postman** ou **curl** para testar os endpoints da API.

---

### 🧑 Usuários

| Método | Endpoint        | Descrição                    |
|--------|------------------|------------------------------|
| POST   | `/usuario`       | Cadastrar novo usuário       |
| GET    | `/usuario/{id}`  | Buscar usuário por ID        |
| GET    | `/usuarios`      | Listar todos os usuários     |
| PUT    | `/usuario/{id}`  | Atualizar dados do usuário   |
| DELETE | `/usuario/{id}`  | Remover usuário              |

---

### 📦 Produtos

| Método | Endpoint         | Descrição                         |
|--------|------------------|-----------------------------------|
| POST   | `/produto`        | Cadastrar novo produto            |
| GET    | `/produto/{id}`   | Buscar produto por ID             |
| GET    | `/produtos`       | Listar todos os produtos          |
| PUT    | `/produto/{id}`   | Atualizar informações do produto  |
| DELETE | `/produto/{id}`   | Remover produto                   |

---

### 💬 Comentários

| Método | Endpoint                             | Descrição                                 |
|--------|--------------------------------------|-------------------------------------------|
| POST   | `/comentario`                        | Enviar comentário (com análise de sentimento) |
| GET    | `/comentarios`                       | Listar todos os comentários               |
| GET    | `/comentario/{id}`                   | Buscar comentário por ID                  |
| GET    | `/comentario?produtoId=1`            | Filtrar por produto                       |
| GET    | `/comentarioU?usuarioId=1`           | Filtrar por usuário                       |
| GET    | `/sentimento?sentimento=positivo`    | Filtrar por sentimento                    |

---

### 📊 Relatórios

| Método | Endpoint                     | Descrição                                |
|--------|------------------------------|------------------------------------------|
| GET    | `/relatorios/sentimentos`    | Total de comentários por sentimento      |
| GET    | `/relatorios/produtos`       | Média de sentimento por produto          |
| GET    | `/relatorios/usuarios`       | Ranking de usuários mais ativos          |
| GET    | `/relatorios/mais-ativo`     | Usuário mais ativo                       |

---

## 🧱 Princípios SOLID Aplicados

O projeto segue os princípios do **SOLID**, com exceção do **Princípio de Substituição de Liskov (LSP)**.

- **S - Single Responsibility Principle (SRP):**  
  Cada classe possui uma única responsabilidade bem definida, como controlar uma entidade ou executar uma lógica específica.

- **O - Open/Closed Principle (OCP):**  
  A estrutura permite extensão de funcionalidades sem modificação direta nas classes existentes.

- **L - Liskov Substitution Principle (LSP):**  
  ❌ Ainda não aplicado neste projeto.

- **I - Interface Segregation Principle (ISP):**  
  As interfaces seguem o princípio de granularidade, evitando obrigar classes a implementar métodos que não utilizam.

- **D - Dependency Inversion Principle (DIP):**  
  As camadas de negócio dependem de abstrações, e não de implementações concretas.

---

## 🚧 Desafios e Aprendizados

Na parte dos **CRUDs**, meu maior desafio foi o **tratamento de erros**. No início, tive dificuldades com o uso de exceções, mas com a prática, aprendi como utilizar corretamente as `Exceptions` para lidar com diferentes tipos de falhas e garantir respostas apropriadas da API.

Já na parte da **integração com IA**, com certeza foi um dos aprendizados mais importantes. A inteligência artificial está presente em praticamente todos os sistemas modernos, e entender como utilizá-la foi essencial.

Meu maior desafio nessa etapa foi **criar as queries para os relatórios**, pois precisei **mapear corretamente a resposta da IA** e também fazer a **conversão da string do sentimento para um número (`nota_sentimento`)**. Isso exigiu atenção aos detalhes e compreensão do funcionamento dos dados gerados pela IA.

---

## ✍️ Autor

**Arthur Pedro Spolti**  
Branch: `arthur-spolti`
