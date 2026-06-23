## 🥷Sistema de Cadastro de Ninjas 

Bem-vindo ao Sistema de Cadastro de Ninjas!
Este projeto é uma aplicação de arquitetura em camadas desenvolvida com Spring Boot, projetada para cadastrar ninjas e suas respectivas missões. O projeto utiliza H2 como banco de dados em memória, Flyway para migrações de banco de dados e segue boas práticas de desenvolvimento de software como controle de versão com Git e hospedagem de repositório no GitHub.

## Visão Geral do Projeto

Atenção: todas as informações contidas nas imagens abaixo são inventadas e meramente ilustrativa.
O foco do projeto não é o frontEnd, mas sim toda parte lógica do BackEnd a fim de melhorar as skills das tecnologias utilizadas.

Este sistema foi desenvolvido para gerenciar ninjas e suas missões. Cada ninja pode ser atribuído a uma única missão, enquanto uma missão pode ser associada a vários ninjas. As principais funcionalidades incluem:

    Cadastro de ninjas com nome, idade, email e rank.
    Atribuição de uma missão para um ninja.
    Gerenciamento de missões e dos ninjas associados a elas.

## 🖥️Tecnologias Utilizadas

    Spring Boot: Para criação da aplicação web e gerenciamento de dependências.
    Banco de Dados H2: Banco de dados em memória para desenvolvimento e testes.
    Flyway: Para gerenciamento de migrações do banco de dados.
    JPA (Java Persistence API): Para mapeamento objeto-relacional (ORM).
    Git: Controle de versão para gerenciamento de mudanças no código.
    GitHub: Hospedagem do repositório para controle de versão.
    Spring Data JPA: Para interação com o banco de dados.
    Maven: Para build e gerenciamento de dependências do projeto.
    SQL: Manipulação do banco de dados
<!-- Docker: Para build externo do banco de dados -->

## 🗄️Design do Banco de Dados

O esquema do banco de dados segue as seguintes relações:

    Ninja: Contém atributos como id, nome, idade, email e rank.
    Missão: Contém atributos como id, título e descrição.
    Um Ninja pode ter apenas uma Missão, mas uma Missão pode ser atribuída a vários Ninjas.

## ⚙️Configuração

    Clone o repositório: git clone https://github.com/WendellTEC/CadastroDeNinjas.git
    Navegue até o diretório do projeto: cd CadastroDeNinjas
    Construa o projeto: mvn clean install
    Execute a aplicação: mvn spring-boot:run
    Acesse a aplicação em http://localhost:8080/ninjas/list/

## 📷Imagens

<img width="1875" height="929" alt="image" src="https://github.com/user-attachments/assets/5a776707-33d7-4ffb-9bfb-8e6633e45621" />

<img width="935" height="868" alt="image" src="https://github.com/user-attachments/assets/47140d1f-4da7-49f2-972b-b8622b80fb94" />

<img width="693" height="929" alt="image" src="https://github.com/user-attachments/assets/90666c6a-203d-4e58-9883-e24aea1998a5" />

<img width="866" height="698" alt="image" src="https://github.com/user-attachments/assets/092d0df9-2248-4770-b658-88f239027f63" />

<img width="1104" height="862" alt="image" src="https://github.com/user-attachments/assets/ebdea963-c97e-4bee-ad2b-021bb5ee45c7" />

<img width="1869" height="609" alt="image" src="https://github.com/user-attachments/assets/bce4a4b2-650b-447e-9457-ad7b06350cb6" />

<img width="857" height="643" alt="image" src="https://github.com/user-attachments/assets/78916115-c06a-4ce8-9057-2ff4bdbc5936" />

<img width="964" height="571" alt="image" src="https://github.com/user-attachments/assets/862ba434-eb07-43f6-afac-c01be37ac088" />

<img width="757" height="510" alt="image" src="https://github.com/user-attachments/assets/f25e9d84-d597-42c8-b416-e604eb783e20" />
