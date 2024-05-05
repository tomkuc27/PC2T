package projekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;


public class Databaze {

	private List<Kniha> knihy;
	
	
	public Databaze() {
		knihy = new ArrayList<>();	
	}
	
	public void naplnitDatabazi() throws Exception {
		Roman roman1 = new Roman("Oliver Twist", "Charles Dickens", 1838, false, "dobrodružný");
		Roman roman2 = new Roman("Vánoční koleda", "Charles Dickens", 1843, true, "dobrodružný");
		Roman roman3 = new Roman("David Copperfield", "Charles Dickens", 1850, true, "fantasy");
		Roman roman4 = new Roman("R.U.R", "Karel Čapek", 1920, false, "scifi");
		Roman roman5 = new Roman("Válka s mloky", "Karel Čapek", 1935, false, "historický");
		Roman roman6 = new Roman("Ulička v Paříži", "Victor Hugo", 1862, false, "historický");
		Roman roman7 = new Roman("Pán prstenů", "J.R.R Tolkien", 1954, false, "fantasy");
		Roman roman8 = new Roman("Hobit", "J.R.R Tolkien", 1813, true, "fantasy");
		
		knihy.add(roman1);
		knihy.add(roman2);
		knihy.add(roman3);
		knihy.add(roman4);
		knihy.add(roman5);
		knihy.add(roman6);
		knihy.add(roman7);
		knihy.add(roman8);
			
		Ucebnice ucebnice1 = new Ucebnice("Matematika pro druháky", "Karel Novák", 2015, true, 2);
		Ucebnice ucebnice2 = new Ucebnice("Matematika", "Karel Novák", 2018, false, 3);
		Ucebnice ucebnice3 = new Ucebnice("Věda", "Petr Svoboda", 2020, true, 6);
		Ucebnice ucebnice4 = new Ucebnice("Věda pro nejmenší", "Petr Svoboda", 2009, true, 1);
		Ucebnice ucebnice5 = new Ucebnice("Český Jazyk 4", "Karolína Nějaká", 2024, false, 4);
		Ucebnice ucebnice6 = new Ucebnice("English", "Jan Nějaký", 2020, true, 8);
		
		knihy.add(ucebnice1);
		knihy.add(ucebnice2);
		knihy.add(ucebnice3);
		knihy.add(ucebnice4);
		knihy.add(ucebnice5);
		knihy.add(ucebnice6);
		
	}
	
	
	public void pridatKnihu (Kniha kniha) {
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println("Vyberte typ knihy (1 - Román, 2 - Učebnice): ");
		int vyber = sc.nextInt();
		sc.nextLine();
		
		if(vyber != 1 && vyber != 2) {
			System.out.println("Prosím zadejte správné číslo");
			return;
		}
		
		System.out.println("Zadejte název knihy: ");
		String nazev = sc.nextLine();
		
		System.out.println("Zadejte jméno autora: ");
		String autor = sc.nextLine();
		
		System.out.println("Zadejte rok vydání: ");
		
		int rokVydani = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Je kniha k dispozici? (true/false): ");
		
		boolean dostupnost = sc.nextBoolean();
		sc.nextLine();
		
		if (vyber == 1) {
			System.out.println("Zadejte žánr románu: ");
			String zanr = sc.nextLine();
			try {
			Roman roman = new Roman(nazev, autor, rokVydani, dostupnost, zanr);
			knihy.add(roman);
		}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else if (vyber == 2) {
			System.out.println("Zadej pro jaký ročník je učebnice: ");
			int rocnik = sc.nextInt();
			Ucebnice ucebnice = new Ucebnice(nazev, autor, rokVydani, dostupnost, rocnik);
			knihy.add(ucebnice);
		}
		else {
			System.out.println("Neplatná volba");
		}
		}
		catch (InputMismatchException e) {
			System.err.println("Neplatný vstup, prosím, zkuste to znovu");
		}
	}
	
