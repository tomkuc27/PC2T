package projekt;

import java.util.Arrays;

public class Roman extends Kniha {
	private String zanr;
	private static final String[] PLATNE_ZANRY = {"dobrodružný", "detektivní", "historický", "scifi", "fantasy"};

	
	public Roman(String nazev, String autor, int rokVydani, boolean dostupnost, String zanr) throws Exception {
		super(nazev, autor, rokVydani, dostupnost);
		setZanr(zanr);
	}
	
	public String getZanr() {
		return zanr;
	}
	
	public void setZanr(String zanr) throws Exception {
		if (Arrays.asList(PLATNE_ZANRY).contains(zanr.toLowerCase())) {
		this.zanr = zanr;
		}
		else {
			throw new Exception("Neplatný žánr");
		}
	}
}
