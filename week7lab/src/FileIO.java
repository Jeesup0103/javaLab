import java.io.*;
public class FileIO {

	public static void main(String[] args) {
		try{
			InputStream fis = new FileInputStream("input.txt");
			Reader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			FileOutputStream fos = new FileOutputStream("output.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos); 
			BufferedWriter bw = new BufferedWriter(osw);
			
			String data;
			String[] inverseData = new String[2000];
			int i = 0;
			while(true) {
				data = br.readLine();
				if(data == null) break;
				inverseData[i] = data;
				i++;
			}
			i--;
			while(i >= 0)
			{
				bw.write(inverseData[i]);
				if(i == 0) break;
				bw.newLine();
				i--;
			}
			bw.flush();
			br.close();
			isr.close();
			fis.close();
			bw.close(); 
			fos.close(); 
			osw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
