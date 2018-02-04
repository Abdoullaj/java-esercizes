
public class RipetizioniVocali extends RipetizioneAbstr {
	
	String [] vocaliMinuscole = {"a","e","i","o","u"};
	String [] vocaliMaiuscole =  {"A","E","I","O","U"};
	char [] vMinPiuRipetuta; 
	char [] vMaiPiuRipetuta; 
	char [] vMinMenoRipetuta;
	char [] vMaiMenoRipetuta;
	int max; 
	char vocalePiuRipetuta;
	

	
	public RipetizioniVocali (String parola) {
		contaRicorrenze(parola,vocaliMinuscole);
		contaRicorrenze(parola,vocaliMaiuscole);
		trovaEstremo();
		stampa(parola);
	} 
		
	public void contaRicorrenze (String parola, String [] arrayDiRicerca) {
			
			for (int k = 0; k < arrayDiRicerca.length;k++){
				int temp = 0;
				for (int i = 0; i< parola.length(); i++) {
					if ( arrayDiRicerca[k].charAt(0) == parola.charAt(i) ) {
						temp++;
					}
				}
				arrayDiRicerca[k] += temp;
			}
	}
	
	protected void trovaEstremo () {
		int extreme = searchTheExtreme(vocaliMinuscole);
		searchAllMaxMin(vocaliMinuscole, extreme);
		
		int extreme2 = searchTheExtreme(vocaliMaiuscole);
		searchAllMaxMai(vocaliMaiuscole, extreme);
	}
	
	protected int searchTheExtreme (String [] arrayOfString ) {
		int max = 0;
		for (int i = 0; i< arrayOfString.length;i++) {
			if (Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) >= max) {
				max = Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) ;
			}
		}
		return max;
	}
		
	protected void searchAllMaxMin (String [] arrayOfString, int max) {
			
			int lengthMost = trovaQuantiMax( arrayOfString,max);
			int lengthLess = trovaQuantiMin( arrayOfString );
			
			char [] mostRepeted = new char [lengthMost];
			char [] lessRepeted = new char [lengthLess];
			
			mostRepeted = fillMostRepeted(arrayOfString,max,lengthMost);
			lessRepeted = fillLessRepeted(arrayOfString,lengthLess);
			setvMinPiuRipetuta (mostRepeted);
			setvMinMenoRipetuta(lessRepeted);
			}
	
	public int trovaQuantiMax(String [] arrayOfString,int max) {
		int length = 0;
		for (int i = 0; i< arrayOfString.length ; i++) {
			if (Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) == max) {
				length++;
			}
		}
		return length;
	}
	
	public int trovaQuantiMin(String [] arrayOfString)  {
		int length = 0;
		for (int i = 0; i < arrayOfString.length ; i++) {
			if (Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) == 0) {
				length++;
			}
		}
		return length;
	}
	
	public void trovaIlMaggioriTraTuttiIMaggiori () {
		int length = 0;
		if (vMinPiuRipetuta.length >= vMaiPiuRipetuta.length) 
			length = vMinPiuRipetuta.length ;
			else 
				length = vMaiPiuRipetuta.length;
	}
	
	
	protected void searchAllMaxMai (String [] arrayOfString, int max) {
		
			int lengthMost = trovaQuantiMax( arrayOfString,max);
			int lengthLess = trovaQuantiMin( arrayOfString );
			
			char [] mostRepeted = new char [lengthMost];
			char [] lessRepeted = new char [lengthLess];
			System.out.println("Lunghezze assegnate.");
			mostRepeted = fillMostRepeted(arrayOfString,max,lengthMost);
			lessRepeted = fillLessRepeted(arrayOfString,lengthLess);
			System.out.println("Array riempiti");
			setvMaiPiuRipetuta (mostRepeted);
			setvMaiMenoRipetuta(lessRepeted);
		}
	
	public void setMax (int max) {
		this.max = max;
	}
	public void setvMinPiuRipetuta (char [] vMinPiuRipetuta) {
		this.vMinPiuRipetuta = vMinPiuRipetuta;
	}
	public void setvMinMenoRipetuta(char[] vMinMenoRipetuta) {
		this.vMinMenoRipetuta = vMinMenoRipetuta;
	}
	public void setvMaiMenoRipetuta(char[] vMaiMenoRipetuta) {
		this.vMaiMenoRipetuta = vMaiMenoRipetuta;
	}
	public void setvMaiPiuRipetuta(char[] vMaiPiuRipetuta) {
		this.vMaiPiuRipetuta = vMaiPiuRipetuta;
	}
	
	

	public char [] fillMostRepeted (String [] arrayOfString,int max,int length) {
		char [] mostRepeted = new char [length];
		length = 0;
		for (int i = 0; i< arrayOfString.length;i++) {
			if (Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) == max) {
				mostRepeted[length] = arrayOfString[i].charAt(0);
				System.out.println("Assegnato a mostRepeted");
				length++;
			}
		}
		return mostRepeted;
	}
	
	public char [] fillLessRepeted (String [] arrayOfString,int length) {
		char [] lessRepeted = new char [length];
		length = 0;
		for (int i = 0; i< arrayOfString.length;i++) {
			if (Integer.parseInt(arrayOfString[i].substring(1, arrayOfString[i].length())) == 1) {
				lessRepeted[length] = arrayOfString[i].charAt(0);
				length++;
			}
		}
		return lessRepeted;
	}
	
	public void spazio() {
		System.out.println();
		System.out.println();
	}
	
	public void stampa (String parola) {
		spazio();
		System.out.println("-----------"+parola+"--------------");
		spazio();
		System.out.println("Vocali minuscole");
		for (int i = 0;i < vocaliMinuscole.length;i++) {
			System.out.print(vocaliMinuscole[i]+" ");
		}
		spazio();
		System.out.println("Vocali maiuscole"+" ");

		for (int i = 0;i < vocaliMaiuscole.length;i++) {
			System.out.print(vocaliMaiuscole[i]+" ");
		}
		spazio();
		System.out.println("Vocale minuscola più ripetuta.");

		for (int i = 0;i < vMinPiuRipetuta.length;i++) {
			System.out.print(vMinPiuRipetuta[i]+" ");
		}
		spazio();
		System.out.println("Vocale Maiuscola più ripetuta.");

		for (int i = 0;i < vMaiPiuRipetuta.length;i++) {
			System.out.print(vMaiPiuRipetuta[i]+" ");
		}
		spazio();
		System.out.println("Vocale Minuscola meno ripetuta");

		for (int i = 0;i < vMinMenoRipetuta.length;i++) {
			System.out.print(vMinMenoRipetuta[i]+" ");
		}
		spazio();
		System.out.println("Vocale Maiuscola meno ripetuta");

		for (int i = 0;i < vMaiMenoRipetuta.length;i++) {
			System.out.print(vMaiMenoRipetuta[i]+" ");
		}
	}
	
	
	
	
	

	
}
