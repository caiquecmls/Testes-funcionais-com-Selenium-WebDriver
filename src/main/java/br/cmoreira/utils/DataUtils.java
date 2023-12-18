package br.cmoreira.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	
	public Date obterDataComDiferencaDias(int dias) {
        // Obter a data atual
        Calendar calendar = Calendar.getInstance();
        // Adicionar 1 dias à data atual
        calendar.add(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}
	
	public String formatarData(Date date) {
		SimpleDateFormat x = new SimpleDateFormat("dd/MM/yyyy");
		return x.format(date);	
	}	
}
