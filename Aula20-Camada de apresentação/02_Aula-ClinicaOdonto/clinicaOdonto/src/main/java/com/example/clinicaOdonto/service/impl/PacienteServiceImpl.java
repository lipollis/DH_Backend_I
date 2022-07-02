package com.example.clinicaOdonto.service.impl;

import com.example.clinicaOdonto.model.Paciente;
import com.example.clinicaOdonto.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Service // CONFIGURAÇÃO PARA SERVIÇO
public class PacienteServiceImpl implements PacienteService {
    // ARMAZENAR OS REGISTROS DOS PACIENTES
    private static Map<Integer, Paciente> pacienteMap = new HashMap<>();

    // VERIFICAÇÃO DO ID
    private static Integer idGlobal = 1;

    // ARRAYS DE NOMES E SOBRENOMES - SERÃO SORTEADOS NO RANDOM
    private static String[] nomes = {"Lucas", "Ana", "Pedro", "Julia", "Roberto",
            "Larissa", "Antonio", "Pietra", "Rubens", "Giovana"};

    private static String[] sobrenomes = {"Silva", "Santos", "Gomes", "Paglia", "Grisa",
            "Andrade", "Quinteiros", "Tempesta", "Franco", "Andrade"};


    // IMPLEMENTAÇÃO DOS MÉTODOS
    @Override
    public Paciente criarPaciente() {
        Random random = new Random();
        int numRad = 10; // SORTEIO DE 10 POSIÇÕES
        String nome = nomes[random.nextInt(numRad)]; //ONDE SERÁ GUARDADO O NOME SORTEADO
        String sobrenome = sobrenomes[random.nextInt(numRad)];
        String email = nome.toLowerCase() + "." + sobrenome.toLowerCase() + "@email.com"; //CRIAÇÃO DO EMAIL
        //Integer id = pacienteMap.size() + 1; //GERAR O ID
        Integer id = idGlobal++;

        pacienteMap.put(id, new Paciente(nome,sobrenome,email,(random.nextInt(numRad) +18)));

        return pacienteMap.get(id);
    }

    @Override
    public Map<Integer, Paciente> buscarPacientes() {
        return pacienteMap;
    }

    @Override
    public void deletar(Integer id) {
        pacienteMap.remove(id);
    }

    //atualizar:
    @Override
    public Paciente buscarId(Integer id) {
        return pacienteMap.get(id);
    }
    @Override
    public Paciente atualizarPaciente(Integer id, String nome) {
        Paciente paciente = buscarId(id);
        paciente.setNome(nome);
        return paciente;
    }
}
