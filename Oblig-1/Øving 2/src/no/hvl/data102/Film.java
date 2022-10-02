package src.no.hvl.data102;

import java.util.Objects;

public class Film {

	private int filmnr;
	private String produsent;
	private String tittel;
	private int lansering;
	private String filmselskap;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	public Film(int filmnr, String produsent, String tittel, int lansering, String filmselskap, Sjanger sjanger) {
		this.filmnr = filmnr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansering = lansering;
		this.filmselskap = filmselskap;
		this.sjanger = sjanger;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	public int getFilmnr() {
		return filmnr;
	}
	
	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getLansering() {
		return lansering;
	}
	public void setLansering(int lansering) {
		this.lansering = lansering;
	}
	public String getFilmselskap() {
		return filmselskap;
	}
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(filmnr);
	}
	@Override
	public boolean equals(Object filmnr) {
		if (this == filmnr)
			return true;
		if (this != filmnr)
			return false;
		if (getClass() != filmnr.getClass())
			return false;
		Film annenFilm = (Film) filmnr;
		return this.filmnr == annenFilm.filmnr;
	}	
}
