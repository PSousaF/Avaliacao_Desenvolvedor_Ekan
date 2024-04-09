package com.ekan.cadastro.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_beneficiario")
@Entity(name = "tb_beneficiario")
@Schema(description = "Beneficiário")
public class Beneficiario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do beneficiário", example = "1")
    private Long id;
    
    @Column(name = "Nome")
    @Schema(description = "Nome do beneficiário", example = "John Doe")
    private String name;
    
    @Column(name = "Telefone")
    @Schema(description = "Telefone do beneficiário", example = "+55 15 1234-5678")
    private String telefone;
    
    @Column(name = "data_Nascimento")
    @Schema(description = "Data de nascimento do beneficiário", example = "1990-01-01")
    private String data_Nascimento;
    
    @Column(name = "data_Inclusao")
    @Schema(description = "Data de inclusão do beneficiário", example = "2024-04-07")
    private LocalDate data_Inclusao;
    
    @Column(name = "data_Atualizacao")
    @Schema(description = "Data de atualização do registro do beneficiário", example = "2024-04-07")
    private LocalDate data_Atualizacao = LocalDate.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiario that = (Beneficiario) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telefone);
    }
    @Override
    public String toString() {
        return "beneficiario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telefone='" + telefone + '\'' +
                ", data_Nascimento='" + data_Nascimento + '\'' +
                ", data_Inclusao=" + data_Inclusao +
                ", data_Atualizacao=" + data_Atualizacao +
                ", documentoLista=" + documentoLista.size() +
                '}';
    }
    
    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    private List<Documento> documentoLista = new ArrayList<>();

    @JsonProperty("documentoLista")
    public List<Documento> getDocumentoLista() {
        return documentoLista;
    }

    public void setDocumentoLista(List<Documento> documentoLista) {
        this.documentoLista = documentoLista;
    }
}