# Loja de Roupas Online – API

Backend de uma loja de roupas online, desenvolvido como Projeto Final da disciplina de **Padrões de Projeto em Aplicações Web**, do IF Baiano – Campus Catu.

## Integrantes
- Kaio Nascimento Sacramento
- Ian Marcel
- Yuri Herold

## Domínio do Problema

A aplicação gerencia uma loja de roupas online, permitindo o cadastro de produtos (com tamanhos e controle de estoque), clientes e pedidos.

Cada pedido realiza automaticamente o cálculo do subtotal, aplicação de descontos por cupom e cálculo do frete, contemplando as modalidades padrão, expresso e com seguro.

## API Externa Consumida

- **ViaCEP API:** [https://viacep.com.br/](https://viacep.com.br/)

  Consumida pelo backend para validar e preencher automaticamente os dados de endereço dos clientes a partir do CEP informado, além de consultar informações de localidade utilizadas no cálculo da entrega dos pedidos.

## Requisitos Funcionais (RF)

- **RF01:** Cadastrar, listar, buscar, atualizar e remover produtos, incluindo informações de tamanho, preço e estoque.
- **RF02:** Cadastrar e gerenciar clientes, garantindo a validação de e-mails únicos e o armazenamento de senhas utilizando hash.
- **RF03:** Consultar e preencher automaticamente os dados de endereço dos clientes por meio da integração com a API externa ViaCEP.
- **RF04:** Registrar pedidos, associando clientes a múltiplos itens.
- **RF05:** Aplicar diferentes estratégias de desconto por cupom durante o cálculo dos pedidos (**Pattern Strategy**).
- **RF06:** Calcular o frete dinamicamente, permitindo a adição de serviços de entrega expressa e seguro (**Pattern Decorator**).
- **RF07:** Atualizar e gerenciar os status dos pedidos, permitindo também o cancelamento com devolução dos itens ao estoque.

## Estrutura do Projeto

```text
src/
├── main/
│   ├── java/br/com/lojaroupas/
│   │   ├── LojaRoupasApiApplication.java
│   │   ├── dao/       # Contratos e implementações de persistência
│   │   ├── dominio/   # Entidades e regras do domínio
│   │   ├── dto/       # Dados de entrada e saída da API
│   │   ├── mapper/    # Conversão entre DTOs e entidades
│   │   └── servico/   # Regras de negócio e integração externa
│   └── resources/     # Configurações e recursos da aplicação
└── test/
    └── java/br/com/lojaroupas/  # Testes automatizados
```