package service;

import dao.IDao;
import dao.impl.PacienteDaoImpl;
import model.Paciente;

import java.util.List;
import java.util.Optional;

// ENDEREÇO NÃO POSSUI SERVICE PORQUE TUDO QUE PRECISAR SER ALTERADO SERÁ FEITO ATRAVÉS DO PACIENTE
public class PacienteService {
    // CAMADA DE SERVICE CONVERSANDO COM A IMPLEMENTAÇÃO.
    // CRIAÇÃO DA IMPLEMENTAÇÃO DA INTERFACE COM O PACIENTE
    private IDao<Paciente> pacienteIDao;

    // CONSTRUTOR
    public PacienteService(){
        this.pacienteIDao = new PacienteDaoImpl();
    }

    // MÉTODOS SERVICE, O QUE O USUÁRIO CHAMA
    public Paciente salvar(Paciente p){
        return pacienteIDao.salvar(p);
    }

    public Optional<Paciente> buscar(Integer id){
        return pacienteIDao.buscar(id);
    }

    public void excluir(Integer id){
        pacienteIDao.excluir(id);
    }

    //
    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
}
