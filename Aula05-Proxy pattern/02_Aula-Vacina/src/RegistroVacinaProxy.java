import java.util.Date;

public class RegistroVacinaProxy implements iRegistro{
    // proxy: validação se a data da vacina é válida

    // MÉTODO IMPLEMENTADO COM A LÓGICA QUE VALIDA SE A VACINAÇÃO É CORRETA
    @Override
    public void vacinar(Object[] informacoes) {
        if(!comprovarData((Date)(informacoes[1]))){
            Registro registro = new Registro();
            registro.vacinar(informacoes);
        } else{
            System.out.println("Não pode vacinar");
        }
    }

    public boolean comprovarData(Date data){
        return data.after(new Date());
    }
}
