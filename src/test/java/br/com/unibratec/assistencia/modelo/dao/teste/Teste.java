package br.com.unibratec.assistencia.modelo.dao.teste;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Teste {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(c.getTime());
		
	}
}
