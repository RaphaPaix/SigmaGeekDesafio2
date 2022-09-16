package nivel2_sigmageek;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
public class LeiPi2 {
	private static final List<int[]> palindromos = new ArrayList<int[]>();
	private static final List<int[]> palindromosprimos = new ArrayList<int[]>();
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Rapha\\git\\desafio2sigmageek\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi.txt");
		String dados = new String(Files.readAllBytes(file.toPath()));
		char[] dpi = dados.toCharArray();
		//System.out.println("Tamanho char: "+dpi.length);
		int[] dPi = new int[dpi.length-2];
	     for(int i=2;i<dpi.length;i++) {
	    	 switch (dpi[i]) {
	    	case '0':
	    		dPi[i-2]=0;
				break;
	    	case '1':
	    		dPi[i-2]=1;
				break;
			case '2':
				dPi[i-2]=2;
				break;
			case '3':
				dPi[i-2]=3;
				break;
			case '4':
				dPi[i-2]=4;
				break;
			case '5':
				dPi[i-2]=5;
				break;
			case '6':
				dPi[i-2]=6;
				break;
			case '7':
				dPi[i-2]=7;
				break;
			case '8':
				dPi[i-2]=8;
				break;
			case '9':
				dPi[i-2]=9;
				break;
			default:
				break;
			}
	     }
	     /*
	     System.out.println("Vetor Int: ");
	     for(int i=0;i<dPi.length;i++) {
	    	 System.out.printf("%d",dPi[i]);
	     }
	     */
	     System.out.println("\nTamanho int excluindo 3 e . : "+dPi.length);
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
				    													//conferindo palindromo
				    													System.out.println("conferindo palindromo: ");
				    													for(int a=0;a<palindromo.length;a++) {
				    														System.out.printf(" %d",palindromo[a]);
				    													}
				    													palindromos.add(palindromo);
				    													System.out.println("\nPalindromo encontrado!");
				    													posicao[pp]=i;
				    													System.out.println("Posiçao: "+(pp+1));
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
			    if(palindromos.isEmpty()) {
			    	System.out.println("Palindromo não encontrado");
			    }else {
			    	for(int i=0;i<palindromos.size();i++) {
			    		int[] palindromo = palindromos.get(i);
			    		BigInteger palindromoBig = BigInteger.valueOf(0).setBit(22);
			    		int p = (int)posicao[i];
			    		int num=1;
			    		for(int j=0;j<21;j++) {
			    			BigInteger mult = BigInteger.valueOf(palindromo[j]*num);
			    			palindromoBig=palindromoBig.add(mult);
			    			num=num*10;
			    		}
			    		if(ehPrimo(palindromoBig.intValue())) {
			    			palindromosprimos.add(palindromo);
			    			System.out.println("O primeiro palindromo primo de Pi com 21 algarismos é o numero: ");
			    			for(int a=0;a<21;a++) {
			    				System.out.printf(" %d",palindromo[a]);
			    			}
			    			System.out.println("\nOcorreu na iteração: "+(p+1));
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
