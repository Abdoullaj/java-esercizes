
public class MetodiVari {
	
	char [] vocaliMinuscole = { 'a','e','i','o','u'};
	char [] vocaliMaiuscole = { 'A','E','I','O','U' };
	char [] consonantiMaiuscole = new char [26];
	char [] consonantiMinuscole = new char [26];

	public void creaConsonantiMaiuscole () {
		char carattere ;
		int cont = 0;
		int flag = 0;
		for (char i = 65/*a*/ ; i < 91/*z*/; i++,cont ++) {
			flag = 0;
			for(int k = 0; k<5; k++) {
				if (i == vocaliMaiuscole[k]) {
					flag++;
				}
			}
			if (flag == 0) consonantiMaiuscole[cont] = i;
			else {
				cont--;
			}
		}
	}
	
	public void creaConsonantiMinuscole () {
		char carattere ;
		int cont = 0;
		int flag = 0;
		for (char i = 97 /*A*/ ; i < 123/*Z*/; i++,cont ++) {
			flag = 0;
			for(int k = 0; k<5; k++) {
				if (i == vocaliMinuscole[k]) {
					flag++;
				}
			}
			if (flag == 0) consonantiMinuscole[cont] = i;
			else {
				cont--;
			}
		}
	}
	
	
	public void stampaAlfabetoConsonantiMaiuscole () {
		for (int i = 0; i < 21; i++) {
			System.out.print("\""+consonantiMaiuscole[i]+"\""+",");
		}
		
	}
	
	public void stampaAlfabetoConsonantiMinuscole () {
		for (int i = 0; i < 21; i++) {
			System.out.print("\""+consonantiMinuscole[i]+"\""+",");
		}
	}
}

