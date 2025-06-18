
# Trabalho Final Application - API REST

## 📋 Descrição

O **Trabalho Final Application** é uma **API REST** desenvolvida com **Spring Boot**, com o objetivo de gerenciar o cadastro de **produtos**, **categorias** e **usuários**, além de permitir o envio de **comentários** para análise de sentimento via **OpenAI GPT API**.

A aplicação também fornece **relatórios analíticos** com base nos sentimentos coletados, permitindo um melhor entendimento da percepção dos usuários sobre os produtos.


## 🎯 Funcionalidades principais

- ✅ Cadastro de Usuários
- ✅ Cadastro de Produtos
- ✅ Cadastro de Categorias
- ✅ Envio de Comentários sobre os produtos
- ✅ Análise de Sentimento via integração com a OpenAI GPT API
- ✅ Armazenamento de Sentimentos relacionados a cada comentário
- ✅ Geração de Relatórios de sentimentos por produto ou categoria


## 🛠️ Tecnologias utilizadas

- Java 24+
- Spring Boot
- Maven
- API OpenAI GPT (Integração REST)
- Banco de Dados PostgreSQL


## 📡 Integração com a OpenAI

A aplicação realiza chamadas REST para a **API da OpenAI GPT**, enviando os textos dos comentários dos usuários para análise de sentimento.

### Fluxo de Análise de Sentimento:

1. Usuário cadastra um comentário para um produto.
2. A aplicação envia o comentário para a OpenAI GPT API.
3. A IA classifica o sentimento (Ex: Muito Positivo, Positivo, Neutro, Negativo, Muito Negativo).
4. O sentimento é armazenado junto com o comentário no banco de dados.
5. Os dados ficam disponíveis para consulta via relatórios.

## 📊 Relatórios
1. Exemplos de relatórios gerados pela API:
2. Percentual de sentimentos.
3. Porcentual de sentimento por produto.
4. Listagem de Usuário mais ativo.

## 📂 Endpoints - Categoria

### 🔸 Criar uma nova categoria

- **URL:** `POST /categoria`
- **Body (JSON):**
```json
{
  "nome": "nome da categoria"
}
```
Descrição: Cria uma nova categoria.

### 🔸 Listar todas as categorias
- **URL:** `GET /categoria`
- **Resposta:** Lista de categorias no formato JSON.
```json
[
  {
    "id": 1,
    "nome": "Categoria 1"
  },
  {
    "id": 2,
    "nome": "Categoria 2"
  }
]
```
Descrição: Retorna todas as categorias cadastradas.

### 🔸 Deletar uma categoria
- **URL:** `DELETE /categoria/{id}`
- **Parâmetros de rota:**

id → ID da categoria que deseja excluir.

Descrição: Remove a categoria com o ID informado.

### 🔸 Atualizar uma categoria
- **URL:** `PUT /categoria/{id}`
- **Parâmetros de rota:**

id → ID da categoria a ser atualizada.

Body (JSON):

```json
{
  "nome": "nome novo da categoria"
}
```
Descrição: Atualiza o nome da categoria especificada.

## 👤 Endpoints - Usuário
### 🔸 Criar um novo usuário
- **URL:** POST /usuario

Body (JSON):

```json
{
  "cpf": "123.453.789-00",
  "nome": "Nome do Usuário"
}
```
Descrição: Cadastra um novo usuário.

### 🔸 Listar usuário por ID
- **URL:** GET /usuario/{id}

id → ID do usuário.
Resposta (Exemplo):

```json
{
  "id": 1,
  "cpf": "123.453.789-00",
  "nome": "Leo"
}
```
Descrição: Retorna os dados de um usuário específico, com base no ID.

### 🔸 Listar todos os usuários
- **URL:** GET /usuario

Resposta (Exemplo):

```json
[
  {
    "id": 1,
    "cpf": "123.453.789-00",
    "nome": "Leo"
  },
  {
    "id": 2,
    "cpf": "987.654.321-00",
    "nome": "Maria"
  }
]
```
Descrição: Retorna uma lista com todos os usuários cadastrados.

### 🔸 Deletar um usuário
- **URL:** DELETE /usuario/{id}

