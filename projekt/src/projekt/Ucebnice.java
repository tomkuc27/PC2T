package projekt;

public class Ucebnice extends Kniha {

	private int rocnik;
	
	public Ucebnice(String nazev, String autor, int rokVydani, boolean dostupnost, int rocnik) {
		super(nazev, autor, rokVydani, dostupnost);
		this.rocnik = rocnik;
	}
	
	public int getRocnik() {
		return rocnik;
	}
	
	public void setRocnik(int rocnik) {
		this.rocnik = rocnik;
	}
}
