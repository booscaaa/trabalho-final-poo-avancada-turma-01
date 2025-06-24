# 💬 Análise de Sentimentos de Comentários de Produtos

Projeto final da disciplina de Programação Orientada a Objetos Avançada (POO II) com o objetivo de realizar a análise de sentimentos em comentários feitos por usuários sobre produtos.

---

## 📌 Objetivo

Desenvolver uma aplicação Java que permite aos usuários:

- Cadastrar produtos, usuários e comentários.
- Realizar análise de sentimento dos comentários utilizando a API da OpenAI.
- Gerar relatórios relacionados a comentários, sentimentos e usuários.

---

## 🧱 Arquitetura do Projeto

O projeto está dividido em camadas seguindo os princípios da arquitetura limpa e SOLID:

- `domain/entity`: Define as entidades de domínio como `Produto`, `Comentario`, `Usuario`.
- `usecase`: Contém os casos de uso da aplicação, como CRUD, análise de sentimento e geração de relatórios.
- `infra`: Contém implementações concretas e gateways externos (como o acesso à API da OpenAI e banco de dados).
- `controller`: Controladores que expõem os endpoints da aplicação via REST.

---

## 🗄️ Estrutura do Banco de Dados

### Tabela `produtos`
| Coluna         | Tipo     |
|----------------|----------|
| id             | int      |
| nome           | string   |
| preco          | float    |
| descricao      | string   |
| avaliacao_produto | float (calculada) |

### Tabela `comentarios`
| Coluna       | Tipo     |
|--------------|----------|
| id           | int      |
| produto_id   | int      |
| usuario_id   | int      |
| comentario   | string   |
| avaliacao    | int      |
| analise      | string   |
| sentimento   | string   |

### Tabela `usuarios`
| Coluna | Tipo     |
|--------|----------|
| id     | int      |
| nome   | string   |
| email  | string   |

---

🔌 Endpoints da API
Abaixo estão listados os principais endpoints disponíveis na aplicação:

👤 Usuários
GET /usuarios – Lista todos os usuários

GET /usuarios/{id} - lista usuário pelo ID

POST /usuarios – Cria um novo usuário

PUT /usuario/{id} – Atualiza os dados de um usuário existente

DELETE /usuario/{id} – Remove um usuário

📦 Produtos

GET /produtos – Lista todos os produtos

GET /produto/{id} - Lista produto pelo ID

POST /produtos – Cadastra um novo produto

PUT /produto/{id} – Atualiza informações de um produto

DELETE /produto/{id} – Deleta um produto

GET /relatorios/produtos – Retorna média de avaliações por produto

💬 Comentários

GET /comentarios – Retorna todos os comentários

GET /comentario/{id} - Retorna comentário por ID

POST /produto/{id}/comentarios – Cadastra um novo comentário (com análise de sentimento via ChatGPT)

GET /comentarios/produto/{id} – Comentários filtrados por produto

DELETE /comentario/{id} – Remove um comentário

GET /comentarios/sentimento/{sentimento} - Busca todos os comentários por sentimento

GET /comentarios/user/{id} - Busca comentarios de um usuário específico pelo ID

GET /comentario/{id} - Busca comentarios de um produto pelo ID

📊 Relatórios

GET /relatorios/comentarios – Retorna quantidade de comentários totais por sentimento

GET /relatorios/produtos – Lista produtos e o sentimento médio com base nos comentários dos usuários

GET /relatorios/usuarios – Ranking de usuários mais ativos



## ⚙️ Funcionalidades Implementadas

- [x] CRUD de usuários, produtos e comentários
- [x] Integração com a API da OpenAI (ChatGPT) para análise de sentimento
- [x] Atualização automática da média de avaliações dos produtos
- [x] Geração de relatórios de sentimento médio de produtos, total de comentários por sentimento e ranking de usuários mais ativos
- [x] Endpoints RESTful organizados

---

## 🔗 Integração com OpenAI

- API utilizada: `https://api.openai.com/v1/chat/completions`
- Modelo usado: `gpt-4.o-mini`
- A análise de sentimento é feita automaticamente ao salvar um novo comentário.
- **Importante**: **A chave da API não deve ser versionada!** Certifique-se de configurar a variável de ambiente `OPENAI_API_KEY`.

---

## 📊 Relatórios

A aplicação permite a geração dos seguintes relatórios:

- Sentimento médio de produtos
- Sentimentos mais frequentes
- Usuários mais ativos

---

## ▶️ Como Executar

Passos:

Clone o repositório:
git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01.git
cd trabalho-final-poo-avancada-turma-01
Abra o projeto no IntelliJ IDEA.

Aguarde o carregamento automático das dependências Maven.

Configure a conexão com o banco de dados online:


    Edite o arquivo application.properties ou .env com as credenciais do banco hospedado.
    spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha

Depois, é só mapear os endpoints na ferramenta "Bruno" (testar as API's REST), ir em "TrabalhoFinalApplication" e selecionar no canto
superior direito o botão verde "Run TrabalhoFinalApplication" (ou apertar Shift+F10);

🗓️ Linha do Tempo do Desenvolvimento

25/05/2025: Modelagem do banco de dados

03/06/2025: CRUD de usuários e conexão inicial com a API da OpenAI

10/06/2025: Correções no commit inicial e refinamento da integração com OpenAI

17/06/2025: Finalização de relatórios, endpoints e testes finais

23/06/2025: Revisão dos enpoints e detalhamento na documentação

📁 Estrutura do Projeto

src/

├── core/
│   ├── domain/
│   ├── dto/
│   ├── usecase/
├── infra/
│   ├── controller/
│   ├── gateway/
│   ├── repository/
├── TrabalhoFinalApplication.java


✍️ Autor
Eduardo Sartori
CESURG - Linguagem e Técnicas de Programação Orientada a Objetos