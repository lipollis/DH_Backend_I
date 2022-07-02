package service;

import dao.IDao;
import dao.impl.DentistaDaoImpl;
import model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {
    // CONVERSANDO COM A IMPLEMENTAÇÃO.
    // CLASSE DE SERVIÇO - CONEXÃO COM O CLIENTE NO TESTE. RELACIONAMENTO COM O SISTEMA

    // ATRIBUTO
    private IDao<Dentista> dentistaIDao;

    // CONSTRUTOR
    public DentistaService() {
        this.dentistaIDao = new DentistaDaoImpl();
    }

    // CONSTRUIR O QUE O USUÁRIO VAI OBSERVAR
    // MÉTODOS SERVICE, O QUE O USUÁRIO CHAMA
    public Dentista salvar(Dentista dentist){
        return dentistaIDao.salvar(dentist);
    }

    public Dentista atualizar(Dentista dentist){
        return dentistaIDao.atualizar(dentist);
    }

    public Optional<Dentista> buscar(Integer idDentista){
        return dentistaIDao.buscar(idDentista);
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();
    }

    public void excluir(Integer idDentista){
        dentistaIDao.excluir(idDentista);
    }
}
