# 💻 Trabalho Final - Java Avançado com Spring Boot e SOLID

## 🎯 Objetivo

Desenvolver uma **API RESTful individual** utilizando **Spring Boot**, aplicando **todos os princípios do SOLID** na prática, com foco em qualidade de código, arquitetura limpa e integração com uma **API de Inteligência Artificial gratuita** para análise de sentimentos em comentários.

---

## 💡 Tema: Sistema de Análise de Sentimentos em Comentários de Produtos

A aplicação deve permitir que usuários publiquem comentários sobre produtos e, ao enviar o comentário, a API realiza uma **análise de sentimento** (positivo, negativo ou neutro) utilizando uma **IA gratuita**. O resultado será armazenado e poderá ser consultado via endpoints específicos.

---

## ✅ Funcionalidades obrigatórias

- Cadastro de usuários
- CRUD de produtos
- CRUD de comentários
- Integração com uma API de IA gratuita para análise de sentimento
- Armazenamento do sentimento junto com o comentário
- Filtros para buscar comentários por:
  - Produto
  - Sentimento
  - Usuário

---

## 📚 Aplicação dos Princípios SOLID

| Princípio | Aplicação Esperada |
|----------|--------------------|
| **S** - Single Responsibility | Separação clara de responsabilidades em serviços, controladores e repositórios |
| **O** - Open/Closed           | Possibilidade de extensão do sistema sem modificar classes existentes |
| **L (se aplicavel)** - Liskov Substitution   | Uso adequado de herança e interfaces substituíveis |
| **I** - Interface Segregation | Interfaces coesas e específicas para cada contexto |
| **D** - Dependency Inversion  | Uso de abstrações e injeção de dependências corretamente aplicada |

---

## ✅ Requisitos mínimos de entrega

A seguir estão os requisitos mínimos que **devem obrigatoriamente estar presentes** no projeto entregue. Cada item será avaliado na apresentação final:

---

### 📌 Estrutura e Organização

- **Menu funcional via endpoints organizados**  
  A API deve apresentar endpoints REST bem definidos, com verbos HTTP apropriados (`GET`, `POST`, `PUT`, `DELETE`) e rotas intuitivas.

- **Código limpo, organizado e comentado**  
  Uso de camadas (controller, usecase, repository), separação de responsabilidades e comentários explicativos nas partes mais relevantes da lógica.

---

### 📌 Endpoints obrigatórios

#### 🧑 Usuários
- `POST /usuarios` — Cadastrar novo usuário  
- `GET /usuarios/{id}` — Buscar usuário por ID  
- `GET /usuarios` — Listar todos os usuários  
- `PUT /usuarios/{id}` — Atualizar dados do usuário  
- `DELETE /usuarios/{id}` — Remover usuário

#### 📦 Produtos
- `POST /produtos` — Cadastrar novo produto  
- `GET /produtos/{id}` — Buscar produto por ID  
- `GET /produtos` — Listar todos os produtos  
- `PUT /produtos/{id}` — Atualizar informações do produto  
- `DELETE /produtos/{id}` — Remover produto

#### 💬 Comentários
- `POST /comentarios` — Enviar comentário (com análise automática do sentimento)  
- `GET /comentarios` — Listar todos os comentários  
- `GET /comentarios/{id}` — Buscar comentário por ID  
- `GET /comentarios?produtoId=1` — Filtrar por produto  
- `GET /comentarios?usuarioId=1` — Filtrar por usuário  
- `GET /comentarios?sentimento=positivo` — Filtrar por sentimento

#### 📊 Relatórios
- `GET /relatorios/sentimentos` — Retornar total de comentários por sentimento  
- `GET /relatorios/produtos` — Média de sentimento por produto  
- `GET /relatorios/usuarios` — Ranking de usuários mais ativos

---

### 📌 Regras de Negócio

- **Classificação com pelo menos 5 tipos de sentimentos distintos**  
  A lógica do sistema deve reconhecer e tratar diferentes nuances de sentimentos, como:
  - Muito positivo
  - Positivo
  - Neutro
  - Negativo
  - Muito negativo

- **Sistema de pontuação ou destaque baseado em comentários**  
  Por exemplo:
  - Usuários com maior número de comentários positivos podem ser destacados
  - Produtos com maior número de sentimentos positivos podem ganhar selo de destaque

- **Endpoint de relatório ou agregação**
  - Um endpoint especial deve retornar estatísticas ou visão geral do sistema

---

