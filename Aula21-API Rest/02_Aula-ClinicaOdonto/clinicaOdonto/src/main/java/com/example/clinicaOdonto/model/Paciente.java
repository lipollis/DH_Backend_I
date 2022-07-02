package com.example.clinicaOdonto.model;

//import com.example.clinicaOdonto.dao.PacienteDAO;
import lombok.Getter;
import lombok.Setter;

// ANOTAÇÕES LOMBOOK
@Getter
@Setter
public class Paciente {
    // ATRIBUTOS
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private Integer idade;
    private Endereco endereco;
    private Integer idEndereco;

    /*
    //CONSTRUTOR - CONVERSOR DO DAO PARA PACIENTE
    public Paciente(PacienteDAO pacienteDAO, Endereco endereco) {
        this.id = pacienteDAO.getId();
        this.nome = pacienteDAO.getNome();
        this.sobrenome = pacienteDAO.getSobrenome();
        this.email = pacienteDAO.getEmail();
        this.idade = pacienteDAO.getIdade();
        this.endereco = endereco;
    }
  */
    // toString
    @Override
    public String toString() {
        return "Paciente" +
               "\n{ " + nome +
               " " + sobrenome +
               " - email='" + email +
               " - idade: " + idade +
               '}';
    }
}
