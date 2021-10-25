<h2>Digital Innovation: Bootcamp GFT Java & AWS Developer</h2>

Objetivo é demonstrar através de uma API REST, exemplos de alguns padrôes de projeto usando Spring.

<hi> SHOP API gerencia lojas com lista de frutas que comercializa. As informações nutricionais das frutas são obtidas usando API externa https://www.fruityvice.com/doc/index.html#api-GET </hi>

Foram utilizados:

* Setup inicial de projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento (cadastro, leitura, atualização e remoção)
* Relação de cada uma das operações acima com o padrão arquitetural REST
* Utilização e implementações de alguns padrôes de projeto : Singleton, Builder, Facade, DTO, Strategy
* Integração com API externa - https://www.fruityvice.com/doc/index.html#api-GET


Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/shop
```

Exemplo de paylod para inclusão:
```
{
    "name":"Lojas São João",      
    "fruits":[{
        "name":"apple"       
    },{
        "name":"lemon"
    }]    
}
```

Exemplo de paylod para alteração:
```
{
    "id": 4,
    "name": "Lojas São Joaquim",
    "fruits": [
        {
            "genus": "Malus",
            "name": "Apple",
            "id": 6,
            "family": "Rosaceae",
            "order": "Rosales",
            "nutritions": {
                "id": 2,
                "carbohydrates": 11,
                "protein": 0,
                "fat": 0.4,
                "calories": 52,
                "sugar": 10.3
            }
        },
        {
            "genus": "Citrus",
            "name": "Lemon",
            "id": 26,
            "family": "Rutaceae",
            "order": "Sapindales",
            "nutritions": {
                "id": 3,
                "carbohydrates": 9,
                "protein": 1,
                "fat": 0.3,
                "calories": 29,
                "sugar": 2.5
            }
        }
    ]
}
```
Regra de negócio : 

* Quando não existir determinada fruta na API externa, é ignorada.


São necessários os seguintes pré-requisitos para a execução do projeto:

* Java 11 ou versões superiores
* Maven 3.6.3 ou versões superiores
* Visual Studio Code 1.61.0 ou versões superiores
* Controle de versão GitHub integrado na IDE
* Conta no GitHub para o armazenamento do seu projeto na nuvem.


Links úteis:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do VSCode para download](https://code.visualstudio.com/)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)
* [Site oficial do GIT](https://git-scm.com/)
* [Site oficial do GitHub](http://github.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Referência API externa Fruityvice](https://www.fruityvice.com/)
* [Geração de objeto java apartir de JSON](https://www.jsonschema2pojo.org/)
* [Referência JSON](https://www.json.org/json-en.html)