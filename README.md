# JWT no Spring 

Implementação do JWT no Spring.

## Getting Started

Siga estas instruções para copiar e executar este projeto em seu ambiente de desenvolvimento.

* Clone o repositório https://github.com/utfpr-gp/jwt-spring.git para o seu workspace.
* Faça o download das dependências do Maven registradas no arquivo pom.xml.

## Funcionamento

* Instale o Postman ou outra ferramenta cliente para serviços REST.
* Acesse via POST o endereço http://localhost:8080/auth para obter o token para autenticação e envie o seguinte JSON
```json
{
	"email": "admin@utfpr.edu.br",
	"password": "qwerty"
}
````
* O retorno esperado é algo assim:
```json
{
    "data": {
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB1dGZwci5lZHUuYnIiLCJyb2xlIjoiUk9MRV9BRE1JTiIsImNyZWF0ZWQiOjE1NDIwMjg5MDk3MTIsImV4cCI6MTU0MjAyOTUxNX0.lY4Tq5iVdihZtaLZ22CE8ZupLr3xbC12e3fRJYcOsa7ygmrpxjnSSb14wwaTn-ddXtpAJ-d1fZP3XBAueVttSQ"
    },
    "errors": []
}
```
* Copie o token retornado para acessar um caminho protegido por autenticação e autorização de usuários no perfil de ADMIN. 
* No projeto, para questão de testes, este caminho é o seguinte: http://localhost:8080/api/exemplo/João
* Acesse o caminho informado via GET e atribua o token como valor ao cabeçalho Authorization da requisição. Isso deve ser feito prefizando o token com a palavra "Bearer " seguida por um espaço. Mais precisamente, o cabeçalho deve ficar assim:
```json
Authorization:Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkB1dGZwci5lZHUuYnIiLCJyb2xlIjoiUk9MRV9BRE1JTiIsImNyZWF0ZWQiOjE1NDIwMjg5MDk3MTIsImV4cCI6MTU0MjAyOTUxNX0.lY4Tq5iVdihZtaLZ22CE8ZupLr3xbC12e3fRJYcOsa7ygmrpxjnSSb14wwaTn-ddXtpAJ-d1fZP3XBAueVttSQ
Content-Type:application/json
```
* Feito isso, o retorno da requisição será a frase:
```
Olá João
```
