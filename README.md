<p align="center">
  <img width="30%" src="images/logo eric hiroshi.png" alt="Backend Brasil Logo">
</p>

<h3 align="center">MS STORE</h3>

<p align="center">
  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-Java%2021-blue">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">
</p>

---

## 🧭 Visão Geral

Este projeto consiste em uma arquitetura de microserviços para uma loja digital. Cada microserviço é independente, construído com Spring Boot e Maven, e comunica-se com os demais via REST. O objetivo é exemplificar boas práticas de desenvolvimento de microserviços, incluindo registro no Eureka, segurança, e persistência em memória.

---

## 📚 Sumário

- [🧭 Visão Geral](#-visão-geral)
- [📚 Sumário](#-sumário)
- [⚙️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [🚐 Estrutura dos Microserviços](#-estrutura-dos-microserviços)
- [🚀 Execução do Projeto](#-execução-do-projeto)
  - [✅ Pré-requisitos](#-pré-requisitos)
  - [📥 Clonar o repositório](#-clonar-o-repositório)
  - [▶️ Rodar Microserviços](#️-rodar-microserviços)
  - [💾 Banco de Dados](#-banco-de-dados)
- [💬 Interagindo com a API](#-interagindo-com-a-api)
- [📬 Endpoints e Exemplos](#-endpoints-e-exemplos)
- [👁️ Observações](#️-observações)
- [🤝 Contribuições](#-contribuições)
- [🔗 Referências e Créditos](#-referências-e-créditos)

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|-------------|-------------|
| ☕ **Java 21** | Linguagem principal |
| 🍃 **Spring Boot 3.4.2** | Framework de aplicação |
| 🧩 **Spring Data JPA** | Persistência e mapeamento com H2 Database |
| 💾 **H2 Database** | Banco de dados em memória para testes |
| ⚡ **Spring Boot DevTools** | Hot reload e ferramentas de desenvolvimento |
| 🩺 **Spring Boot Actuator** | Monitoramento e métricas da aplicação |
| 🌐 **Spring Web (Spring MVC)** | Criação de endpoints RESTful |
| 🌎 **Spring Cloud OpenFeign** | Integração com APIs externas (autorização e notificação) |
| 🍃 **Spring Cloud Netflix Eureka** | Eureka Server para descoberta de serviços |
| 🏹 **Spring Cloud Gateway** | Rotear requisições para API |
| 🧰 **Lombok** | Redução de boilerplate |

---

## 🚐 Estrutura dos Microserviços
O projeto possui os seguintes microserviços:

1. **ms-store-eureka-server** – Servidor Eureka para registro e descoberta de serviços.
2. **ms-store-api-gateway** – Rotear requisições para API.
3. **ms-user** – Microserviço de usuários.
4. **ms-store** – Processamento de pedidos.
5. **ms-payment** – Processamento de pagamentos.
6. **ms-product** – Gerenciamento de produtos.

---

## 🚀 Execução do Projeto

### ✅ Pré-requisitos
- Java 21
- Maven
- IDE (IntelliJ, STS, VS Code, etc.)

### 📥 Clonar o repositório

```bash
git clone https://github.com/erichiroshi/ms-store
cd store
```

### ▶️ Rodar Microserviços
1. Inicialize o **Eureka Server** (`ms-store-eureka-server`).
2. Execute cada microserviço via Maven:
```bash
./mvnw spring-boot:run
```
ou pela IDE.

3. Acesse os endpoints de cada microserviço via API GATEWAY: `http://localhost:8765/nome-do-serviço`.
  
   Exemplo: http://localhost:8765/ms-user/users

### 💾 Banco de Dados

Por padrão, a aplicação utiliza o **h2-Database**.  
Para acessar o console:  👉 [http://localhost:[verificar a porta]/h2-console](http://localhost:8080/h2-console)
- Utilizar credências conforme configurado no application.properties de cada microserviço.

---

## 💬 Interagindo com a API

As requisições podem ser testadas via Postman ou Insomnia.
- Json para importar no postman: [json](postman/ms-store.postman_collection.json).


## 📬 Endpoints e Exemplos
Exemplo de endpoints de cada microserviço: http://localhost:8765/[nome-microserviço]/[endpoint]

- **ms-user**
  - `POST /users` – Cria um usuário
  - `GET /users` – Busca todos usuários
  - `GET /users/{id}` – Busca um usuário

- **ms-product**
  - `GET /products` – Lista todos os produtos
  - `GET /products/{id}` – Busca um produto

- **ms-payment**
  - `GET /payments` – Busca todos pagamentos

- **ms-store**
  - `POST /orders/payments/{id}` – Processa pagamento para order id
  - `GET /orders` – Busca todas as ordens
  - `GET /orders/{id}` –  Busca uma ordem

---

## 👁️ Observações
- Todos os microserviços se registram automaticamente no Eureka Server.
- Consultar Spring Eureka Server, verificar serviços registrados. http://localhost:8761/
- Pode levantar mais de uma instância de cada serviço. Portas aleatórias descobertas pelo Eureka.
- O Spring Cloud Gateway concentra todos os serviços em uma única porta: 8765.
- Para testes locais, utilize Postman ou Insomnia para consumir os endpoints.

---

## 🤝 Contribuições

Contribuições são sempre bem-vindas!  
Para contribuir:

1. Crie um fork do repositório.  
2. Crie uma branch de feature:  
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Commit suas mudanças:  
   ```bash
   git commit -m "feat: nova funcionalidade"
   ```
4. Envie um Pull Request.  

📜 **Boas práticas**
- Adicione testes unitários.  
- Documente suas alterações no código.  
- Use mensagens de commit seguindo o padrão **Conventional Commits**.

---

## 🔗 Referências e Créditos

- Baseado no curso do professor Nelio Alves [Udemy](https://www.udemy.com/course/java-curso-completo/learn/lecture/15988652#overview)
- Repositório: [ms-store](https://github.com/erichiroshi/ms-store)
- Desenvolvido por [**Eric Hiroshi**](https://github.com/erichiroshi)
- Licença: [MIT](LICENSE)

---