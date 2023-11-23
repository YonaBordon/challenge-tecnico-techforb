# Challenge TechForb

Este proyecto está construido con Spring Boot y utiliza MySQL para la base de datos, Spring Security para la autenticación y JSON Web Token (JWT) para la gestión de sesiones.

## Instalación

1. Clona el repositorio
2. Accede a "localhost:8080" para usar


## Endpoints

### Controlador de Usuario

- `POST /api/user/register`: Registra un nuevo usuario.


```json
{
	"username": "exampleUser",
	"email": "example@email.com",
	"password": "examplePassword"
}
```

- `POST /api/user/login`: Inicia sesión con un usuario existente.


```json
{
	"username": "exampleUser",
	"password": "examplePassword"
}
```

Respuesta de ejemplo:

```json
{
	"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlVXNlciIsImlhdCI6MTYxNzYzNzI4MiwiZXhwIjoxNjE3NzIzNjgyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c",
	"type": "Bearer",
	"username": "exampleUser",
	"message": "Login successful"
}
```

### Controlador de Transacciones

- `POST /api/transaction`: Crea una nueva transacción.

```json
{
	"idDestino": "destinationAccountId",
	"monto": 100.0,
	"descripcion": "Transaction description"
}
```

Respuesta de ejemplo:

```json
{
	"origen": "originAccountId",
	"destino": "destinationAccountId",
	"monto": 100.0,
	"descripcion": "Transaction description",
	"fecha": "2022-01-01T00:00:00.000+00:00"
}
```

## Tecnologías

- Spring Boot
- Spring Security
- MySQL
- Lombok
- JSON Web Token (JWT)
- Maven 