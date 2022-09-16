package nivel2_sigmageek;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownloadPi {

    public static void main(String[] args) throws IOException {
    	//funciona ate 1mi
        URL url = new URL("https://archive.org/download/Pi-1b-digit/pi1b.txt");
        
    	
    	//url do MIT
    	//URL url = new URL("https://stuff.mit.edu/afs/sipb/contrib/pi/pi-billion.txt");
        File file = new File("C:\\workspace-curso-java\\nivel2_sigmageek\\src\\nivel2_sigmageek\\pi.txt");

        FileUtils.copyURLToFile(url, file);
        System.out.println("Arquivo Baixado");
    }

}
