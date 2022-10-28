package ud1_boletin7;

import java.io.*;

public class PingTest {
	
	private String ping;
	
	public void procesoPingTest(String ping) {
        String pingResult = "";
        String pingCmd = "ping " + ping;
		 try {
	            Runtime r = Runtime.getRuntime();
	            Process p = r.exec(pingCmd);
	            // Inicializa el lector del buffer
	            BufferedReader in = new BufferedReader
	            		(new InputStreamReader(p.getInputStream()));
	            String inputLine;
	            while ((inputLine = in.readLine()) != null){
	                System.out.println(inputLine);
	                pingResult += inputLine;
	            }
	            in.close();
	        } catch (IOException e) {
	            System.out.println(e);
	        }
	}
	
    public static void main(String[] args) {
    	PingTest pingTest = new PingTest();
    	pingTest.procesoPingTest("8.8.8.8");
    }
}
