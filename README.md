# 📖 Documentação Técnica — Sistema de Análise de Sentimentos em Comentários de Produtos

## Visão Geral

API RESTful desenvolvida em Java com Spring Boot, seguindo arquitetura limpa e princípios SOLID. Permite cadastro de usuários, produtos e comentários, com análise de sentimento integrada e filtros avançados.

---

## Estrutura do Projeto

- **Entidades:**  
  - `Usuario`  
  - `Produto`  
  - `Comentario`  
  - `TipoSentimento`  

- **DTOs:**  
  - Usuário: `UsuarioRequestDTO`, `UsuarioResponseDTO`  
  - Produto: `ProdutoRequestDTO`, `ProdutoResponseDTO`  
  - Comentário: `ComentarioRequestDTO`, `ComentarioResponseDTO`  

- **Camada de Contratos (Interfaces):**  
  - Repositórios: `UsuarioRepository`, `ProdutoRepository`, `ComentarioRepository`  
  - UseCases: `UsuarioUseCase`, `ProdutoUseCase`, `ComentarioUseCase`  

- **Implementações:**  
  - UseCases: `UsuarioUseCaseImpl`, `ProdutoUseCaseImpl`, `ComentarioUseCaseImpl`  
  - Repositórios: `UsuarioRepositoryImpl`, `ProdutoRepositoryImpl`, `ComentarioRepositoryImpl`  

- **Controllers:**  
  - `UsuarioController`  
  - `ProdutoController`  
  - `ComentarioController`  

---

## Endpoints

### Usuários

- `POST /usuarios` — Cria usuário
- `GET /usuarios/{id}` — Busca usuário por ID
- `GET /usuarios` — Lista todos usuários
- `PUT /usuarios/{id}` — Atualiza usuário
- `DELETE /usuarios/{id}` — Remove usuário

### Produtos

- `POST /produtos` — Cria produto
- `GET /produtos/{id}` — Busca produto por ID
- `GET /produtos` — Lista todos produtos
- `PUT /produtos/{id}` — Atualiza produto
- `DELETE /produtos/{id}` — Remove produto

### Comentários

- `POST /comentarios` — Cria comentário (com análise de sentimento)
- `GET /comentarios/{id}` — Busca comentário por ID
- `GET /comentarios` — Lista todos comentários ou filtra por `produtoId`, `usuarioId` ou `sentimento`

---

## Regras de Negócio

- **Sentimentos:**  
  O sistema reconhece 5 tipos de sentimentos: Muito Positivo, Positivo, Neutro, Negativo, Muito Negativo (`TipoSentimento`).

- **Relacionamentos:**  
  - Usuário pode ter vários comentários.
  - Produto pode ter vários comentários.
  - Comentário está vinculado a um usuário e a um produto.


## Observações

- O projeto segue arquitetura limpa, separando responsabilidades em camadas.
- Os princípios SOLID são aplicados via interfaces, injeção de dependência e segregação de responsabilidades.
- Para detalhes de endpoints e exemplos de uso, consulte o README.md.

---

**Principais arquivos e símbolos citados:**
- Usuario.java
- Produto.java
- Comentario.java
- TipoSentimento.java
- UsuarioController.java
- ProdutoController.java
- ComentarioController.java