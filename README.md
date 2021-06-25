# Exploring Project

### Configuração do projeto
* Clonar o projeto e executar o comando `mvn clean install`
* Executar a classe `ExploringApplication`

### Ou importando via Docker
* Executar o comando `docker pull mariomjr/exploring`
* Comando para subir aplicação `docker run -p 8080:8080 mariomjr/exploring`


### Swagger
* Acessar url `http://localhost:8080/swagger-ui.html` para acessar o swagger dos endpoints

### Acessando banco de dados local
* Banco de dados url `http://localhost:8080/h2-console`
* JDBC URL: `jdbc:h2:mem:dbexploring`
* Username: `sa`
* Password: `1`

## APIs

#### Explorar
`POST /space/explore`

Exemplo de uma entrada:
```json
{
    "spacecraftList": [
        {
            "commands": "LMLMLMLMM",
            "directionInit": "N",
            "xposInit": 1,
            "yposInit": 2
        },
        {
            "commands": "MMRMMRMRRM",
            "directionInit": "E",
            "xposInit": 3,
            "yposInit": 3
        }
    ],
    "xlimit": 5,
    "ylimit": 5
}
```


#### FindAll
`GET /space`

Exemplo de retorno:
```json
[
  {
    "id": 1,
    "spacecraftList": [
      {
        "directionInit": "N",
        "commands": "LMLMLMLMM",
        "directionLast": "N",
        "yposInit": 2,
        "xposInit": 1,
        "xposLast": 1,
        "yposLast": 3
      },
      {
        "directionInit": "E",
        "commands": "MMRMMRMRRM",
        "directionLast": "E",
        "yposInit": 3,
        "xposInit": 3,
        "xposLast": 5,
        "yposLast": 1
      }
    ],
    "ylimit": 5,
    "xlimit": 5
  }
]
```


