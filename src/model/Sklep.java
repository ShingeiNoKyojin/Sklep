package model;

import java.util.ArrayList;
import java.util.List;

public class Sklep {
	private String www;
	private List<Produkt> produkty;
	
	public Sklep(String www) {
		this.www = www;
		this.produkty = new ArrayList<>(); // tworzenie listy, zeby nie bylo									// null
	}

	// metoda dodajKomputer
	public void dodajProdukt(Produkt produkt) {
		produkty.add(produkt);

	}

	// metoda usunKomputer
	public void usunKomputer(int index) {
		produkty.remove(index - 1);
	}

	// metoda wyswietlListe
	public void wyswietlListe() {
		for (int i = 0; i < produkty.size(); i++) {
			System.out.println(produkty.get(i) + "." + (i + 1));
		}
	}

	// metoda zmodyfikuj
	public void zmodyfikujProdukt(int index, Produkt produkt) {
		produkty.set(index, produkt);
//		produkty.get(index - 1);
	}
	// te metody musza sie tu pojawic.

	public Produkt znajdzProdukt(int index) {
		return produkty.get(index - 1);
	}

	public boolean czyPusty() {
		return produkty.isEmpty();
	}

	public boolean sprawdzIndex(int index) {
		if (index > 0 && index <= produkty.size()) {
			return true;
		} else {
			return false;
		}
		// return index > 0 && index <= produkty.size(); <--- to jest dokladnie to samo
	}

	public void wyswietlRabaty() {
		for ( Produkt produkt : produkty){
			System.out.println(produkt.dajRabat());
		}
	}
	public void wyswietlCE(){
		for (Produkt produkt : produkty){
			if (produkt instanceof UrzedzeniaElektroniczne){
				UrzedzeniaElektroniczne ue = (UrzedzeniaElektroniczne) produkt;
				ue.wyswietlCertyfikatCE();
			}
		}
	}

}
