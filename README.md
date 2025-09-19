# 📞 Contact API - Gerenciamento de contatos
 API REST desenvolvida em **Spring Boot (Java 21)** como parte da disciplina de Laboratório de Programação na Universidade Estadual de Londrina (UEL).  
 
Permite **cadastrar, listar, buscar, atualizar e remover contatos**, com validação de dados e integração com **MySQL**.

## 📌 Endpoints
### 🔹 Listar contatos
```payload
GET /contacts
```

### 🔹 Buscar contato por ID
```payload
GET /contacts/{id}
```

### 🔹 Criar novo contato
```payload
POST /contacts
```
Content-Type: application/json

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "telefone": "11999999999",
  "idade": 25,
  "dataNascimento": "2000-01-15"
}
```

### 🔹 Atualizar contato
```payload
PUT /contacts/{id}
```
Content-Type: application/json

```json 
{
  "nome": "João da Silva",
  "email": "joao.silva@email.com",
  "telefone": "11988888888",
  "idade": 26,
  "dataNascimento": "1999-12-10"
}
```

### 🔹 Remover contato
```payload
DELETE /contacts/{id}
```

## 🧪 Testes com Postman

Importe os endpoints acima no Postman.

Use http://localhost:8080/contacts como base URL.

Teste os métodos GET, POST, PUT e DELETE.

