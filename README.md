# Ziplink

Ziplink é um aplicativo desenvolvido em Kotlin com Spring Boot que tem como objetivo encurtar URLs. Ele permite que você crie URLs curtas personalizadas para redirecionar para URLs longas. Esse projeto utiliza o Java 17 e o banco de dados PostgreSQL.

## Configuração do ambiente

Antes de executar o aplicativo, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

*   Java 17 ([https://adoptopenjdk.net/](https://adoptopenjdk.net/))
*   Maven ([https://maven.apache.org/](https://maven.apache.org/))
*   PostgreSQL ([https://www.postgresql.org/](https://www.postgresql.org/))

## Executando o aplicativo

Siga as etapas abaixo para executar o aplicativo Ziplink:

1.  Abra o terminal e navegue até o diretório raiz do projeto.

2.  Execute o seguinte comando para construir o aplicativo:
    <br>
    `mvn clean install`

3.  Após a conclusão da compilação, execute o seguinte comando buildar a imagem docker do aplicativo:
    <br>
    `docker build -t ziplink . `

4.  Em seguida execute 
    <br>
    `make docker-start`

5. O aplicativo será iniciado e estará disponível em `http://localhost:8080`.

## API

O Ziplink fornece as seguintes endpoints da API:

*   `POST /` - Cria uma URL curta para uma URL longa. A requisição deve conter um query parameter chamado fullUrl contendo a url que será encurtada. O retorno do endpoint será o identificador do url encurtado:

*   `GET /{shortUrl}` - Redireciona para a URL longa correspondente à URL curta fornecida.

## Contribuição

Se você quiser contribuir para o projeto Ziplink, siga as etapas abaixo:

1.  Fork este repositório e clone-o para o seu ambiente de desenvolvimento.

2.  Crie um branch para sua nova funcionalidade:

3.  Faça as alterações desejadas e commit-as:

4.  Envie suas alterações para o repositório remoto:

5.  Abra um Pull Request no GitHub.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).