# Entities
# Use Cases
# Interface Adapters
## Controllers
## Gateways (repositories)
## Presenters
# Frameworks and Drivers
## Web
## Database
## External Interfaces
## Devices
## UI

Estrutura de pastas do prof:
    - adapters:
        - Importa os entities
        - Contém as classes de EstudateAdapter e DisciplinaAdapter
        - É utilizando nos controllers
    - api:
        - Import controlers, entities e interfaces
        - Contém a classe FaculdadeApp, que recebe um interfaces.DbConnection e expõem as rotas usando express
    - controller
        - Importa gateways, interfaces, usecases e adapters
        - Contém as classes DisciplinaController, EstudanteController e MatriculaController
        - Invoca os usecases, fazendo o instanciamento do gateway para passar de dependência ao usecase
    - entities
        - Contém as classes Disciplina, Estudante e Matricula
    - external
        - Importa interfaces, types
        - Contém a classe SqliteConnection, que implementa a interface DbConnection para o banco SQLite
    - gateways
        - Importa entities, interfaces, types
        - Contém as classes DisciplinaGateway, EstudanteGateway e MatriculaGateway, que implementam, respectivamente, as
        interfaces DisciplinaGatewayInterface, EstudanteGatewayInterface e MatriculaGatewayInterface
        - As classes tem dependência de um objeto DbConnection para conectar ao banco
    - interfaces
        - Importa entities, types
        - Possuem as interfaces DisciplinaGatewayInterface, EstudanteGatewayInterface, MatriculaGatewayInterface e DbConnection
    - types
        - DTOs?
    - usecases
        - Importa entities, interfaces
        - Contém as classes DisciplinaUseCase, EstudanteUseCase e MatriculaUseCase
        - As classes tem dependência de um objeto gateway para intermediar o acesso ao banco


# Exemplo de call stack:
## Init:
sqlite_connection = external.sqlite_database.SqLiteConnection() // implementação da interface DbConnection
app = api.FaculdadeApp(sqlite_connection: DbConnection)

## POST request para /disciplina:
app.DiscliplinaController.IncluirDisciplina(nome: string, sqlite_connection: DbConnection)
    disciplinaGateway = new DisciplinaGateway(sqlite_connection: DbConnection) // implementação da interface DisciplinaGatewayInterface
    usecases.DisciplinaUseCase.IncluirDisciplina(nome: string, disciplinaGateway: DisciplinaGatewayInterface)
        novaDisciplina = new Disciplina()
        disciplinaGateway.Incluir(novaDisciplina: Disciplina)
            sqlite_connection.Inserir(novaDisciplina: Disciplina)


Controller depende do SqliteConnection
    SqliteConnection implementa DbConnection
Controller utiliza o Gateway
    Gateway implementa GatewayInterface
    GatewayInterface depende do SqliteConnection
Controller utiliza o UseCase
Usecase depende do Gateway