# E-commerce - Spring Boot

Projeto recriado a partir da estrutura do Blog Pessoal enviado, mantendo a mesma stack: Java 21, Spring Boot 3.5.14, Spring Web, Spring Data JPA, Spring Security, BCrypt, Commons Codec e MySQL.

## Banco
O `application.properties` usa:
- banco: `dbEcommerce`
- usuario: `root`
- senha: `admin`
- porta da API: `8081`

A propriedade `createDatabaseIfNotExist=true` cria o banco automaticamente, desde que o MySQL esteja rodando e as credenciais estejam corretas.

## Entidades
- Usuario
- Categoria
- Produto
- Pedido
- ItemPedido
- UsuarioLogin

## Endpoints principais
### Usuários
- `POST /usuarios` cadastro
- `POST /usuarios/logar` login
- `GET /usuarios`
- `GET /usuarios/{id}`
- `PUT /usuarios`
- `DELETE /usuarios/{id}`

### Categorias
- `POST /categorias`
- `GET /categorias`
- `GET /categorias/buscar/{descricao}`
- `PUT /categorias`
- `DELETE /categorias/{id}`

### Produtos
- `POST /produtos`
- `GET /produtos`
- `GET /produtos/{id}`
- `GET /produtos/nome/{nome}`
- `GET /produtos/categoria/{id}`
- `PUT /produtos`
- `DELETE /produtos/{id}`

### Pedidos
- `POST /pedidos`
- `GET /pedidos`
- `GET /pedidos/{id}`
- `GET /pedidos/usuario/{id}`
- `PUT /pedidos/{id}/status?valor=ENVIADO`

Ao criar um pedido, o sistema valida estoque, grava o preço do produto no momento da compra, calcula o valor total e baixa o estoque.

## Exemplo de cadastro de categoria
```json
{"descricao":"Eletronicos"}
```

## Exemplo de cadastro de produto
```json
{
  "nome":"Mouse Gamer",
  "descricao":"Mouse para computador",
  "preco":149.90,
  "estoque":20,
  "foto":"https://exemplo.com/mouse.jpg",
  "categoria":{"id":1}
}
```

## Exemplo de pedido
```json
{
  "usuario":{"id":1},
  "itens":[
    {"produto":{"id":1},"quantidade":2}
  ]
}
```
