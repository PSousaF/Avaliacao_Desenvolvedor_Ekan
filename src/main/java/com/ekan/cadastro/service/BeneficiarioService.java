package com.ekan.cadastro.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ekan.cadastro.model.Beneficiario;
import com.ekan.cadastro.model.Documento;
import com.ekan.cadastro.repository.BeneficiarioRepository;
import com.ekan.cadastro.repository.DocumentoRepository;

@Service
public class BeneficiarioService {
    @Autowired
    BeneficiarioRepository beneficiarioRepository;

    @Autowired
    DocumentoRepository documentoRepository;


    public void adicionarBeneficiario(Beneficiario data) {
    	Beneficiario beneficiario = new Beneficiario();
    	beneficiario.setName(data.getName());
    	beneficiario.setTelefone(data.getTelefone());
    	beneficiario.setData_Nascimento(data.getData_Nascimento());
    	beneficiario.setData_Inclusao(LocalDate.now());

        for (Documento documentData : data.getDocumentoLista()) {
        	Documento document = new Documento();

            document.setTipo_Documento(documentData.getTipo_Documento());
            document.setDescricao(documentData.getDescricao());
            document.setData_Inclusao(LocalDate.now());
            document.setBeneficiario(beneficiario);
            beneficiario.getDocumentoLista().add(document);
        }

        beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> todosBeneficiarios() {
        return (List<Beneficiario>) beneficiarioRepository.findAll();
    }
    
    public List<Documento> getDocumentosBeneficiario(Long id) {
        return documentoRepository.findByBeneficiarioId(id);
    }
    
    public Beneficiario updateBeneficiario(Long id, Beneficiario beneficiarioUpdate) {
    	Beneficiario upBeneficiario = beneficiarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Beneficiario not found" + id));

    	upBeneficiario.setName(beneficiarioUpdate.getName());
    	upBeneficiario.setTelefone(beneficiarioUpdate.getTelefone());
    	upBeneficiario.setData_Nascimento(beneficiarioUpdate.getData_Nascimento());

        return beneficiarioRepository.save(upBeneficiario);
    }
    

    public void deleteBeneficiario(Long id) {
        try {
            beneficiarioRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("Beneficiario not found" + id + " - " + e.getMessage());
        }
        catch (DataIntegrityViolationException e) {
            throw new NoSuchElementException("Beneficiario not found" + id + " - " + e.getMessage());
        }
    }
}
