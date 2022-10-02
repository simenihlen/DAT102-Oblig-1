package no.hvl.data102;
import no.hvl.data102.*;
import no.hvl.data102.adt.*;

public class Filmarkiv2 implements FilmarkivADT {
	
	private LinearNode<Film> start;
	private int antall;
	
	public Filmarkiv2() {
		start = null;
		antall = 0;
	}
	
	
	public void leggTilFilm(Film nyFilm) {
		Linearnode<Film> nyNode = new Linearnode<>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}


	@Override
	public void visFilm(int nr) {
		LinearNode<Film> curr = new LinearNode<>();
		curr.setNeste(start);
		int i = 1;
		while(i > 1) 
		{
			if(i == nr)
			{
				System.out.printf("fant Film #%d", i);
				break;
			}
			i++;
			curr.setNeste(curr.getNeste());
		}
	}


	@Override
	public boolean slettFilm(int filmnr) {
		Linearnode<Film> peker = start;
		Linearnode<Film> forrige = null;
		boolean finnes = false;
		
		if (peker != null && peker.getElement().getFilmnr() == filmnr) {
			start = peker.getNeste();
			finnes = true;
			antall--;
		}
		else if(peker != null) {
			while (peker != null && peker.getElement().getFilmnr() != filmnr) {
				forrige = peker;
				peker = peker.getNeste();
			}
			forrige.setNeste(peker.getNeste);
			antall--;
			finnes = true;
		}
		return finnes;
	}


	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] tittelSoek = new Film[antall];
		int tmp = 0;
		LinearNode<Film> tittel = start;
		
		for (int i = 0; i < antall; i++) {
			if(tittel.getElement().getTittel().contains(delstreng)) {
				tittelSoek[tmp] = tittel.getElement();
				tmp++;
			}
			tittel.getNeste();
		}
		return trimTab(tittelSoek, tmp);
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] prodSoek = new Film[antall];
		int tmp = 0;
		LinearNode<Film> prod = start;
		
		for (int i = 0; i < antall; i++) {
			if(prod.getElement().getProdusent().contains(delstreng)) {
				prodSoek[tmp] = prod.getElement();
				tmp++;
			}
			prod.getNeste();
		}
		return trimTab(prodSoek, tmp);
	}


	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		LinearNode<Film> sj = start;
		for (int i = 0; i < antall; i++) {
			if (sj.getElement().getSjanger().equals(sjanger)) {
				antallSjanger++;
			}
			sj = sj.getNeste();
		}
		return antallSjanger;
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

