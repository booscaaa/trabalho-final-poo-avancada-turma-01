# Sistema de Análise de Sentimentos em Comentários de Produtos

## Visão Geral

API RESTful desenvolvida em Java com Spring Boot para análise automática de sentimentos em comentários de produtos. A aplicação permite gerenciar usuários, produtos e comentários, integrando uma IA para classificar o sentimento dos comentários em cinco níveis: Muito positivo, Positivo, Neutro, Negativo e Muito negativo.

## Estrutura do Projeto

- **Controller**: Expõe os endpoints REST para interação.
- **UseCase (Service)**: Contém a lógica de negócio.
- **Repository**: Acesso e manipulação dos dados no banco.
- **Infraestrutura IA**: Comunicação com API da OpenAI para análise de sentimentos.

## Funcionalidades

- Cadastro, consulta, atualização e exclusão de usuários e produtos.
- Envio de comentários com análise automática de sentimento.
- Consulta de comentários filtrando por produto, usuário ou sentimento.
- Relatórios agregados: total de comentários por sentimento, média de sentimento por produto, ranking dos usuários mais ativos.

## Aplicação dos Princípios SOLID

- **Single Responsibility**: Cada classe tem uma única responsabilidade.
- **Open/Closed**: Sistema aberto para extensão e fechado para modificação.
- **Liskov Substitution**: Uso correto de interfaces e herança.
- **Interface Segregation**: Interfaces específicas para cada contexto.
- **Dependency Inversion**: Uso de abstrações e injeção de dependência via Spring.

## Integração com a IA

- Comunicação via requisição HTTP com API da OpenAI.
- Prompt personalizado para classificação de sentimento.
- Resultado armazenado junto ao comentário no banco.

## Como Rodar o Projeto

1. Configure a variável de ambiente `OPENAI_API_KEY` com sua chave da OpenAI.
2. Configure o banco de dados PostgreSQL (exemplo: crie banco e usuário).
3. Clone o repositório e abra no seu IDE.
4. Execute a aplicação Spring Boot localmente (`mvn spring-boot:run` ou similar).
5. Use ferramentas como Postman, Insomnia ou curl para testar os endpoints.

## Exemplos de Uso dos Endpoints

- **Cadastrar Usuário:**  
  `POST /usuarios`  
  JSON body: `{ "nome": "João", "email": "joao@email.com" }`

- **Cadastrar Produto:**  
  `POST /produtos`  
  JSON body: `{ "nome": "Produto A", "descricao": "Descrição do produto" }`

- **Enviar Comentário com Análise:**  
  `POST /comentarios`  
  JSON body: `{ "descricao": "Ótimo produto!", "produtoId": 1, "usuarioId": 1 }`

- **Consultar Comentários por Sentimento:**  
  `GET /comentarios?sentimento=muito positivo`

## Desafios e Aprendizados

Durante o desenvolvimento, a integração com a API de IA exigiu atenção especial para tratamento de erros, segurança da chave API e interpretação correta da resposta JSON. A aplicação dos princípios SOLID guiou a organização do código, facilitando manutenção e possíveis extensões.

## Melhorias Futuras

- Implementar cache para otimizar chamadas à API externa.
- Suporte multilíngue para análise de comentários.
- Interface web para consulta e visualização de relatórios.
- Inclusão de testes automatizados para garantir qualidade.

---

Obrigado por acompanhar este projeto!  
Victor Tasca Decesare
