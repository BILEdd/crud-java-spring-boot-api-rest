# 📅 Agendador de Horários — CRUD Spring Boot + REST API

> 🚧 Projeto em desenvolvimento — sendo construído como parte do meu portfólio.

## 📖 Sobre o Projeto

API REST para **agendamento de horários**, desenvolvida em Java com Spring Boot.
Permite criar, listar, atualizar e deletar agendamentos, com persistência em banco de dados H2 em memória.

---

## ✅ Funcionalidades

- [x] Criar agendamento
- [x] Listar todos os agendamentos
- [x] Buscar agendamento por ID
- [x] Atualizar agendamento
- [x] Deletar agendamento

---

## 🔗 Endpoints

| Método | Endpoint              | Descrição                        |
|--------|-----------------------|----------------------------------|
| POST   | `/agendamentos`       | Cria um novo agendamento         |
| GET    | `/agendamentos`       | Lista todos os agendamentos      |
| GET    | `/agendamentos/{id}`  | Busca agendamento por ID         |
| PUT    | `/agendamentos/{id}`  | Atualiza um agendamento          |
| DELETE | `/agendamentos/{id}`  | Remove um agendamento            |

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de Dados H2 (em memória)
- Maven

---

## 🗄️ Console H2

Após rodar o projeto, acesse o banco de dados pelo navegador:
