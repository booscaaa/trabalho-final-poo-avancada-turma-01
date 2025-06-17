
# API de Análise de Sentimentos em Comentários de Produtos

O objetivo é permitir o cadastro de produtos, usuários e comentários, analisando o sentimento associado a cada comentário.

## 🛠️ Tecnologias utilizadas
- Java
- Spring Boot
- PostgreSQL
- OpenAI API (para análise de sentimentos)

## 🚀 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01
   cd cassiano-richato
   ```

2. Configure o banco de dados PostgreSQL:
   Crie um banco chamado `trabalho_final` e ajuste as credenciais no arquivo `application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/trabalho_final
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. Adicione sua chave da OpenAI no arquivo `.env`:
   ```
   OPENAI_API_KEY=sua_chave_aqui
   ```

4. Rode o projeto

## 📬 Endpoints da API

### 🧑‍💼 Usuários

#### Criar usuário – `POST /usuarios`
```json
{
  "nome": "Carla Mendes",
  "email": "carla.mendes@example.com"
}
```

#### Buscar usuário por ID – `GET /usuarios/{id}`

#### Listar todos os usuários – `GET /usuarios`

#### Atualizar usuário – `PUT /usuarios/{id}`
```json
{
  "nome": "Carla M. Souza",
  "email": "carla.souza@example.com"
}
```

#### Remover usuário – `DELETE /usuarios/{id}`

### 📦 Produtos

#### Criar produto – `POST /produtos`
```json
{
  "nome": "Teclado Mecânico RGB",
  "descricao": "Teclado com switches vermelhos e iluminação RGB.",
  "preco": 349.90
}
```

#### Buscar produto por ID – `GET /produtos/{id}`

#### Listar todos os produtos – `GET /produtos`

#### Atualizar produto – `PUT /produtos/{id}`
```json
{
  "nome": "Teclado Mecânico RGB Atualizado",
  "descricao": "Agora com switches silenciosos.",
  "preco": 329.90
}
```

#### Remover produto – `DELETE /produtos/{id}`

### 💬 Comentários

#### Criar comentário – `POST /comentarios`
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

#### Buscar comentário por ID – `GET /comentarios/{id}`

#### Listar todos os comentários – `GET /comentarios`

#### Filtrar comentários:
- Por produto: `GET /comentarios?produtoId=2`
- Por usuário: `GET /comentarios?usuarioId=1`
- Por sentimento: `GET /comentarios?sentimento=positivo`

**Tipos de sentimento retornados:**
- muito positivo
- positivo
- neutro
- negativo
- muito negativo

### 📊 Relatórios

#### Média de sentimento por produto – `GET /relatorios/produtos`
```json
[
  {
    "produtoId": 1,
    "mediaSentimento": "positivo"
  },
  {
    "produtoId": 2,
    "mediaSentimento": "neutro"
  }
]
```

#### Total por sentimento – `GET /relatorios/sentimentos`
```json
{
  "muito positivo": 5,
  "positivo": 8,
  "neutro": 3,
  "negativo": 2,
  "muito negativo": 1
}
```

#### Usuários mais ativos – `GET /relatorios/usuarios`
```json
[
  {
    "usuarioId": 1,
    "nome": "João Silva",
    "totalComentarios": 10
  },
  {
    "usuarioId": 2,
    "nome": "Ana Clara",
    "totalComentarios": 7
  }
]
```

## 🧪 Testes com Bruno

Para facilitar os testes da API REST, você pode usar os arquivos `.bru` disponíveis na pasta `trabalho-java/`. Eles podem ser abertos com o [Bruno](https://www.usebruno.com/), uma alternativa leve e eficiente ao Postman.

### Como usar:

1. Instale o [Bruno](https://www.usebruno.com/)
2. Abra o diretório `trabalho-java/` como um projeto no Bruno
3. Utilize as requisições organizadas por pastas:
    - `Usuarios/`
    - `Produtos/`
    - `Comentarios/`
    - `Relatorios/`

## 🧱 Aplicação dos Princípios SOLID

- **S - Single Responsibility**: Separação clara entre camadas (entidade, DTO, use case, controller).
- **O - Open/Closed**: A lógica de negócio pode ser estendida sem modificar os controladores.
- **L - Liskov Substitution**: DTOs e entidades seguem contratos claros entre camadas.
- **I - Interface Segregation**: Interfaces definem comportamentos esperados dos repositórios e use cases.
- **D - Dependency Inversion**: Injeção de dependência aplicada nos controladores e use cases.

## 📚 Desafios e Aprendizados

Um dos principais desafios foi configurar corretamente as entidades no banco de dados e garantir que os relacionamentos estivessem consistentes. Além disso, foi essencial integrar a API da OpenAI de forma segura e funcional. O projeto proporcionou uma compreensão mais clara da arquitetura em camadas, boas práticas de desenvolvimento com Spring Boot e aplicação real dos princípios SOLID.
