package ui;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Komputer;
import model.Produkt;
import model.Sklep;
import model.Szkolenie;

public class Menu {

	public void wyswietlMenu() {
		Sklep sklep = new Sklep("www.sklep.com");

		System.out.println("1 - Dodaj komputer");
		System.out.println("2 - Usun produkt");
		System.out.println("3 - Edytuj komputer");
		System.out.println("4 - Wyswietl produkt");
		System.out.println("5 - dodaj szkolenie");
		System.out.println("6 - wyswietl rabaty");
		System.out.println("q - Wyjscie");

		Scanner user_input = new Scanner(System.in);

		String opcja;

		do {
			System.out.print("Wybierz opcje: ");
			opcja = user_input.nextLine();
			switch (opcja) {
			case "1": {
				System.out.print("Podaj cene: ");
				BigDecimal cena = user_input.nextBigDecimal();
				user_input.nextLine();
				System.out.print("Podaj nazwe: ");
				String nazwa = user_input.nextLine();
				System.out.print("Podaj cpu: ");
				String cpu = user_input.nextLine();
				System.out.print("Podaj ram: ");
				String ram = user_input.nextLine();

				Komputer komputer = new Komputer(cena, nazwa, cpu, ram);
				sklep.dodajProdukt(komputer);
			}
				break;
			case "2": {
				if (sklep.czyPusty()) {
					System.out.println("Sklep pusty!");
				} else {
					sklep.wyswietlListe();
					System.out.println();
					int index = user_input.nextInt();
					user_input.nextLine();

					if (sklep.sprawdzIndex(index)) {
						sklep.usunKomputer(index);
						System.out.println("Komputer zostal usuniety.");
					} else {
						System.out.println("Podales niepoprwany index!");
					}
					sklep.usunKomputer(index);

				}
			}
				break;
			case "3": {
				sklep.wyswietlListe();
				System.out.print("Ktory element edytujemy");
				int index = user_input.nextInt();
				user_input.nextLine();
				Produkt produkt = sklep.znajdzProdukt(index);
				
				if (produkt instanceof Komputer){
				
				Komputer komputer = (Komputer) sklep.znajdzProdukt(index);

				System.out.print("Podaj nowa cene(aktualna cena: " + komputer.getCena() + "): ");
				BigDecimal cena = user_input.nextBigDecimal();
				user_input.nextLine();

				System.out.print("Podaj nowa nazwe(aktualna: " + komputer.getNazwa() + "): ");
				String nazwa = user_input.nextLine();

				System.out.print("Podaj nowe cpu (aktualne: " + komputer.getCpu() + "): ");
				String cpu = user_input.nextLine();

				System.out.print("Podaj nowy ram(aktualne:" + komputer.getRam() + "): ");
				String ram = user_input.nextLine();

				komputer.setCena(cena);
				komputer.setNazwa(nazwa);
				komputer.setRam(ram);
				komputer.setCpu(cpu);

				komputer.zaktualizuj(cena, nazwa, ram, cpu);

				sklep.zmodyfikujProdukt(index, komputer);
				} else {
					System.out.println("To nie jest komputer !");
				}	
			}
				break;
			case "4": {
				if (sklep.czyPusty()) {
					System.out.println("Sklep pusty!");
				} else {
					sklep.wyswietlListe();
				}
			}
				break;
			case "5": {
				System.out.print("Podaj cene: ");
				BigDecimal cena = user_input.nextBigDecimal();
				user_input.nextLine();
				System.out.print("Podaj nazwe: ");
				String nazwa = user_input.nextLine();
				System.out.print("Podaj technologie: ");
				String technologia = user_input.nextLine();

				Szkolenie szkolenie = new Szkolenie(cena, nazwa, technologia);
				sklep.dodajProdukt(szkolenie);
			}
				break;
			case "6":{
				sklep.wyswietlRabaty();
			}
			break;
			case "q":
			case "Q":
				System.out.println("Wyjscie");
				break;
			default:
				break;
			}
		} while (!opcja.equalsIgnoreCase("q"));
	}
}
