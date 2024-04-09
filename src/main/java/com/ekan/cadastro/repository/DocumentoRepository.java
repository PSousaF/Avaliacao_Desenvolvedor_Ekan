package com.ekan.cadastro.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ekan.cadastro.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    Documento getOne(Long id);

    List<Documento> findByBeneficiarioId(Long beneficiarioId);

}