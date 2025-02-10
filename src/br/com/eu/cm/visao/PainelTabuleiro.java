package br.com.eu.cm.visao;

import br.com.eu.cm.modelo.ResultadoEvento;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.com.eu.cm.modelo.Tabuleiro;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel{
	
	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(),tabuleiro.getColunas()));
		
		
		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservadores(e -> {
			SwingUtilities.invokeLater(() ->{
			if(e.isGanhou()){
				JOptionPane.showMessageDialog(this,"Ganhou :)");
			}else{
				JOptionPane.showMessageDialog(this,"Perdeu :(");
			}
			tabuleiro.reiniciar();
			});
		});
		}
	}
