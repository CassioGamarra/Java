package br.com.cassiogamarra.projetofinal.utilitarios;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataHora {
    public DataHora(){
       
    }
    public static String datahora(){
        Calendar cal = new GregorianCalendar();
        String dataHoraAtual;
        
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH);
        int ano = cal.get(Calendar.YEAR);
        int hora = cal.get(Calendar.HOUR);
        int minuto = cal.get(Calendar.MINUTE);
        int segundo = cal.get(Calendar.SECOND);
        
        dataHoraAtual = "Data: "+dia+"/"+(mes+1)+"/"+ano + " | " +"Hora: "+hora+":"+minuto+":"+segundo;
        
        return dataHoraAtual;
    }
}
