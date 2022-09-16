package nivel2_sigmageek;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class Palindromo {
	private static final List<Double[]> primos = new ArrayList<Double[]>();
	private static final List<Double[]> palindromosprimos = new ArrayList<Double[]>();
	public static void main(String[] args) {
		Pi pi = new Pi();
		int n=100000; //primeiro Palindromo Primo foi encontrado na iteraçao 129080
		pi.pi(n);
		BigDecimal bigDecimal = pi.getValor();
		//obtendo tamanho de pi
		int tamanhopi = bigDecimal.toPlainString().length();
	    char[] decimaispi = bigDecimal.toPlainString().toCharArray();
	    //transformar o array char[] em array numero
	    double[] dPi = new double[decimaispi.length];
	    for(int i=0;i<decimaispi.length;i++) {
	    	switch (decimaispi[i]) {
	    	case '0':
	    		dPi[i]=0;
	    		break;
			case '1':
				dPi[i]=1;
				break;
			case '2':
				dPi[i]=2;
				break;
			case '3':
				dPi[i]=3;
				break;
			case '4':
				dPi[i]=4;
				break;
			case '5':
				dPi[i]=5;
				break;
			case '6':
				dPi[i]=6;
				break;
			case '7':
				dPi[i]=7;
				break;
			case '8':
				dPi[i]=8;
				break;
			case '9':
				dPi[i]=9;
				break;
			case '.':
				dPi[i]=0;
			default:
				break;
			}
	    }
	    //agora vamos encontrar numeros primos em grupos de 9 em 9 e adicionar em uma lista
	    //criar um vetor de posiçao para auxiliar
	    int pp=0;
	    double[] posicao = new double[dPi.length];
	    for(int i=0;i<(dPi.length-20);i++) { //pode ser que o primeiro numero seja 0, 
	    	//mas todo numero terminado em zero é par, entao nao impora
	    	//todo numero terminado em par é divisivel por 2
	    	//se começa ou termina em par, nao pode ser palindromo primo
	    	if(dPi[i]%2==0||dPi[i+20]%2==0) {
	    		continue;
	    	}else {
		    	//para agilizar o processo: conferimos se é palindromo antes
		    	if(dPi[i]==dPi[i+20]) {
		    		if(dPi[i+1]==dPi[i+19]) {
		    			if(dPi[i+2]==dPi[i+18]) {
		    				if(dPi[i+3]==dPi[i+17]) {
		    					if(dPi[i+4]==dPi[i+16]) {
		    						if(dPi[i+5]==dPi[i+15]) {
		    							if(dPi[i+6]==dPi[i+14]) {
		    								if(dPi[i+7]==dPi[i+13]) {
		    									if(dPi[i+8]==dPi[i+12]) {
		    										if(dPi[i+9]==dPi[i+11]) {
		    													Double[] palindromo = new Double[21];
		    													for(int j=0;j<21;j++) {
		    														palindromo[j]=dPi[j];
		    													}
		    													palindromosprimos.add(palindromo);
		    													System.out.println("Palindromo encontrado!");
		    													posicao[pp]=i;
		    													System.out.println("Posiçao: "+pp);
		    													pp++;
		    							    		}else {
		    							    			continue;
		    							    		}
		    						    		}else {
		    						    			continue;
		    						    		}
		    					    		}else {
		    					    			continue;
		    					    		}
		    				    		}else {
		    				    			continue;
		    				    		}
		    			    		}else {
		    			    			continue;
		    			    		}
		    		    		}else {
		    		    			continue;
		    		    		}
				    		}else {
				    			continue;
				    		}
			    		}else {
			    			continue;
			    		}
		    		}else {
		    			continue;
		    		}
		    	}else {
		    		continue;
		    	}
	    	}
	    }
	    //imprimindo lista do palindromo5 e sua posicao
	    if(palindromosprimos.isEmpty()) {
	    	System.out.println("Palindromo não encontrado");
	    }else {
	    	for(int i=0;i<palindromosprimos.size();i++) {
	    		Double[] palindromo = palindromosprimos.get(i);
	    		BigInteger palindromoBig = BigInteger.valueOf(0).setBit(22);
	    		int p = (int)posicao[i];
	    		int num=1;
	    		for(int j=0;j<21;j++) {
	    			BigInteger mult = BigInteger.valueOf(palindromo[j].intValue()*num);
	    			palindromoBig=palindromoBig.add(mult);
	    			num=num*10;
	    		}
	    		if(ehPrimo(palindromoBig.intValue())) {
	    			System.out.println("O primeiro palindromo primo de Pi com 21 algarismos é o numero: "+palindromo);
	    			System.out.println("Ocorreu na iteração: "+p);
	    		}
	    	}
	    }
	}
	private static boolean ehPrimo(int numero) {
		if(numero==0||numero==1) {
			return false;
		}
	    for (int j = 2; j < numero; j++) {
	        if (numero % j == 0)
	            return false;   
	    }
	    return true;
	}
}
