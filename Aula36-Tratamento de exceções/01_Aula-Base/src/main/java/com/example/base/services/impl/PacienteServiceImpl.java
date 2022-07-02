package com.example.base.services.impl;

import com.example.base.exceptions.ResourceNotFoundException;
import com.example.base.model.PacienteModel;
import com.example.base.persistence.entities.PacienteEntity;
import com.example.base.persistence.repository.PacienteRepository;
import com.example.base.services.OdontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements OdontoService<PacienteModel> {

    private final PacienteRepository pacienteRepository;
    private final EnderecoServiceImpl enderecoService;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, EnderecoServiceImpl enderecoService) {
        this.pacienteRepository = pacienteRepository;
        this.enderecoService = enderecoService;
    }

    @Override
    public PacienteModel salvar(PacienteModel paciente) {
        paciente.setEndereco(enderecoService.salvar(paciente.getEndereco()));
        PacienteEntity pacienteEntity = new PacienteEntity(paciente);
        return new PacienteModel(pacienteRepository.save(pacienteEntity));
    }

    // MÉTODO PARA FAZER UMA BUSCA QUE NÃO É FEITA PELO CLIENTE, É USADO INTERNO, NO CASO PARA O DELETE
    public PacienteModel buscarId(Integer id) throws ResourceNotFoundException {

        try{
            return new PacienteModel((pacienteRepository.getById(id)));
            // para buscar pelo nome paciente(ou categoria)
            // pacienteRepository.buscarNome();
        }catch (Exception e){
            throw new ResourceNotFoundException("Não existe paciente com o id: " + id);
        }

        //NÃO VAZIO DÁ O GET, SENÃO VAZIO
        //return !pacienteRepository.findById(id).isEmpty() ? new PacienteModel(pacienteRepository.getById(id)) : null;
    }

    public void deletar(Integer id) throws ResourceNotFoundException {
        // VALIDAÇÃO PARA O ERRO CASO NÃI EXISTA O ID
        //if(buscarId(id) == null)
        //    throw new ResourceNotFoundException("Não existe paciente com o id: " + id);

        try{
            pacienteRepository.deleteById(id);
        }catch (Exception e){
            throw new ResourceNotFoundException("Não existe paciente com o id: " + id + " para ser deletado.");
        }


    }
}
