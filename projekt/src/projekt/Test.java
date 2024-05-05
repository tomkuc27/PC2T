package projekt;

import java.util.Scanner;

public class Test {
	
	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	


	

	public static void main(String[] args) throws Exception {
		
		Databaze knihovna = new Databaze();
		
		knihovna.naplnitDatabazi();
		
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;
		
		
		
		while(run)
		{
		System.out.println("Vyberte akci:");
		System.out.println("1	... Přídání nové knihy");
		System.out.println("2 	... Úprava knihy");
		System.out.println("3 	... Smazání knihy");
		System.out.println("4 	... Označení vypůjčená/vrácená");
		System.out.println("5 	... Výpis všech knih");
		System.out.println("6 	... Vyhledání knihy");
		System.out.println("7 	... Všechny knihy autora");
		System.out.println("8 	... Výpis určitého žánru");
		System.out.println("9 	... Vypůjčené knihy");
		System.out.println("10 	... Uložení do souboru");
		System.out.println("11 	... Načtení ze souboru");
		System.out.println("12 	... Ukončení aplikace");

		int volba = pouzeCelaCisla(sc);
		switch (volba) {
		case 1: 
            knihovna.pridatKnihu(null);
            break;
            
		case 2: 
			System.out.println("Zadejte název knihy, kterou chcete upravit: ");
			sc.nextLine();
			String upravKnihu = sc.nextLine();
			knihovna.upravKnihu(upravKnihu);
			break;
			
		case 3: 
			System.out.println("Zadejte název knihy, kterou chcete smazat:");
			sc.nextLine();
			String nazevSmazat = sc.nextLine();
			knihovna.smazatKnihu(nazevSmazat);
			break;
		
		case 4: 
			System.out.println("Zadejte název knihy:");
			sc.nextLine();
			String nazevStav = sc.nextLine();
			knihovna.stavKnihy(nazevStav);
			
			break;
		
		case 5: 
			knihovna.vsechnyKnihy();
			break;
		
		case 6: 
			System.out.println("Zadejte název knihy, kterou chcete vyhledat:");
			sc.nextLine();
			String nazevHledat = sc.nextLine();
			knihovna.najitKnihu(nazevHledat);
			break;
			
		case 7: 
			System.out.println("Zadejte autora: ");
			sc.nextLine();
			String autor = sc.nextLine();
			knihovna.knihyPodleAutora(autor);
			
			
			break;
		case 8:
			System.out.println("Zadejte žánr knih:");
			sc.nextLine();
			String zanr = sc.nextLine();
			knihovna.knihyPodleZanru(zanr);
			break;
			
		case 9:
			knihovna.vypujceneKnihy();
			break;
			
		case 10:
			System.out.println("Zadejte název knihy k uložení");
			sc.nextLine();
			String nazev = sc.nextLine();
			knihovna.ulozitKnihuDoSouboru(nazev);
			break;
			
		case 11:
			System.out.println("Zadejte název souboru");
			sc.nextLine();
			String nazevSouboru = sc.nextLine();
			knihovna.nacistKnihuZeSouboru(nazevSouboru);
			break;
			
		case 12:
			run = false;
			break;
		default:
            System.out.println("Neplatná volba");
		
		}
	}
		sc.close();
	}
}
