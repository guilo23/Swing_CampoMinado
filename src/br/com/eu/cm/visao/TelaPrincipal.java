package br.com.eu.cm.visao;

import java.awt.Component;
import javax.swing.JFrame;
import br.com.eu.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	public TelaPrincipal() {
		Tabuleiro tabuleiro = new Tabuleiro(16,30,150);
		 add(new PainelTabuleiro(tabuleiro));
		
		 setTitle("CampoMinado");
		setSize(690,438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String [] Args) {
		new TelaPrincipal();
	}
}
