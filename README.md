📋 Cadastro Genérico - API REST com Spring Boot
Este repositório contém o código-fonte de uma API RESTful para um sistema de cadastro genérico, desenvolvido com Java e o framework Spring Boot.

O projeto serve como um exemplo prático de implementação de um CRUD (Create, Read, Update, Delete), seguindo as melhores práticas de arquitetura em camadas (Controller, Service, Repository) e utilizando o Spring Data JPA para a persistência de dados.

🏛️ Diagrama da Arquitetura do Projeto
O projeto segue uma arquitetura em camadas padrão do Spring Boot, facilitando a manutenção e a separação de responsabilidades. O fluxo de uma requisição HTTP é o seguinte:


## 🧭 Diagrama da Arquitetura

Este diagrama representa o fluxo de requisição da API RESTful utilizando Spring Boot.

![Diagrama da Arquitetura](diagrama/arquitetura.png)


✍️ Descrição das Camadas
Controller: Responsável por expor os endpoints da API (ex: /api/usuarios). Recebe as requisições HTTP, trata os parâmetros de entrada e devolve as respostas (geralmente em formato JSON).

Service: Contém a lógica de negócio da aplicação. É aqui que as regras (validações, cálculos, etc.) são aplicadas antes de acessar ou salvar dados.

Repository: Camada de acesso aos dados. Utiliza o Spring Data JPA para abstrair as consultas ao banco de dados (ex: save(), findById(), findAll()).

Model/Entity: Classes que mapeiam as tabelas do banco de dados (usando anotações da JPA como @Entity e @Id).

✨ Funcionalidades Principais
API RESTful completa para operações de cadastro.

Operações CRUD (Criar, Ler, Atualizar, Deletar).

Arquitetura em camadas para separação de responsabilidades.

Abstração do banco de dados com Spring Data JPA e Hibernate.

(Se aplicável) Validação de dados de entrada com Spring Validation.

(Se aplicável) Banco de dados em memória (H2) para testes e desenvolvimento.

🛠️ Tecnologias Utilizadas
Java (Versão 17+)

Spring Boot (Core, Web, Data JPA)

Spring Data JPA (Para persistência de dados)

Hibernate (Implementação da JPA)

Maven (Gerenciador de dependências e build)

Banco de Dados (Ex: H2, PostgreSQL ou MySQL)

🚀 Como Executar o Projeto
Siga os passos abaixo para executar o projeto em sua máquina local.

Pré-requisitos
JDK (Java Development Kit) 17 ou superior.

Maven 3.6 ou superior.

Uma IDE de sua preferência (IntelliJ, VS Code com Java, Eclipse).

Passos
Clone o repositório:

Bash

git clone https://github.com/robsonjerlley/cadastro-generico.git
cd cadastro-generico
Configure o Banco de Dados (se necessário):

O projeto pode estar configurado para usar um banco em memória (H2), que não exige instalação.

Caso utilize um banco externo (PostgreSQL, MySQL), ajuste as configurações no arquivo src/main/resources/application.properties (ou .yml):

Properties

spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
Execute a aplicação via Maven: (O Maven irá baixar todas as dependências automaticamente)

Bash

mvn spring-boot:run
Acesse a aplicação: Após a inicialização, a API estará disponível em http://localhost:8080.

👨‍💻 Autor
Robson Jerlley

GitHub: robsonjerlley

📄 Licença
Este projeto é distribuído sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
