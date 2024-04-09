package com.ekan.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekan.cadastro.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
	Beneficiario getOne(Long id);

	Beneficiario findByName(String name);
	
}