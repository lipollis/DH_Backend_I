package service;

import dao.IDao;
import model.Medicamento;

public class MedicamentoService {

    // CLASSE DE SERVIÇO - CONEXÃO COM O CLIENTE NO TESTE. RELACIONAMENTO COM O SISTEMA
    // INTERFACE COM O MEDICAMENTO
    private IDao<Medicamento> medicamentoDao;

    // CONSTRUTOR
    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    // CONSTRUIR O QUE O USUÁRIO VAI OBSERVAR:
    public Medicamento salvar(Medicamento medicamento){
        return medicamentoDao.salvar(medicamento);
    }
}
