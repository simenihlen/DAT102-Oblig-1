package no.hvl.data102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmarkiv;
	private int antall;
	
	public Filmarkiv(int antall) {
		filmarkiv = new Film[antall];
		this.antall = 0;
	}
	
	private Film[] utvid(Film[] filmarkiv) {
		Film[] storreFilmarkiv = new Film[filmarkiv.length * 2];
		for (int j = 0; j < filmarkiv.length; j++) {
			storreFilmarkiv[j] = filmarkiv[j];
		}
		return filmarkiv = storreFilmarkiv;
	}
	
	@Override
	public void visFilm(int nr) {
		for (Film film : filmarkiv) {
			if (film.getFilmnr() == nr) {
				System.out.println(film);
			}
		}	
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall -1 == filmarkiv.length) {
			filmarkiv = utvid(filmarkiv);
		}
		filmarkiv[antall] = nyFilm;
		antall++;
			
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
		boolean finnes = false;
		for (int i = 0; i < antall; i++) {
			if (filmarkiv[i].getFilmnr() == filmnr) {
				filmarkiv[i] = filmarkiv[antall];
				filmarkiv[antall] = null;
				antall--;
				finnes = true;
			}
		}
		return finnes;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] soek = new Film[antall];
		int tmp = 0;
		for (int i = 0; i < antall; i++) {
			if(filmarkiv[i].getTittel().contains(delstreng)) {
				soek[i] = filmarkiv[i];
				tmp++; 
			}
		}
		return trimTab(soek, tmp);
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] soek = new Film[antall];
		int tmp = 0;
		for (int i = 0; i < antall; i++) {
			if(filmarkiv[i].getProdusent().contains(delstreng)) {
				soek[i] = filmarkiv[i];
				tmp++;
			}
		}
		return trimTab(soek, tmp);
	}
	
	@Override
	public int antall(Sjanger sjanger) {
			
		int antallsj = 0;
		for (int i = 0; i < filmarkiv.length; i++) {
			if (filmarkiv[i].getSjanger().equals(sjanger)) {
				antallsj++;
			}
		}
		return antallsj;
			
	}
	
	@Override
	public int antall() {
			
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
