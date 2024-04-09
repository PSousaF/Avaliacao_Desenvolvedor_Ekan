package com.ekan.cadastro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ekan.cadastro.model.Beneficiario;
import com.ekan.cadastro.model.Documento;
import com.ekan.cadastro.repository.BeneficiarioRepository;
import com.ekan.cadastro.repository.DocumentoRepository;
import com.ekan.cadastro.service.BeneficiarioService;



public class TestBeneficiarioController {
    @InjectMocks
    private BeneficiarioService beneficiarioService;

    @Mock
    private BeneficiarioRepository beneficiarioRepository;

    @Mock
    private DocumentoRepository documentoRepository;
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testeCriarBeneficiario() {
        Beneficiario data = new Beneficiario();
        data.setName("Pedro Sousa");
        data.setTelefone("997730000");
        data.setData_Nascimento("01/01/1983");

        Documento dataDoc = new Documento();
        dataDoc.setTipo_Documento("CPF");
        dataDoc.setDescricao("387.456.159-99");
        data.getDocumentoLista().add(dataDoc);

        beneficiarioService.adicionarBeneficiario(data);
        System.out.println(data.toString());
        verify(beneficiarioRepository).save(any(Beneficiario.class));

     }
    @Test
    void testListarlBeneficiarios() {
        List<Beneficiario> beneficiarios = new ArrayList<>();
        when(beneficiarioRepository.findAll()).thenReturn(beneficiarios);

        List<Beneficiario> retorno = beneficiarioService.todosBeneficiarios();
        verify(beneficiarioRepository).findAll();
    }
    

    @Test
    void testDocumentosBeneficiario() {
        Long id = 1L;
        List<Documento> documentos = new ArrayList<>();
        when(documentoRepository.findByBeneficiarioId(id)).thenReturn(documentos);

        List<Documento> retorno = beneficiarioService.getDocumentosBeneficiario(id);

        assertEquals(documentos, retorno);
        verify(documentoRepository).findByBeneficiarioId(id);
    }

    @Test
    void testAtualizaBeneficiario() {
        Long id = 1L;
        Beneficiario upBeneficiario = new Beneficiario();
        upBeneficiario.setName("Jose Filho");
        upBeneficiario.setTelefone("000099773");
        upBeneficiario.setData_Nascimento("10/10/1910");

        Beneficiario beneficiarioExistente = new Beneficiario();
        when(beneficiarioRepository.findById(id)).thenReturn(Optional.of(beneficiarioExistente));
        when(beneficiarioRepository.save(any(Beneficiario.class))).thenAnswer(invocation -> invocation.getArgument(0));
        
        Beneficiario retorno = beneficiarioService.updateBeneficiario(id, upBeneficiario);

        assertEquals("Jose Filho", retorno.getName());
        assertEquals("000099773", retorno.getTelefone());
        assertEquals("10/10/1910", retorno.getData_Nascimento());
        verify(beneficiarioRepository).findById(id);
        verify(beneficiarioRepository).save(any(Beneficiario.class));

    }
    
    @Test
    public void testDeleteBeneficiario() {
        Long id = 1L;
        Beneficiario beneficiarioExistente = new Beneficiario();
        when(beneficiarioRepository.findById(id)).thenReturn(Optional.of(beneficiarioExistente));
        doNothing().when(beneficiarioRepository).deleteById(id);
        beneficiarioService.deleteBeneficiario(id);
        verify(beneficiarioRepository).findById(id);
        verify(beneficiarioRepository).deleteById(id);
    }

}