Esses requisitos representam o **mínimo esperado** para garantir o funcionamento correto e coerente do projeto. Funcionalidades adicionais, criatividade na lógica e documentação caprichada serão valorizadas.

---

## 📌 Observações

- A aplicação deve rodar localmente via `Spring Boot`
- O projeto é individual
- Criatividade e organização serão valorizadas
- Atenção à clareza e manutenção do código

---

## 🎥 Apresentação do Projeto

Criar slides abordando os seguintes pontos:

- Sua versão única da proposta do sistema
- Fluxo geral da aplicação (com diagramas ou prints dos endpoints)
- Como foi feita a integração com a IA
- Como os princípios do SOLID foram aplicados
- Principais dificuldades enfrentadas no desenvolvimento
- Demonstração do sistema em execução (pode ser por curl/Postman/Insomnia/Bruno
- Melhorias futuras planejadas

---

## 📋 Requisitos do GitHub

- Criar uma **branch individual** neste repositório público no GitHub
- Manter um **histórico de commits claro**, com mensagens descritivas e progressivas
- Incluir:
  - Código fonte submetido via **Pull Request**
  - `README.md` com:
    - Descrição do projeto
    - Como rodar o projeto
    - Como usar os endpoints (ex: curl ou Postman)
    - Aplicação dos princípios SOLID
    - Desafios e aprendizados (curto parágrafo)

---

## ✅ Critérios de Avaliação

| Critério                                         | Pontos |
|--------------------------------------------------|--------|
| Funcionalidades completas                        | 40     |
| Aplicação correta dos princípios SOLID           | 30     |
| Organização e clareza do código                  | 15     |
| Documentação (README, curl/Postman/Insomnia/Bruno e apresentação)    | 15     |
| **Total**                                        | **100**|

---

## 🚫 Sobre Comentários no Código

**Não serão aceitos comentários no código-fonte.**

O objetivo deste trabalho é avaliar sua capacidade de escrever **código limpo, autoexplicativo e bem estruturado**, utilizando boas práticas de nomenclatura, separação de responsabilidades e organização em camadas.

> Se for necessário explicar uma regra de negócio, fluxo ou decisão de projeto, isso deve estar documentado no `README.md`, não dentro do código.

Seu código será avaliado por:
- **Nomes de variáveis, funções e classes claros e semânticos**
- **Arquitetura bem definida e separação de responsabilidades**
- **Fluxo de execução compreensível sem necessidade de comentários**

Evite:
- Comentários como `// salva no banco` ou `// faz a verificação`
- Comentários redundantes explicando o óbvio

Comunique-se **através do seu código**.

- TRABALHO FINAL 

- Descrição do Projeto: Este projeto é uma API RESTful em Java com Spring Boot, que permite que usuários façam comentários sobre produtos. Cada comentário é analisado automaticamente por uma IA (via API Hugging Face) que classifica o sentimento como muito positivo, positivo, neutro, negativo ou muito negativo. 
A arquitetura segue os princípios SOLID, com camadas bem definidas (Controller, Service e Repository), 
uso de JPA para persistência em banco PostgreSQL e integração com a IA via HTTPClient. O sistema oferece CRUD completo de comentários e organização clara do código.


-COMO RODAR O PROJETO: Roda através dos endpoints

-COMO USAR OS ENDPOINTS:atraves do local host da API Bruno

POST adicionar usuario
POST adicionar comentario
POST adicionar produto
DEL usuario
DEL produto
GET listar usuario
GET listar produuto
GET listar comentario


- APLICAÇÂO DOS PRINCIPIOS SOLID

- SRP
ComentarioController: cuida das requisições HTTP.

ComentarioService: trata as regras de negócio.

IAService: apenas classifica sentimentos com a IA.

ComentarioRepositoryImpl: lida só com o banco de dados.

- OCP
  A lógica de sentimento pode ser alterada (ex: outro modelo de IA) estendendo IAService, sem modificar o restante do sistema.

- ISP
  A interface ComentarioRepository só exige os métodos essenciais ao seu contexto (não obriga implementação de métodos desnecessários para outras entidades).

- DIP
  As camadas dependem de abstrações (ComentarioRepository, ComentarioUseCase) e não de implementações diretas, permitindo fácil troca e teste.


- DESAFIOS E APRENDIZADOS
 Um dos maiores desafios pra mim foi fazer a ligação com a ia, 
eu ja não sabia muito fazer o CRUD, precisei be basear em outro trabalho
que já tinha feito no semestre passado, mas agora estou entendo um pouco mais 
de como funciona, consegui entender um pouco mais. 



