# 📦 Projeto Final - API de Análise de Comentários

Este projeto é uma API RESTful desenvolvida em Java com Spring Boot, com foco em análise de sentimentos em comentários de produtos. Aplica os princípios SOLID e segue boas práticas de arquitetura, incluindo separação em camadas: Controller, UseCase, Repository e DTOs.

---

## ✅ Funcionalidades

- Cadastro, edição e exclusão de usuários, produtos e comentários
- Análise automática de sentimentos com 5 classificações distintas:
  - Muito positivo
  - Positivo
  - Neutro
  - Negativo
  - Muito negativo
- Armazenamento do sentimento automaticamente ao criar um comentário
- Relatório geral com estatísticas úteis:
  - Total de comentários por sentimento
  - Média de sentimento por produto (convertido de 1 a 5)
  - Ranking de usuários mais ativos

---

## 🔗 Endpoints principais

### Comentários
- `GET /comentarios` - Listar todos os comentários
- `GET /comentario/id/{id}` - Buscar um comentário por ID
- `POST /comentario` - Criar um novo comentário (com análise de sentimento)
- `PUT /comentario/{id}` - Atualizar um comentário
- `DELETE /comentario/{id}` - Excluir um comentário
- `GET /comentarios/sentimento/{sentimento}` - Buscar comentários filtrando por sentimento
- `GET /comentarios/relatorio` - **Relatório agregado com estatísticas gerais**

### Produtos
- `GET /produtos`, `POST /produto`, `PUT /produto/{id}`, `DELETE /produto/{id}`

### Usuários
- `GET /usuarios`, `POST /usuario`, `PUT /usuario/{id}`, `DELETE /usuario/{id}`

---

## 🧠 Regras de Negócio

- A análise de sentimentos considera palavras-chave no comentário
- Os sentimentos são armazenados automaticamente ao salvar um comentário
- Produtos e usuários podem ser destacados com base em volume de sentimentos positivos
- Relatórios permitem avaliar desempenho geral e gerar insights

---

## 📚 Princípios SOLID Aplicados

- **S (Responsabilidade Única)**: Separação entre camadas e responsabilidades bem definidas
- **O (Aberto para extensão, fechado para modificação)**: Fácil adicionar novos relatórios ou lógicas sem modificar as classes existentes
- **L (Substituição de Liskov)**: Uso correto de interfaces e abstrações
- **I (Segregação de Interfaces)**: Interfaces específicas para cada caso de uso (ex: ComentariosUseCase)
- **D (Inversão de Dependência)**: Classes dependem de interfaces, não de implementações diretas

---

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL ou H2 (dependendo do ambiente)
- RESTful API
- Análise de sentimento simulada via lógica customizada

---

## 📌 Como executar o projeto

1. Clone o repositório
2. Instale as dependências e configure o banco
3. Rode a aplicação: `./mvnw spring-boot:run` ou pelo IntelliJ
4. Acesse via Postman ou browser:
   - `http://localhost:8080/comentarios`
   - `http://localhost:8080/comentarios/relatorio`

---

## 👨‍🏫 Desenvolvido por Eduardo Rossatto
Projeto acadêmico com fins avaliativos — Faculdade Cesurg.