	public void upravKnihu(String nazevKnihy) {
		Scanner sc = new Scanner(System.in);
		
		boolean nalezeno = false;
		for(Kniha kniha : knihy) {
			if(kniha.getNazev().equalsIgnoreCase(nazevKnihy)) {
				nalezeno = true;
				System.out.println("Vyberte, co chcete změnit:");
	            System.out.println("1	...Název knihy");
	            System.out.println("2	...Jméno autora");
	            System.out.println("3	...Rok vydání");
	            System.out.println("4	...Dostupnost");
	            
	            try {
	            int volba = sc.nextInt();
	            sc.nextLine();
	            
	            switch(volba) {
	            case 1: 
	            	System.out.println("Zadejte nový název knihy: ");
                    kniha.setNazev(sc.nextLine());
                    break;
                
	            case 2:
	            	System.out.println("Zadejte nové jméno autora: ");
                    kniha.setAutor(sc.nextLine());
                    break;
                case 3:
                    System.out.println("Zadejte nový rok vydání: ");
                    kniha.setRok(sc.nextInt());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("Zadejte novou dostupnost knihy (true/false): ");
                    kniha.setDostupnost(sc.nextBoolean());
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Neplatná volba");
            }
	            }
	            catch (InputMismatchException e) {
	    			System.err.println("Neplatný vstup, prosím, zkuste to znovu");
	    		}
            break;
	            }
			}
	
		if (!nalezeno) {
	        System.out.println("Kniha s názvem " + nazevKnihy + " nebyla nalezena.");
	    }
		}
	
	
	public void smazatKnihu (String nazevSmazat) {
		boolean nalezena = false;
		Iterator<Kniha> iterator = knihy.iterator();
		while (iterator.hasNext()) {
			Kniha kniha = iterator.next();
			if(kniha.getNazev().equalsIgnoreCase(nazevSmazat)) {
				iterator.remove();
				nalezena = true;
				break;
			}
		}
		if(!nalezena) {
			System.out.println("Kniha s názvem " +nazevSmazat + " nebyla nalezena");
		}
	}
	
	
	
	public void najitKnihu(String nazev) {
		boolean nalezena = false;
		for (Kniha kniha : knihy) {
			if(kniha.getNazev().equalsIgnoreCase(nazev)) {
				System.out.println("Název: "+kniha.getNazev());
				System.out.println("Autor: "+kniha.getAutor());
				System.out.println("Rok vydání "+kniha.getRok());
				System.out.println((kniha.getDostupnost() ? "K dispozici" : "Vypůjčeno"));
				
				if (kniha instanceof Roman) {
					System.out.println("Žánr: "+((Roman)kniha).getZanr());
				}
				else if (kniha instanceof Ucebnice) {
					System.out.println("Pro "+((Ucebnice)kniha).getRocnik()+". ročník");
				}
				
				nalezena = true;
				break;
			}
		}
		
		if(!nalezena) {
			System.out.println("Kniha s názvem " +nazev + " nebyla nalezena");
		}
	}
	
	public void vypujceneKnihy() {
		System.out.println("Seznam vypůjčených knih: ");
		for(Kniha kniha : knihy) {
			if(!kniha.getDostupnost()) {
				String typKnihy = (kniha instanceof Roman) ? "Román" : "Učebnice" ;
				System.out.println(kniha.getNazev() +"("+typKnihy +")");
			}
		}
	}
	
	public void stavKnihy (String nazev) {
		Scanner sc = new Scanner(System.in);
		boolean nalezena = false;
		for (Kniha kniha : knihy) {
			if(kniha.getNazev().equalsIgnoreCase(nazev)) {
				System.out.println("Je kniha k dispozici? (true/false)");
			try {
				boolean novaDostupnost = sc.nextBoolean();
				sc.nextLine();
				
				if (novaDostupnost != kniha.getDostupnost()) {
					kniha.setDostupnost(novaDostupnost);
					System.out.println("Dostupnost knihy byla aktualizována.");
					
				}
				else {
	                System.out.println("Dostupnost knihy se neliší.");
	            }
				nalezena = true;
			} 
			catch (InputMismatchException e) {
				System.err.println("Neplatný vstup, prosím, zkuste to znovu");
			}
			}
			
		}
		if(!nalezena) {
			System.out.println("Nenalezena kniha");
		}
	}
	
