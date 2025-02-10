package br.com.eu.cm.visao;

import br.com.eu.cm.modelo.Campo;
import br.com.eu.cm.modelo.CampoEvento;
import br.com.eu.cm.modelo.CampoObservador;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {
    private final Color BG_PADRAO = new Color(184,184,184);
    private final Color BG_MARCAR = new Color(8,179,247);
    private final Color BG_EXPLODIR = new Color(189,66,68);
    private final Color TEXTO_VERDE = new Color(0,100,0);

    private Campo campo;
    public BotaoCampo(Campo campo) {
        campo.registrarObservador(this);
		this.campo = campo;
        setBackground(BG_PADRAO);
        setOpaque(true);
        setBorder(BorderFactory.createBevelBorder(0));
        addMouseListener(this);
    }

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
            switch(evento) {
                case ABRIR:
                    aplicarEstiloAbrir();
                    break;
                case EXPLODIR:
                    aplicarEstiloExplodir();
                    break;
                case MARCAR:
                    aplicarEstiloMarcar();
                    break;
                default:
                    aplicarEstiloPadrao();
            }
    }

    private void aplicarEstiloPadrao() {
    	setBorder(BorderFactory.createBevelBorder(0));
    	setBackground(BG_PADRAO);
        setText("");
    }

    private void aplicarEstiloMarcar() {
        setBackground(BG_MARCAR);
        setForeground(Color.black);
        setText("M");
    }

    private void aplicarEstiloAbrir() {
        
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        if(campo.isMinado()){
            setBackground(BG_EXPLODIR);
            return;    
        }

        setBackground(BG_PADRAO);

        switch (campo.minasNaVizinhanca()) {
            case 1:
                setForeground(TEXTO_VERDE);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);
                break;
        }

        String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "": "";
        setText(valor);
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_EXPLODIR);
        setForeground(Color.white);
        setText("X");
    }

    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) { // Botão esquerdo do mouse
            campo.abrir();
        } else if(e.getButton() == MouseEvent.BUTTON3) { // Botão direito do mouse
            campo.alternarMarcacao();
        }
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

