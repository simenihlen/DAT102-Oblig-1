package no.hvl.data102.klient;

import no.hvl.data102.*;
import no.hvl.data102.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	public Film lesFilm(){
		// TODO
		return null;
	}
		// vise en film med alle opplysninger p� skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr() + "\n" + "Tittel: " + film.getTittel() + "\n"
						+ "Produsent: " + film.getTittel() + "\n" + "Lansert: " + film.getLansering() + "\n"
						+ "Filmselskap: " + film.getFilmselskap() + "\n" + "Sjanger: " + film.getSjanger());
	}
		// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] tittel = filma.soekTittel(delstreng);
		for (Film i : tittel) {
			visFilm(i);
		}
	}
	
		// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] produsent = filma.soekProdusent(delstreng);
		for (Film i : produsent) {
			visFilm(i);
		}
	}
	
		// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
		// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		System.out.println(filma.antall());
		System.out.println(filma.antall(Sjanger.ACTION));
		System.out.println(filma.antall(Sjanger.DRAMA));
		System.out.println(filma.antall(Sjanger.FANTASY));
		System.out.println(filma.antall(Sjanger.HISTORY));
	}
		// ... Ev. andre metoder
}