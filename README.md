
# API de Análise de Sentimentos em Comentários de Produtos

O objetivo é permitir o cadastro de produtos, usuários e comentários, analisando o sentimento associado a cada comentário.  
A aplicação também implementa uma pontuação automática para destacar usuários e produtos com maior número de feedbacks positivos.

---

## 🛠️ Tecnologias utilizadas
- Java 17
- Spring Boot
- PostgreSQL
- OpenAI API (para análise de sentimentos)
- Maven

---

## 🚀 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/booscaaa/trabalho-final-poo-avancada-turma-01.git
   cd trabalho-final-poo-avancada-turma-01
   git checkout cassiano-richato
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

4. Rode o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 📬 Endpoints da API

### 🧑‍💼 Usuários

- `POST /usuarios`
- `GET /usuarios/{id}`
- `GET /usuarios`
- `PUT /usuarios/{id}`
- `DELETE /usuarios/{id}`

### 📦 Produtos

- `POST /produtos`
- `GET /produtos/{id}`
- `GET /produtos`
- `PUT /produtos/{id}`
- `DELETE /produtos/{id}`

### 💬 Comentários

- `POST /comentarios`
- `GET /comentarios/{id}`
- `GET /comentarios`
- `GET /comentarios?produtoId=1`
- `GET /comentarios?usuarioId=1`
- `GET /comentarios?sentimento=positivo`
- `DELETE /comentarios/{id}`

**Tipos de sentimento retornados:**
- muito positivo
- positivo
- neutro
- negativo
- muito negativo

---

### 📊 Relatórios

- `GET /relatorios/produtos`: Média de sentimento por produto
- `GET /relatorios/sentimentos`: Total de comentários por sentimento
- `GET /relatorios/usuarios`: Ranking de usuários mais ativos
- `GET /destaques/usuarios`: Usuários com mais comentários positivos
- `GET /destaques/produtos`: Produtos com mais comentários positivos

---

## 🏅 Destaque de Usuários e Produtos

A aplicação calcula e destaca:

- Usuários com maior número de comentários positivos (`%positivo%`)
- Produtos mais bem avaliados por sentimento

Esses dados são atualizados automaticamente e podem ser consumidos pelos relatórios.

---

## 🧪 Testes com Bruno

1. Instale o [Bruno](https://www.usebruno.com/)
2. Abra o diretório `trabalho-java/` como um projeto no Bruno
3. Utilize as requisições organizadas por pastas:
   - `Usuarios/`
   - `Produtos/`
   - `Comentarios/`
   - `Relatorios/`

---

## 🧱 Aplicação dos Princípios SOLID

| Princípio | Aplicação |
|----------|-----------|
| **S** - Single Responsibility | Camadas bem separadas: entidades, DTOs, usecases, controllers |
| **O** - Open/Closed           | Funcionalidades de destaque adicionadas sem alterar controladores |
| **L** - Liskov Substitution   | Interfaces e implementações seguem contratos definidos |
| **I** - Interface Segregation| Repositórios e usecases são específicos e coesos |
| **D** - Dependency Inversion | Injeção de dependência nos usecases e controladores |

---

## 📚 Desafios e Aprendizados

- Aprendi a estruturar uma aplicação com **arquitetura limpa**, organizando pacotes por responsabilidades.
- Foi desafiador integrar com uma **API de IA externa** (OpenAI), mantendo segurança e performance.
- A parte de **relatórios e pontuação dinâmica** exigiu consultas otimizadas com JPQL e uso adequado de DTOs.