id → ID do usuário.
Descrição: Remove o usuário com o ID informado.

### 🔸 Atualizar um usuário
- **URL:** PUT /usuario/{id}

id → ID do usuário.

Body (JSON):

```json
{
  "cpf": "123.453.789-00",
  "nome": "Leo"
}
```
Descrição: Atualiza os dados de um usuário existente.

## 📦 Endpoints - Produto
### 🔸 Criar um novo produto
- **URL:** POST /produto

Body (JSON):

```json
{
  "nome": "Esponja",
  "categoriaId": 3
}
```
Descrição: Cadastra um novo produto vinculado a uma categoria existente.

### 🔸 Listar produto por ID
- **URL:** GET /produto/{id}

id → ID do produto.

Resposta (Exemplo):

```json
{
  "id": 1,
  "nome": "Esponja",
  "categoriaId": 3
}
```
Descrição: Retorna os dados de um produto específico.

### 🔸 Listar todos os produtos
- **URL:** GET /produto

Resposta (Exemplo):

```json
[
  {
    "id": 1,
    "nome": "Esponja",
    "categoriaId": 3
  },
  {
    "id": 2,
    "nome": "Detergente",
    "categoriaId": 2
  }
]
```
Descrição: Retorna uma lista com todos os produtos cadastrados.

### 🔸 Deletar um produto
- **URL:** DELETE /produto/{id}

id → ID do produto.

Descrição: Remove o produto com o ID informado.

### 🔸 Atualizar um produto
- **URL:** PUT /produto/{id}

id → ID do produto.

Body (JSON):

```json
{
  "nome": "Novo Nome do Produto",
  "categoriaId": 2
}
```
Descrição: Atualiza o nome e/ou a categoria de um produto existente.

## 💬 Endpoints - Comentário
### 🔸 Criar um novo comentário
- **URL:** POST /comentario

Body (JSON):

```json
{
  "usuarioId": 1,
  "produtoId": 12,
  "comentario": "Muito boa a esponja, limpa tudo, perfeita para lavar qualquer tipo de louça!!"
}
```
Descrição: Cria um comentário de um usuário sobre um produto. Após o cadastro, a aplicação envia o comentário para a API da OpenAI GPT, que analisa o sentimento e armazena junto ao comentário.

### 🔸 Buscar comentário por ID
- **URL:** GET /comentario/{id}

id → ID do comentário.

Resposta (Exemplo):

```json
{
  "id": 8,
  "usuarioId": 1,
  "produtoId": 12,
  "comentario": "Muito boa a esponja, limpa tudo, perfeita para lavar qualquer tipo de louça!!",
  "sentimentoId": 1,
  "nomeUsuario": "Leo Benedetti"
}
```
Descrição: Retorna os detalhes de um comentário específico.

### 🔸 Listar todos os comentários
- **URL:** GET /comentario

Resposta (Exemplo):

```json
[
  {
    "id": 7,
    "usuarioId": 5,
    "produtoId": 12,
    "comentario": "Muito boa a esponja, limpa tudo, eu recomendo nota 10!",
    "sentimentoId": 1,
    "nomeUsuario": "Lorenzo"
  },
  {
    "id": 8,
    "usuarioId": 1,
    "produtoId": 12,
    "comentario": "Muito boa a esponja, limpa tudo, perfeita para lavar qualquer tipo de louça!!",
    "sentimentoId": 1,
    "nomeUsuario": "Leo Benedetti"
  }
]
```
Descrição: Lista todos os comentários cadastrados no sistema.

### 🔸 Listar comentários de um produto
- **URL:** GET /comentario/produtoId/{id}

id → ID do produto.

Resposta (Exemplo):

```json
{
  "id": 12,
  "nome": "Esponja",
  "pontuacao": 10,
  "categoriaId": 3,
  "comentarioDTOS": [
    {
      "id": 7,
      "usuarioId": 5,
      "produtoId": 12,
      "comentario": "Muito boa a esponja, limpa tudo, eu recomendo nota 10!",
      "sentimentoId": 1,
      "nomeUsuario": "Lorenzo"
    },
    {
      "id": 8,
      "usuarioId": 1,
      "produtoId": 12,
      "comentario": "Muito boa a esponja, limpa tudo, perfeita para lavar qualquer tipo de louça!!",
      "sentimentoId": 1,
      "nomeUsuario": "Leo Benedetti"
    }
  ]
}
```
Descrição: Retorna os comentários associados a um determinado produto, junto com os dados do produto.

