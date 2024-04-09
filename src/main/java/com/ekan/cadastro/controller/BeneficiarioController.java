package com.ekan.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekan.cadastro.model.Beneficiario;
import com.ekan.cadastro.model.Documento;
import com.ekan.cadastro.service.BeneficiarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/beneficiarios")
@CrossOrigin(origins = "http://localhost:4200") 
@Tag(name = "Beneficiarios", description = "Dados do beneficiário")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Operation(
    	      summary = "Cadastro do beneficiário",
    	      description = "Cadastras um novo beneficiário juntamente com seus respectívos documentos.")
    	  @ApiResponses({
    	      @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
    	      @ApiResponse(responseCode = "404", description = "Não encontrado", content = { @Content(schema = @Schema()) }),
    	      @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = { @Content(schema = @Schema()) }) })
    @PostMapping(value = "/cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
    public Beneficiario cadastroBeneficiario(@RequestBody Beneficiario beneficiario) {
    	beneficiarioService.adicionarBeneficiario(beneficiario);
        return beneficiario;
    }
    
    @Operation(
  	      summary = "Listar beneficiários",
  	      description = "Listar todos beneficiários cadastrados.")
  	  @ApiResponses({
  	      @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
  	      @ApiResponse(responseCode = "404", description = "Não encontrado", content = { @Content(schema = @Schema()) }),
  	      @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<Beneficiario> TodosBeneficiarios() {
    	List<Beneficiario> beneficiaries = beneficiarioService.todosBeneficiarios();
        return beneficiaries;
    }
    
    @Operation(
    	      summary = "Listar documentos cadastrado do beneficiário",
    	      description = "Busca o beneficiário juntamente com seus respectívos documentos.")
    	  @ApiResponses({
    	      @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
    	      @ApiResponse(responseCode = "404", description = "Não encontrado", content = { @Content(schema = @Schema()) }),
    	      @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = { @Content(schema = @Schema()) }) })
    @GetMapping(value = "/documentos/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public List<Documento> docBeneficiarioPorId(@PathVariable Long id) {
    	List<Documento> beneficiaries = beneficiarioService.getDocumentosBeneficiario(id);
        return beneficiaries;
    }	
    
    @Operation(
  	      summary = "Atualizar dados do beneficiário",
  	      description = "Atualiza o beneficiário selecionado.")
  	  @ApiResponses({
  	      @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
  	      @ApiResponse(responseCode = "404", description = "Não encontrado", content = { @Content(schema = @Schema()) }),
  	      @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = { @Content(schema = @Schema()) }) })
    @PutMapping(value = "/atualiza/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Beneficiario atualizaBeneficiario(@PathVariable Long id, @RequestBody Beneficiario dadosBeneficiario) {
    	beneficiarioService.updateBeneficiario(id,dadosBeneficiario);
        return dadosBeneficiario;
    }

    @Operation(
    	      summary = "Excluir beneficiário",
    	      description = "Exclui o beneficiário selecionado.")
    	  @ApiResponses({
    	      @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
    	      @ApiResponse(responseCode = "404", description = "Não encontrado", content = { @Content(schema = @Schema()) }),
    	      @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(value = "/deletar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Beneficiario> deletarBeneficiario(@PathVariable Long id) {
    	beneficiarioService.deleteBeneficiario(id);
        return ResponseEntity.ok().build();
    }
}
