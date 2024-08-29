package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	
	public void ip() {
		String os = os();
		String cmd = "";
		
		if(os.contains("Windows")) {
			cmd = "IPCONFIG";
		} else if(os.contains("Linux")) {
			cmd = "ipconfig";
		}
		
		String cmdArray[] = cmd.split(" ");
		try {
			Process prc = Runtime.getRuntime().exec(cmdArray);
			InputStream fluxo = prc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				if(linha.contains("IPv4")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
		
		
	}
	
	public void ping() {
		String os = os();
		String cmd = "";
		if(os.contains("Windows")) {
			cmd = "ping -4 -n 10 www.google.com.br";
		} else if(os.contains("Linux")) {
			cmd = "ping -4 -c 10 www.google.com.br";
		}
		
		String cmdArray[] = cmd.split(" ");
		try {
			Process prc = Runtime.getRuntime().exec(cmdArray);
			InputStream fluxo = prc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				if(linha.contains("dia") || linha.contains("avg")) {
					System.out.println(linha);
				}
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
			
		} catch(Exception e) {
			String msg = e.getMessage();
			System.err.println(msg);
		}
		
	}

	
	
}
