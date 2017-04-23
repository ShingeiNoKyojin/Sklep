package model;

import java.math.BigDecimal;

public class Szkolenie extends Produkt {
	private String technologia;
	
	
	public Szkolenie(BigDecimal cena, String nazwa, String technologia) {
		super(cena, nazwa);
		this.technologia = technologia;
	}
	public String getTechnologia(){
		return technologia;
	}
	public void setTechnologia(String technologia){
		this.technologia = technologia;
	}
	public String toString(){
		return "Szkolenie [cena=" + cena + ", nazwa=]";
	}
	public String dajRabat() {
		return "-15%";
	}
	
}