package br.ufba.poo;

import com.googlecode.lanterna.TextColor;

import br.ufba.myterminal.MyTerminal;

public class Rotulo extends Componente {

	public Rotulo(Ponto ponto, String texto, TextColor colorFront, TextColor colorBack) {
		super.origem = ponto;
		super.texto = texto;
		super.CorDeFrente = colorFront;
		super.CorDeFundo = colorBack;
	}

	public Rotulo(Ponto ponto, String texto) {
		super.origem = ponto;
		super.texto = texto;
		super.CorDeFrente = TextColor.ANSI.WHITE;
		super.CorDeFundo = TextColor.ANSI.BLACK;
	}

	public Rotulo(String texto, TextColor colorFront, TextColor colorBack) {
		super.origem = new Ponto(0, 0);
		super.texto = texto;
		super.CorDeFrente = colorFront;
		super.CorDeFundo = colorBack;
	}

	public Rotulo(String texto) {
		super.origem = new Ponto(0, 0);
		super.texto = texto;
		super.CorDeFrente = TextColor.ANSI.WHITE;
		super.CorDeFundo = TextColor.ANSI.BLACK;
	}
	
	public void desenha(MyTerminal terminal) {
		TextColor resetFront = terminal.getForegroundColor();
		TextColor resetBack = terminal.getBackgroundColor();

		terminal.setPosition(origem.getX(), origem.getY());

		terminal.setForegroundColor(CorDeFrente);
		terminal.setBackgroundColor(CorDeFundo);

		terminal.println(texto);

		terminal.setForegroundColor(resetFront);
		terminal.setBackgroundColor(resetBack);

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		super.texto = texto;
	}
}
