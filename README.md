
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white

<h1 center="center" style="font-weight: bold;">Pedidos 💻</h1>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]

<p center="center">
 <a href="#started">Vamos Começar</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Colaboradores</a>
</p>

<p center="center">
  <b>Implementação de sistema automatizado para otimizar o atendimento em lanchonete em expansão.</b>
</p>

<b>Tech Challenge - Fiap 6SOAT</b>

<h2 id="started">🚀 Vamos Começar</h2>

Configurações locais e APIs prontas para uso.

<h3>Pré requisitos para o projeto:</h3>

- [Java](https://github.com/)
- [Spring](https://github.com/)
- [Docker](https://github.com/)
- [Git](https://github.com)

<h3>Instalação</h3>

Como clonar o nosso projeto:

```bash
git clone git@github.com:felipefrsilva/pedidos.git
```

Para rodar o projeto, verfique as versões do Docker e Docker Compose >= :
- Docker version 26.1.3
- Docker Compose version v2.27.0


```bash
cd docker
docker compose up -d
```
Após finalizar o processo de configuração e a subida do container, acesse o endereço abaixo para visualizar a documentação da API.
<h3>Swagger</h3>
A docuemntação da API disponível em:
```localhost:8080/swagger-ui.html```

<h3>Ordem de execução</h3>
- Product Menagement - Gerenciamento de produtos.
- Service Client - Gerenciamento de clientes.
- Service Order - Inicialização do pedido e escolha de produtos.
- Payment Order - Pagamento do pedido.
- Tracker Order - Acompanhamento da preparação do pedido.

<h3>Requisitos</h3>
Acesse os requisitos do negócio (situação problema) através deste <a href="https://miro.com/app/board/uXjVMK9tIRA=/?share_link_id=369503759541">link</a>(MIRO).
Lá, você encontrará um conjunto de artefatos que detalham o negócio, utilizando as práticas de DDD e o Event Storm.

<h2 id="colab">🤝 Colaboradores</h2>

Um agradecimento especial a todas as pessoas que contribuíram para este projeto.

<table>
  <tr>
    <td center="center">
      <a href="#">
        <img  src="https://avatars.githubusercontent.com/u/85134851?v=4" width="100px; " alt="Felipe Silva Profile"/><br>
        <sub>
          <b>Felipe Silva</b>
        </sub>
      </a>
    </td>
    <td center="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/12815292?v=4" width="100px;" alt="Jubel Profile"/><br>
        <sub>
          <b>Jubel Cassio</b>
        </sub>
      </a>
    </td>
    <td center="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/77970318?v=4" width="100px;" alt="Ingrid Profile"/><br>
        <sub>
          <b>Ingrid Queiroz</b>
        </sub>
      </a>
    </td>
   <td center="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/128048923?v=4" width="100px;" alt="Axel Profile"/><br>
        <sub>
          <b>Axel Kjellin</b>
        </sub>
      </a>
    </td>
    <td center="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/15820028?v=4" width="100px;" alt="Eder Profile"/><br>
        <sub>
          <b>Eder Brito</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h3>Documentações que podem te ajudar</h3>

[📝 Como criar um Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Padrões de Commit](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)