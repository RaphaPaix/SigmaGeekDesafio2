package nivel2_sigmageek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class RepartirPi {
	private final static List<byte[]>mList=new ArrayList<byte[]>();
	public static void main(String[] args) throws Exception {
		File file = new File( "C:\\Users\\Rapha\\git\\desafio2sigmageek\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi2.txt" );
		FileInputStream fis = new FileInputStream( file );
		System.out.println(file.length());
		int cont;
		byte[] particao = new byte[50000];
		int a=0;
		while ( ( cont = fis.read( particao ) ) > -1 ) {
		     mList.add(a,  particao );
		     a++;
		}
		byte[] teste = new byte[50000];
		teste=mList.get(1);
		for(int i=0;i<5;i++) {
			System.out.printf(" %c",(char)teste[i]);
		}

		//agora é ver como obter o inteiro dentro do byte


	}
}
