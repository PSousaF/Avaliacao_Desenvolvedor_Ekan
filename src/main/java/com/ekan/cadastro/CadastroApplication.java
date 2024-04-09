package com.ekan.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;



@RestController
@SpringBootApplication
public class CadastroApplication {

	@Hidden
    @GetMapping("/")
    public String getRun() {
    	return "Server is Running";
    }
    
	@Hidden
    @PostMapping("/")
    public String postRun() {
    	return "Server is Running";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

}
