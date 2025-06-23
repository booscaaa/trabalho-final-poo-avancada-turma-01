
# 📚 Sistema de Análise de Sentimentos em Comentários de Produtos

## 🎯 Objetivo Geral

Desenvolver uma aplicação web baseada em **Spring Boot** para realizar a **análise de sentimentos** em comentários de usuários sobre produtos (livros), utilizando conceitos de **arquitetura limpa**, **princípios SOLID**, e expondo relatórios analíticos por meio de **endpoints RESTful**.

---

## 🏗️ Arquitetura do Projeto

A aplicação segue a **arquitetura em camadas** e princípios de **Clean Architecture**, dividida em:

- **Camada de Entidades (`core.domain.entity`)**  
  Contém as entidades principais: `Usuario`, `Livro`, `Comentario`.

- **Camada de Contratos (`core.domain.contract`)**  
  Interfaces que definem os comportamentos esperados dos repositórios e casos de uso (UseCases).

- **Camada de DTOs (`application.dto`)**  
  Define objetos de transferência de dados para os relatórios:
    - `RelatorioComentarioDTO`
    - `RelatorioProdutoDTO`
    - `RelatorioUsuarioDTO`

- **Camada de Casos de Uso (`core.usecase`)**  
  Implementa regras de negócio com o `RelatorioUseCaseImpl`.

- **Camada de Infraestrutura (`infra.repository`, `infra.repository.database`, `infra.controller`)**
    - Implementações de repositórios (Spring Data JPA)
    - Controladores REST (`RelatorioController`)
    - Comunicação com o banco de dados

---

## 🗃️ Entidades e Relacionamentos

- **Usuario**
    - id, nome, email, senha
    - Um usuário pode escrever vários comentários.

- **Livro**
    - id, título, autor, descrição, preço
    - Um livro pode ter vários comentários.

- **Comentario**
    - id, texto, sentimento (ex: “Positivo”), score numérico
    - Relacionado a um usuário e a um livro

---

## 💡 Lógica de Sentimento

A aplicação classifica os sentimentos dos comentários em **cinco categorias**, cada uma com uma nota de 1 a 5:

| Sentimento         | Nota |
|--------------------|------|
| Muito Negativo     | 1    |
| Negativo           | 2    |
| Neutro             | 3    |
| Positivo           | 4    |
| Muito Positivo     | 5    |

A entidade `Comentario` possui o método `getNotaSentimento()` para realizar essa conversão.

---

## 📊 Relatórios Disponíveis (API REST)

Endpoints expostos via `RelatorioController`:

- `GET /relatorios/sentimentos`  
  → Total de comentários agrupados por sentimento.  
  (**DTO**: `RelatorioComentarioDTO`)

- `GET /relatorios/produtos`  
  → Média de sentimento por produto.  
  (**DTO**: `RelatorioProdutoDTO`)

- `GET /relatorios/usuarios`  
  → Ranking de usuários mais ativos.  
  (**DTO**: `RelatorioUsuarioDTO`)

---

## 🧠 Regras de Negócio

- O sentimento textual é convertido em nota de 1 a 5.
- Os relatórios garantem todas as 5 notas, mesmo com 0 ocorrências.
- Rankings e médias são ordenados corretamente.
- A nota padrão, caso inválida, é neutra (3).

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- REST APIs
- Arquitetura Limpa (Clean Architecture)
- Princípios SOLID

---

## 🧪 Melhorias Futuras

- Autenticação e autorização com JWT
- Filtros por data, produto ou usuário
- Geração de sentimento automática com IA (ex: GPT, HuggingFace)
- Exportação dos relatórios em PDF/CSV

---

© Projeto acadêmico — CESURG Marau
