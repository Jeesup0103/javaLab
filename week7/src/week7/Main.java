package week7;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("output");
			OutputStreamWriter osw = new OutputStreamWriter(fos); 
			BufferedWriter bw = new BufferedWriter(osw);
			String data = "abc";
			bw.write(data);
			bw.newLine();
			bw.write(data,0,1);
			bw.flush();
			bw.close(); 
			fos.close(); 
			osw.close();
			} catch (IOException e) { e.printStackTrace();
		}
	}
}
