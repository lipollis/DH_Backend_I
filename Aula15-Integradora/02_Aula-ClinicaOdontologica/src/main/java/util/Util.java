package util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {
    // PARA GUARDAR O Timestamp
    // CONVERSÃO DA DATA RECEBIDA EM 'Timestamp'

    // CRIAÇÃO DO CONVERSOR QUE CRIA O TIMESTAMP
    public static Timestamp dateToTimestamp(Date data){
        Timestamp timestamp = new Timestamp(data.getTime());
        return timestamp;
    }
}
