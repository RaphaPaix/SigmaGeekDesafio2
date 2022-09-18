package nivel2_sigmageek;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class RepartirArquivoMenor {
	private final static List<char[]>mList=new ArrayList<char[]>();
	public static void main(String[] args) throws Exception {
		File file = new File( "C:\\Users\\Rapha\\git\\desafio2sigmageek\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi2.txt" );
		FileInputStream entrada = new FileInputStream( file );
		System.out.println("Tamanho do arquivo: "+file.length());
		int cont;
		byte[] buffer = new byte[50000];
		int iteracao=0;
		while ( ( cont = entrada.read( buffer ) ) > -1 ) {
			iteracao++; //atraves disso descobri que o heap space acaba quando 
			// chega na iteraçao 17714, ou seja, so consigo obter pi ate 885700000
			if(iteracao<15000) {
				System.out.println("Iteração: "+iteracao);
			     char[] charme = new char[buffer.length];
			     for(int i=0;i<buffer.length;i++) {
			    	 charme[i]=(char)buffer[i];
			     }
			     mList.add(charme);
			}
		}
		char[] charme = mList.get(0);
		for(int i=0;i<10;i++) {
			System.out.println(charme[i]);
		}
		
		//apenas os ultimos 50k tem ficado salvos, e de tras pra frente
		//agora é ver como obter o inteiro dentro do byte

		//vou fazer 2 arquivos para ler o pi 1 bilhao seguindo este codigo
		
	}
}
