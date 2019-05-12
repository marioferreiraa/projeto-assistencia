package br.com.unibratec.assistencia.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean
@ViewScoped
public class TesteMB {

	Date data = new Date();
	String dataConvertida;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		System.out.println(data);
		System.out.println(data.getTime());
		System.out.println(data.getDate());
		//System.out.println(data.get);
		this.data = data;
	}
	
}
