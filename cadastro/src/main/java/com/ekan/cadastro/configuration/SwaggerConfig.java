package com.ekan.cadastro.configuration;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI myOpenAPI() {
	  

    Contact contact = new Contact();
    contact.setEmail("pedroo.sousa@outlook.com.br");
    contact.setName("Pedro Sousa");

    Server devServer = new Server();
    devServer.setUrl("http://localhost:8080");
    devServer.setDescription("URL de Desenvolvimento");

    Server prodServer = new Server();
    devServer.setUrl("http://www.producao.com.br/exemplo");
    prodServer.setDescription("URL de Produção");

    Info info = new Info()
        .title("Cadastro de beneficiários de um plano de saúde")
        .version("1.0")
        .contact(contact)
        .description("""  
        		<strong>Swagger para Avaliação - Desenvolvedor Backend Java</strong>.""").termsOfService("https://swagger.io");

    return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
  }
}
