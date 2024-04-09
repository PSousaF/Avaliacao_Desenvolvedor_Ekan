# Cadastro de Beneficiários - API REST

Uma API RESTful básica utilizando Spring Boot para gerenciar o cadastro de beneficiários de um plano de saúde.

## Funcionalidades e EndPoints

- Cadastro de beneficiários com documentos associados.
- Listagem de todos os beneficiários cadastrados.
- Consulta dos documentos de um beneficiário específico.
- Atualização dos dados cadastrais de um beneficiário.
- Remoção de um beneficiário.
  
![image](https://github.com/PSousaF/Avaliacao_Desenvolvedor_Ekan/assets/81575097/ddd74110-3b23-4ab1-871a-673263f4308a)

 Acesse a documentação dos endpoints em http://localhost:8080/swagger-ui.html.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Facilita a implementação de camadas de persistência.
- **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
- **Lombok**: Biblioteca para reduzir a verbosidade do código.
- **Swagger**: Ferramenta para documentação e teste de APIs REST.

## Como Executar o Projeto

1. Certifique-se de ter o Java 17 instalado em sua máquina.
2. Clone este repositório em seu ambiente local.
3. Navegue até o diretório raiz do projeto.
4. Execute o seguinte comando para construir o projeto:


   ```bash
   mvn clean package

  
Após o build ser concluído com sucesso, você pode executar a aplicação com o seguinte comando:
java -jar target/cadastro-0.0.1-SNAPSHOT.jar

Contribuição
Contribuições sempre são bem-vindas!

