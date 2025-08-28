🧩 Patterns Spring Juan

Projeto do desafio Explorando Padrões de Projeto com Java e Spring (DIO).
API de pedidos aplicando alguns padrões de projeto (GoF + Spring).

🚀 Tecnologias

Java 17

Spring Boot 3.5.5 (Web, Validation, Data JPA)

H2 Database (em memória)

Maven

🛠️ Padrões aplicados

Builder – construção de Order

Singleton – gerador de número do pedido

Strategy + Factory – meios de pagamento (PIX, Boleto, Cartão)

Facade – orquestração do checkout

Template Method – geração de recibo (JSON/CSV)

▶️ Como rodar
mvn clean package
mvn spring-boot:run


H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:patternsdb

User: sa (sem senha)

📌 Endpoints
Criar pedido

POST /api/orders
Body (JSON):

{
  "paymentType": "PIX",
  "receiptFormat": "JSON",
  "items": [
    { "sku": "A1", "name": "Mouse", "quantity": 2, "price": 50.0 },
    { "sku": "B2", "name": "Teclado", "quantity": 1, "price": 120.0 }
  ]
}

Listar pedidos

GET /api/orders

Buscar por id

GET /api/orders/{id}

💻 Teste rápido (PowerShell)
Invoke-RestMethod http://localhost:8080/api/orders -Method POST `
  -ContentType "application/json" `
  -Body '{
    "paymentType": "PIX",
    "receiptFormat": "JSON",
    "items": [
      { "sku": "A1", "name": "Mouse",   "quantity": 2, "price": 50.0 },
      { "sku": "B2", "name": "Teclado", "quantity": 1, "price": 120.0 }
    ]
  }'

Invoke-RestMethod http://localhost:8080/api/orders -Method GET

🎯 Conclusão

Este projeto demonstra, na prática, como os padrões GoF ajudam a organizar e evoluir um serviço REST em Spring Boot, permitindo adicionar novos meios de pagamento, formatos de recibo e regras de negócio com baixo acoplamento.
