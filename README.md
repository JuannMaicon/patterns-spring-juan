🧩 Patterns Spring Juan

Projeto desenvolvido como parte do desafio "Explorando Padrões de Projeto com Java e Spring" da Digital Innovation One (DIO).
O objetivo foi implementar uma aplicação de pedidos de forma simples, aplicando padrões de projeto (GoF + Spring) para organizar o código e facilitar a manutenção/expansão.

🚀 Tecnologias

Java 17

Spring Boot 3.5.5

Spring Data JPA

H2 Database (em memória)

Maven

🛠️ Padrões de Projeto Implementados

Builder → OrderBuilder: usado para construir o objeto Order passo a passo.

Singleton → OrderNumberGenerator: garante sequência única para números de pedido.

Strategy + Factory → PaymentStrategy + PaymentStrategyFactory: escolha da forma de pagamento (PIX, Boleto, Cartão de Crédito).

Facade → CheckoutFacade: concentra toda a lógica de fluxo do pedido (montagem, pagamento, persistência, recibo).

Template Method → ReceiptTemplate: diferentes formatos de recibo (JSON e CSV).

📂 Estrutura de Pacotes
src/main/java/com/juan/patterns_spring_juan
│
├── builder          # Implementação do Builder (OrderBuilder)
├── domain           # Entidades principais (Order, Item, PaymentType, etc.)
├── facade           # CheckoutFacade (Facade Pattern)
├── payment          # Estratégias de pagamento (Strategy + Factory)
├── receipt          # Geração de recibos (Template Method)
├── repository       # Spring Data JPA (persistência)
├── shared           # Utilidades (ex: OrderNumberGenerator - Singleton)
└── web/dto          # DTOs e Controllers REST

▶️ Como Rodar

Clone este repositório

git clone https://github.com/JuannMaicon/patterns-spring-juan.git
cd patterns-spring-juan


Compile e rode a aplicação:

mvn clean package
mvn spring-boot:run


Acesse no navegador:

http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:patternsdb | User: sa | Password: vazio)

📌 Endpoints REST
➕ Criar Pedido

POST /api/orders

Exemplo (JSON):

{
  "paymentType": "PIX",
  "receiptFormat": "JSON",
  "items": [
    { "sku": "A1", "name": "Mouse", "quantity": 2, "price": 50.0 },
    { "sku": "B2", "name": "Teclado", "quantity": 1, "price": 120.0 }
  ]
}


Resposta:

{
  "id": 1,
  "orderNumber": "ORD-2025-08-28-0001",
  "status": "PAID",
  "paymentType": "PIX",
  "total": 220.0,
  "transactionId": "PIX-95ed3bc1-b140-4ba0-8193-0a2c651a4b31",
  "receipt": "{ ... JSON gerado ... }"
}

📜 Listar Pedidos

GET /api/orders

🎯 Conclusão

Este projeto mostrou como aplicar diferentes padrões de projeto (GoF) dentro de um contexto prático usando Spring Boot.
Além de organizar melhor o código, os padrões facilitam a evolução da aplicação (ex: adicionar novos meios de pagamento, novos formatos de recibo, etc.).