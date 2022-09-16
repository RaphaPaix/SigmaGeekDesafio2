package nivel2_sigmageek;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LerPi {
	private static final List<int[]> palindromosprimos = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception {
		//esse codigo le o arquivo arbitrariamente
		//o arquivo pi.txt contem 1 milhao de decimais do pi (no site informa 1bi)
		//foi obtido no site: https://archive.org/details/Pi-1b-digit
		FileInputStream entrada = new FileInputStream("C:\\workspace-curso-java\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi.txt"); //copiamos o endereço do arquivo pi
	     InputStreamReader entradaFormatada = new InputStreamReader(entrada);
	     int c = entradaFormatada.read();
	     int tamanho=1000002;
	     char[] caracteresPi = new char[tamanho-2];
	     int contador=0;
	     //deve-se considerar o numero 3 e o ponto como char
	     while( c!=-1&&contador!=tamanho){  //ate qual char o arquivo deve ser lido
	      //System.out.print( (char) c);
	      if(contador>=2) {
	    	  caracteresPi[contador-2]=(char)c;
	      }
	      c = entradaFormatada.read();
	      contador++;
	     }
	     //convertendendo vetor char para int
	     int[] dPi = new int[tamanho-2];
	     for(int i=0;i<tamanho-2;i++) {
	    	 switch (caracteresPi[i]) {
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
			default:
				break;
			}
	     }
	     //teste impressao vetor
	     /*
	     System.out.println("\n5 finais do Vetor Int: ");
	     for(int i=999995;i<tamanho-2;i++) {
	    	 System.out.printf("%d",dPi[i]);
	     }
	     */
	     System.out.println("\nTamanho: "+dPi.length);
	     //agora vamos encontrar palindromos
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
			    													int[] palindromo = new int[21];
			    													int k=i;
			    													for(int j=0;j<21;j++) {
			    														palindromo[j]=dPi[k];
			    														k++;
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
		    		int[] palindromo = palindromosprimos.get(i);
		    		BigInteger palindromoBig = BigInteger.valueOf(0).setBit(22);
		    		int p = (int)posicao[i];
		    		int num=1;
		    		for(int j=0;j<21;j++) {
		    			BigInteger mult = BigInteger.valueOf(palindromo[j]*num);
		    			palindromoBig=palindromoBig.add(mult);
		    			num=num*10;
		    		}
		    		if(ehPrimo(palindromoBig.intValue())) {
		    			System.out.println("O primeiro palindromo primo de Pi com 21 algarismos é o numero: "+palindromo);
		    			System.out.println("Ocorreu na iteração: "+p);
		    		}
		    	}
		    }
	     entradaFormatada.close();
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
