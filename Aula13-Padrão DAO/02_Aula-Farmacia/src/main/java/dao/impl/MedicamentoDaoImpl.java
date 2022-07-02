package dao.impl;

import dao.ConfiguracaoJDBC;
import dao.IDao;
import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//
public class MedicamentoDaoImpl implements IDao<Medicamento> {
    private ConfiguracaoJDBC configuracaoJDBC;
    final static Logger log = Logger.getLogger(MedicamentoDaoImpl.class);

    // CONSTRUTOR CO CONFIG JDBC
    public MedicamentoDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    // IMPLEMENTAÇAO DOS METODOS
    @Override
    public Medicamento salvar(Medicamento medicamento) {
        // LÓGICA PARA SALVAR
        log.debug("Registrando novo medicamento." + medicamento.toString());
        Connection connection = configuracaoJDBC.conectarBanco(); // conexao com banco
        Statement statement = null;
        // insert dentro da tab, com valores para subistituir para o próx da ordem, o sistema insere qts vezes quiser
        String query = String.format("INSERT INTO medicamentos(codigoNumerico,nome,laboratorio,quantidade,preco) " +
                                     "VALUES('%s','%s','%s','%s','%s')",
                                     medicamento.getCodigoNumerico(), medicamento.getNome(),medicamento.getLaboratorio(),
                                     medicamento.getQuantidade(),medicamento.getPreco());
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);//executa e faz update
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                medicamento.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();// mostrar no terminal
        }
        return medicamento;
    }

    @Override
    public Medicamento buscar() {
        return null;
    }



}
