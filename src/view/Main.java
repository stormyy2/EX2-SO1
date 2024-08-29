package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController comando = new RedesController();
		
		int opc = 0;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Configuração do IP \n 2- Chamada do Ping \n 9- Finalizar"));
			switch(opc) {
				case 1:
					comando.ip();
					break;
				case 2:
					comando.ping();
					break;
				case 9:
					JOptionPane.showMessageDialog(null, "Programa finalizado.");
					break;
			}
			
		}
	}

}
