# Controle Financeiro — API em Java 

## Sobre o projeto

Esse é um projeto de Controle Financeiro que desenvolvi utilizando Java e Spring Boot.

A ideia surgiu durante meus estudos em Java, quando decidi sair um pouco dos exercícios básicos e começar a desenvolver algo mais completo, que pudesse colocar em prática o que venho aprendendo.

O sistema permite cadastrar receitas e despesas, consultar as movimentações financeiras, atualizar informações e excluir registros.

Também implementei um cálculo de saldo, que considera as entradas e saídas cadastradas.

## O que utilizei no projeto

Durante o desenvolvimento, trabalhei com algumas tecnologias que estou estudando:

- **Java 21:** linguagem principal do projeto.
- **Spring Boot:** utilizado para desenvolver a API.
- **Spring Data JPA:** para trabalhar com os dados.
- **H2 Database:** banco de dados utilizado para salvar as transações.
- **Maven:** para gerenciar as dependências.
- **JUnit 5:** para realizar testes automatizados.

## Como funciona?

A aplicação funciona por meio de uma API REST.

Isso significa que, por enquanto, ela não possui uma interface visual como um site. As informações são enviadas e recebidas por requisições HTTP.

Por exemplo, posso cadastrar uma despesa com os seguintes dados:

```json
{
  "descricao": "Supermercado",
  "valor": 150.00,
  "tipo": "DESPESA"
}
```

O sistema recebe essas informações e salva a transação no banco de dados.

Depois, posso consultar todas as transações cadastradas ou buscar uma movimentação específica pelo seu ID.

## Funcionalidades que desenvolvi

- Cadastrar receitas e despesas.
- Listar todas as movimentações.
- Consultar uma transação pelo ID.
- Atualizar uma transação.
- Excluir uma transação.
- Calcular o saldo com base nas receitas e despesas.
- Validar as informações antes de cadastrar.
- Retornar mensagens quando algum dado estiver incorreto.


## Testes

Também comecei a trabalhar com testes automatizados utilizando JUnit.

Criei testes para verificar algumas situações, como:

Cadastro com informações válidas.

Tentativa de cadastrar valores negativos.

Descrição vazia.

Tipo de transação inválido.

Consegui executar os quatro testes de validação com sucesso e também realizar o build do projeto pelo Maven.

Como executar

Para executar o projeto localmente, é necessário ter o Java 21 instalado.

Depois de baixar o projeto, basta abrir a pasta no terminal e executar:

.\mvnw.cmd spring-boot:run

Com a aplicação iniciada, a API estará disponível em:

http://localhost:8080/transacoes

O que aprendi desenvolvendo esse projeto?

Esse projeto foi importante porque consegui entender melhor como funciona uma aplicação backend.

Durante o desenvolvimento, tive contato com Controllers, Services, Repositories, banco de dados, métodos HTTP e validações.

Também enfrentei alguns erros de configuração do Maven e de conexão com o banco H2. Resolver esses problemas fez parte do aprendizado.

Ainda estou evoluindo meus conhecimentos em Java e Spring Boot, mas esse projeto representa um avanço importante nos meus estudos.