### 🔸 Listar comentários de um usuário
- **URL:** GET /comentario/usuarioId/{id}

id → ID do usuário.

Resposta (Exemplo):

```json
{
  "id": 4,
  "cpf": "132.453.789-00",
  "nome": "Gian",
  "comentarioDTOS": [
    {
      "id": 3,
      "usuarioId": 4,
      "produtoId": 1,
      "comentario": "Tive uma péssima experiência, não recomendo!!!",
      "sentimentoId": 5,
      "nomeUsuario": "Gian"
    },
    {
      "id": 5,
      "usuarioId": 4,
      "produtoId": 1,
      "comentario": "Comprei mas não vejo utilidade, porém não reclamo!",
      "sentimentoId": 3,
      "nomeUsuario": "Gian"
    }
  ]
}
```
Descrição: Retorna todos os comentários feitos por um usuário específico.

### 🔸 Listar comentários por sentimento
- **URL:** GET /comentario/sentimentoId/{id}

id → ID do sentimento.

Resposta (Exemplo):

```json
{
  "id": 1,
  "tipo": "MuitoPositivo",
  "ponto": 5,
  "quantidade": 4,
  "comentarioDTOS": [
    {
      "id": 1,
      "usuarioId": 5,
      "produtoId": 1,
      "comentario": "Produto excelente! Chegou antes do prazo.",
      "sentimentoId": 1,
      "nomeUsuario": "Lorenzo"
    },
    {
      "id": 2,
      "usuarioId": 6,
      "produtoId": 1,
      "comentario": "Produto excelente! Utilizo muito.",
      "sentimentoId": 1,
      "nomeUsuario": "Cristian"
    }
  ]
}
```
Descrição: Retorna todos os comentários classificados com o sentimento informado.

## 📊 Endpoints - Relatórios
### 🔸 Relatório Total de Sentimentos
- **URL:** GET /relatorio/sentimentos

Body (JSON):
```json
{
  "tipo": "RelatorioTotalString"
}
```
Resposta (Exemplo):

```text
MuitoPositivo 50,00%
Positivo 0,00%
Neutro 12,50%
Negativo 12,50%
MuitoNegativo 25,00%
Descrição: Gera um relatório percentual de todos os sentimentos registrados no sistema, considerando todos os comentários feitos.
```

### 🔸 Relatório de Sentimentos por Produto
- **URL:** GET /relatorio/{produtoId}

produtoId → ID do produto.

Body (JSON):

```json
{
  "tipo": "RelatorioMediaPorProdutoString"
}
```
Resposta (Exemplo):

```text
Vassoura: 
MuitoPositivo 33,33%
Positivo 0,00%
Neutro 16,67%
Negativo 16,67%
MuitoNegativo 33,33%
Descrição: Gera um relatório percentual de sentimentos apenas para um produto específico.
```


### 🔸 Relatório de Usuários Mais Ativos
- **URL:** GET /relatorio/usuarios

Body (JSON):

```json
{
  "tipo": "RelatorioUsuarioMaisAtivoString"
}
```
Resposta (Exemplo):

```text
Gian : 3 comentários.
Lorenzo : 3 comentários.
Cristian : 1 comentários.
Leo Benedetti : 1 comentários.
Descrição: Retorna a quantidade de comentários feitos por cada usuário, ordenados do mais ativo para o menos ativo.
```

### 🔸 Relatório de Produtos por Categoria (Destaques)
- **URL:** GET /relatorio/categoria/{categoriaId}

categoriaId → ID da categoria.

Body (JSON):

```json
{
  "tipo": "RelatorioProdutoOrdenarPorCategoriaString"
}
```
Resposta (Exemplo):


```text
Limpeza: 
Esponja: 10 pontuação.
Vassoura: 6 pontuação.
Descrição: Lista os produtos de uma determinada categoria, ordenados pela pontuação total recebida a partir dos sentimentos dos comentários.
```
