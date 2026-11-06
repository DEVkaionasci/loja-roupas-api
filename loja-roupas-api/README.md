# Loja de Roupas Online - API

Backend de uma loja de roupas online, desenvolvido para o Projeto Final de
Padrões de Projeto em Aplicações Web (IF Baiano - ADS).

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/br/com/lojaroupas/
│   │   ├── LojaRoupasApiApplication.java
│   │   ├── dao/       # Contratos e implementações de persistência
│   │   ├── dominio/   # Entidades e regras do domínio
│   │   ├── dto/       # Dados de entrada e saída da API
│   │   └── mapper/    # Conversão entre DTOs e entidades
│   └── resources/     # Configurações e recursos da aplicação
└── test/
    └── java/br/com/lojaroupas/  # Testes automatizados
```

## Executar os testes

Na pasta do projeto Maven, execute:

```powershell
.\mvnw.cmd test
```

O projeto requer Java 17 ou superior.

## Domínio

A loja cadastra produtos (roupas com tamanho e estoque), clientes e pedidos.
Cada pedido calcula subtotal, desconto por cupom e frete (padrão, expresso e
com seguro).
