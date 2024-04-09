package com.ekan.cadastro.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tb_documento")
@Table(name = "tb_documento")
@Schema(description = "Documento do beneficiário")
public class Documento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do documento", example = "1")
    private Long id;
    
    @Column(name = "tipo_Documento")
    @Schema(description = "Tipo do documento", example = "RG")
    private String tipo_Documento;
    
    @Column(name = "descricao")
    @Schema(description = "Descrição do documento", example = "Registro Geral")
    private String descricao;
    
    @Column(name = "data_Inclusao")
    @Schema(description = "Data de inclusão do documento", example = "2024-04-07")
    private LocalDate data_Inclusao;
    
    @Column(name = "data_Atualizacao")
    @Schema(description = "Data de atualização do documento", example = "2024-04-07")
    private LocalDate data_Atualizacao = LocalDate.now();
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
}
