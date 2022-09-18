package nivel2_sigmageek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//nao adianta, da heap space tb
public class LerPi3 {
	public static void main(String[] args) throws Exception {
		File caminhoDoTexto = new File("C:\\Users\\Rapha\\git\\desafio2sigmageek\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi2.txt");
		FileReader lerCaminhoDoTexto = new FileReader(caminhoDoTexto);
		BufferedReader lerArquivo = new BufferedReader(lerCaminhoDoTexto);
		String nova=null;
		String antiga="0";
		int[] vetorUltimos8 = new int[8];
		//testar com palindromo primo de 9 numeros
		//preciso salvar a linha anterior com a proxima, e assim sucessivamente
		while (lerArquivo.ready()) {
            nova = lerArquivo.readLine();
            char[] charLinhaNova = new char[nova.length()];
            charLinhaNova=nova.toCharArray();
            //transformar vetor char em vetor int
        	int[] vetorLinhaNova = new int[charLinhaNova.length-2];
            for(int i=2;i<charLinhaNova.length;i++) {
            	switch (charLinhaNova[i]) {
				case '0':
					vetorLinhaNova[i-2]=0;
					break;
				case '1':
					vetorLinhaNova[i-2]=1;
					break;
				case '2':
					vetorLinhaNova[i-2]=2;
					break;
				case '3':
					vetorLinhaNova[i-2]=3;
					break;
				case '4':
					vetorLinhaNova[i-2]=4;
					break;
				case '5':
					vetorLinhaNova[i-2]=5;
					break;
				case '6':
					vetorLinhaNova[i-2]=6;
					break;
				case '7':
					vetorLinhaNova[i-2]=7;
					break;
				case '8':
					vetorLinhaNova[i-2]=8;
					break;
				case '9':
					vetorLinhaNova[i-2]=9;
					break;
				default:
					break;
				}
            }
            if(antiga.equals("0")) {
            	for(int i=0;i<vetorLinhaNova.length;i++) {
            		if(vetorLinhaNova[i]==vetorLinhaNova[i+8]) {
            			if(vetorLinhaNova[i+1]==vetorLinhaNova[i+7]) {
            				if(vetorLinhaNova[i+2]==vetorLinhaNova[i+6]) {
            					if(vetorLinhaNova[i+3]==vetorLinhaNova[i+5]) {
            						int[] palindromo = new int[9];
									int k=i;
									for(int j=0;j<9;j++) {
										palindromo[j]=vetorLinhaNova[k];
										k++;
									}
									Combinacao9 combinacao9 = new Combinacao9();
									combinacao9.setCombinacao(palindromo);
									combinacao9.somaPosiçoes();
									System.out.println("Palindromo: "+combinacao9.getSoma());
									if(ehPrimo(combinacao9.getSoma().intValue())) {
										System.out.println("É primo!!");
										lerArquivo.close();
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
            	//guardando os ultimos 8 da linha
            	vetorUltimos8[0]=vetorLinhaNova[vetorLinhaNova.length-8];
            	vetorUltimos8[1]=vetorLinhaNova[vetorLinhaNova.length-7];
            	vetorUltimos8[2]=vetorLinhaNova[vetorLinhaNova.length-6];
            	vetorUltimos8[3]=vetorLinhaNova[vetorLinhaNova.length-5];
            	vetorUltimos8[4]=vetorLinhaNova[vetorLinhaNova.length-4];
            	vetorUltimos8[5]=vetorLinhaNova[vetorLinhaNova.length-3];
            	vetorUltimos8[6]=vetorLinhaNova[vetorLinhaNova.length-2];
            	vetorUltimos8[7]=vetorLinhaNova[vetorLinhaNova.length-1];
            	antiga=nova;
            }else {
            	//conferindo os ultimos 8 da linha anterior com o primeiro da linha nova
            	if(vetorUltimos8[0]==vetorLinhaNova[0]) {
            		if(vetorUltimos8[1]==vetorUltimos8[7]) {
            			if(vetorUltimos8[2]==vetorUltimos8[6]) {
            				if(vetorUltimos8[3]==vetorUltimos8[5]) {
            					int[] palindromo = new int[9];
            					for(int i=0;i<8;i++) {
            						palindromo[i]=vetorUltimos8[i];
            					}
            					palindromo[8]=vetorLinhaNova[0];
            					Combinacao9 combinacao9 = new Combinacao9();
								combinacao9.setCombinacao(palindromo);
								combinacao9.somaPosiçoes();
								System.out.println("Palindromo: "+combinacao9.getSoma());
								if(ehPrimo(combinacao9.getSoma().intValue())) {
									System.out.println("É primo!!");
									lerArquivo.close();
								}
            				}
            			}
            		}
            	}else {
            		for(int i=0;i<vetorLinhaNova.length;i++) {
                		if(vetorLinhaNova[i]==vetorLinhaNova[i+8]) {
                			if(vetorLinhaNova[i+1]==vetorLinhaNova[i+7]) {
                				if(vetorLinhaNova[i+2]==vetorLinhaNova[i+6]) {
                					if(vetorLinhaNova[i+3]==vetorLinhaNova[i+5]) {
                						int[] palindromo = new int[9];
    									int k=i;
    									for(int j=0;j<9;j++) {
    										palindromo[j]=vetorLinhaNova[k];
    										k++;
    									}
    									Combinacao9 combinacao9 = new Combinacao9();
    									combinacao9.setCombinacao(palindromo);
    									combinacao9.somaPosiçoes();
    									System.out.println("Palindromo: "+combinacao9.getSoma());
    									if(ehPrimo(combinacao9.getSoma().intValue())) {
    										System.out.println("É primo!!");
    										lerArquivo.close();
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
                	//guardando os ultimos 8 da linha
                	vetorUltimos8[0]=vetorLinhaNova[vetorLinhaNova.length-8];
                	vetorUltimos8[1]=vetorLinhaNova[vetorLinhaNova.length-7];
                	vetorUltimos8[2]=vetorLinhaNova[vetorLinhaNova.length-6];
                	vetorUltimos8[3]=vetorLinhaNova[vetorLinhaNova.length-5];
                	vetorUltimos8[4]=vetorLinhaNova[vetorLinhaNova.length-4];
                	vetorUltimos8[5]=vetorLinhaNova[vetorLinhaNova.length-3];
                	vetorUltimos8[6]=vetorLinhaNova[vetorLinhaNova.length-2];
                	vetorUltimos8[7]=vetorLinhaNova[vetorLinhaNova.length-1];
                	antiga=nova;
            	}
            }
        }
        lerArquivo.close();
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
