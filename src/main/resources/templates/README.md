# 🎟️ SpringTicketHub

Um sistema simples de gerenciamento de eventos e ingressos, desenvolvido com **Spring Boot**, **JPA/Hibernate** e **H2 Database**.  
O projeto permite criar eventos, gerar ingressos automaticamente, consultar, atualizar e remover tickets, além de fornecer rotas documentadas via Swagger.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
    - Spring Web
    - Spring Data JPA
    - H2 Database
- Lombok
- Swagger / Springdoc OpenAPI

---

## 📌 Funcionalidades

### ✅ Eventos
- Criar evento com quantidade de ingressos
- Geração automática dos ingressos ao criar o evento
- Listar eventos
- Consultar evento por ID

### ✅ Tickets (Ingressos)
- Criar ticket manualmente (opcional)
- Listar todos os ingressos
- Consultar por ID
- Atualizar dados do ticket
- Deletar ticket
- Mudança de status (available → sold)

---

## 🗄️ Banco de Dados

O projeto utiliza **H2 em memória** para facilitar testes.

**Acesse o console web do H2:**

