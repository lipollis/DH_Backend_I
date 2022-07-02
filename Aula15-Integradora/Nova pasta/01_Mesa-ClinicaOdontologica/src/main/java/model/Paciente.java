package model;

import java.util.Date;

public class Paciente {
    // ATRIBUTOS
    private Integer idPac;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date dataCadastro;
    private Integer idEnd;

    // CONSTRUTOR
    public Paciente(String nome, String sobrenome, String rg, Date dataCadastro, Integer idEnd) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
        this.idEnd = idEnd;
    }

    public Paciente(Integer idPac, String nome, String sobrenome, String rg, Date dataCadastro, Integer idEnd) {
        this.idPac = idPac;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
        this.idEnd = idEnd;
    }

    // GETTER & SETTER
    public Integer getIdPac() {
        return idPac;
    }

    public void setId(Integer id) {
        this.idPac = idPac;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getIdEnd() {
        return idEnd;
    }

    public void setIdEnd(Integer idEnd) {
        this.idEnd = idEnd;
    }
}
