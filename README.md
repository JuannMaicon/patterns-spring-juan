🧩 Patterns Spring Juan

Projeto do desafio Explorando Padrões de Projeto com Java e Spring (DIO).
Aplicação de pedidos com vários padrões: Builder, Singleton, Strategy, Factory, Facade, Template Method.

🚀 Tecnologias

Java 17

Spring Boot 3.5.5

Spring Web • Spring Data JPA • Validation

H2 Database (em memória)

Maven

🛠️ Padrões de Projeto Implementados

Builder → OrderBuilder

Singleton → OrderNumberGenerator

Strategy + Factory → PaymentStrategy + PaymentStrategyFactory

Facade → CheckoutFacade

Template Method → ReceiptTemplate (JsonReceipt / CsvReceipt)

📂 Estrutura de Pacotes
src/
└── main/
    ├── java/
    │   └── com/juan/patterns_spring_juan/
    │       ├── PatternsSpringJuanApplication.java
    │       ├── builder/
    │       │   └── OrderBuilder.java
    │       ├── domain/
    │       │   ├── Order.java
    │       │   ├── OrderItem.java
    │       │   ├── OrderStatus.java
    │       │   └── PaymentType.java
    │       ├── facade/
    │       │   └── CheckoutFacade.java
    │       ├── payment/
    │       │   ├── PaymentResult.java
    │       │   ├── PaymentStrategy.java
    │       │   ├── PaymentStrategyFactory.java
    │       │   ├── PixPaymentStrategy.java
    │       │   ├── CreditCardPaymentStrategy.java
    │       │   └── BoletoPaymentStrategy.java
    │       ├── receipt/
    │       │   ├── ReceiptTemplate.java
    │       │   ├── JsonReceipt.java
    │       │   └── CsvReceipt.java
    │       ├── repository/
    │       │   └── OrderRepository.java
    │       ├── shared/
    │       │   └── OrderNumberGenerator.java
    │       └── web/
    │           ├── OrderController.java
    │           └── dto/
    │               ├── ItemRequest.java
    │               ├── OrderRequest.java
    │               └── OrderResponse.java
    └── resources/
        └── application.properties


Importante: a classe principal PatternsSpringJuanApplication deve estar no pacote raiz
com.juan.patterns_spring_juan para que o Spring escaneie todos os subpacotes (web, facade, repository etc.).

▶️ Como Rodar
# clonar
git clone https://github.com/JuannMaicon/patterns-spring-juan.git
cd patterns-spring-juan

# compilar e subir
mvn clean package
mvn spring-boot:run


H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:patternsdb

User: sa (sem senha)

📌 Endpoints REST
➕ Criar Pedido — POST /api/orders
{
  "paymentType": "PIX",
  "receiptFormat": "JSON",
  "items": [
    { "sku": "A1", "name": "Mouse",   "quantity": 2, "price": 50.0 },
    { "sku": "B2", "name": "Teclado", "quantity": 1, "price": 120.0 }
  ]
}

📜 Listar Pedidos — GET /api/orders
🔎 Buscar por ID — GET /api/orders/{id}
📸 Exemplo de Execução

Coloque um print em docs/example-order.png e referencia aqui:

![exemplo](docs/example-order.png)

🎯 Conclusão

Este projeto demonstra, na prática, como os padrões GoF ajudam a organizar e evoluir um serviço REST em Spring Boot, permitindo adicionar novos meios de pagamento, formatos de recibo e regras de negócio com baixo acoplamento.