	public void vsechnyKnihy() {
		
		Collections.sort(knihy, Comparator.comparing(Kniha::getNazev));
		
		System.out.println("Seznam všech knih v abecedním pořádí: ");
		for (Kniha kniha : knihy) {
			if (kniha instanceof Roman) {
				System.out.println("Název: "+kniha.getNazev()+", autor: "+kniha.getAutor()+", žánr: "+ ((Roman)kniha).getZanr()+", rok vydání: "+kniha.getRok()+" , "+(kniha.getDostupnost() ? "k dispozici" : "vypůjčená"));
				}
			else if (kniha instanceof Ucebnice) {
				System.out.println("Název: "+kniha.getNazev()+", autor: "+kniha.getAutor()+", pro "+ ((Ucebnice)kniha).getRocnik()+". ročník, rok vydání: "+kniha.getRok()+" , "+(kniha.getDostupnost() ? "k dispozici" : "vypůjčená"));
			}
		}
	}
	
	public void knihyPodleZanru(String zanr) {
		boolean nalezen = false;
		for (Kniha kniha : knihy) {
			if (kniha instanceof Roman && ((Roman)kniha).getZanr().equalsIgnoreCase(zanr)) {
				if(!nalezen) {
					System.out.println("Seznam knih žánru "+ zanr +": ");
					nalezen = true;
				}
				System.out.println(kniha.getNazev()+" ("+kniha.getAutor()+")");
			}	
		}
		if(!nalezen) {
			System.out.println("Nenalezena žádná kniha tohoto žánru");
		}
	}
	
	public void knihyPodleAutora(String autor) {
		boolean nalezen = false;
		
		Collections.sort(knihy, Comparator.comparing(Kniha::getRok));
		
		for (Kniha kniha : knihy) {
			if(kniha.getAutor().equalsIgnoreCase(autor)) {
				if(!nalezen) {
					System.out.println("Seznam knih od "+ autor +": ");
					nalezen = true;
				}
				System.out.println(kniha.getNazev()+"("+kniha.getRok()+")");
			}
		}
		if(!nalezen) {
			System.out.println("Nenalezena žádná kniha tohoto autora");
		}
	}
	
	public void ulozitKnihuDoSouboru (String nazev) {
		for (Kniha kniha: knihy) {
			if (kniha.getNazev().equalsIgnoreCase(nazev)) {
				try (PrintWriter writer = new PrintWriter(new FileWriter(nazev + ".txt"))) {
					if (kniha instanceof Roman) {
						writer.println("Název: "+kniha.getNazev()+", autor: "+kniha.getAutor()+", žánr: "+ ((Roman)kniha).getZanr()+", rok vydání: "+kniha.getRok()+" , "+(kniha.getDostupnost() ? "k dispozici" : "vypůjčená"));
						}
					else if (kniha instanceof Ucebnice) {
						writer.println("Název: "+kniha.getNazev()+", autor: "+kniha.getAutor()+", pro "+ ((Ucebnice)kniha).getRocnik()+". ročník, rok vydání: "+kniha.getRok()+" , "+(kniha.getDostupnost() ? "k dispozici" : "vypůjčená"));
					}
					
					System.out.println("Informace o knize " + nazev + " byly uloženy do souboru.");
				} catch (IOException e) {
                    System.err.println("Nastala chyba při ukládání informací o knize do souboru.");
                }
				}
			}
		}
	
	public void nacistKnihuZeSouboru(String nazevSouboru) {
		try (BufferedReader reader = new BufferedReader(new FileReader(nazevSouboru))){
			String cti;
			while ((cti = reader.readLine()) != null) {
				System.out.println(cti);
			}
		}
		catch (IOException e) {
			System.err.println("Nastala chyba při načítání informací o knize ze souboru");
		}
	}
	
	
}
	
	
	

