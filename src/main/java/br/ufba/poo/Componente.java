package br.ufba.poo;

import com.googlecode.lanterna.TextColor;

import br.ufba.myterminal.MyTerminal;

public class Componente {
	
	protected static char caractere = ' ';
	protected String texto;
	protected Ponto origem;
	protected Ponto cantoOposto;
	protected TextColor CorDeFrente;
	protected TextColor CorDeFundo;
	
	public Ponto getOrigem() {
		return origem;
	}
	
	public void setOrigem(Ponto origem) {
		this.origem = origem;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getLargura() {
		return cantoOposto.getX() - getOrigem().getX() + 1;
	}

	public int getAltura() {
		return cantoOposto.getY() - getOrigem().getY() + 1;
	}


	public TextColor getCorDeFrente() {
		return CorDeFrente;
	}

	public void setCorDeFrente(TextColor corDeFrente) {
		CorDeFrente = corDeFrente;
	}

	public TextColor getCorDeFundo() {
		return CorDeFundo;
	}

	public void setCorDeFundo(TextColor corDeFundo) {
		CorDeFundo = corDeFundo;
	}
	
	public Ponto getCantoOposto() {
		return cantoOposto;
	}
	
	public void setCantoOposto(Ponto cantoOposto) {
		if(cantoOposto.getX() < getOrigem().getX() || cantoOposto.getY() < getOrigem().getY())
			throw new IllegalArgumentException("Dimensoes invalidas");
		else	
			this.cantoOposto = cantoOposto;
	}

	public void desenha(MyTerminal terminal) {
		TextColor resetFront = terminal.getForegroundColor();
		TextColor resetBack = terminal.getBackgroundColor();

		terminal.setForegroundColor(getCorDeFrente());
		terminal.setBackgroundColor(getCorDeFundo());
		
		terminal.setPosition(origem.getX(), origem.getY());
		
		for (int x = 0; x < getAltura(); x++) {
			terminal.setPosition(getOrigem().getX(), getOrigem().getY() + x);
			for (int y = 0; y < getLargura(); y++) {
				setTexto(String.valueOf(caractere));
				terminal.print(getTexto());
			}
		}

		terminal.setForegroundColor(CorDeFrente);
		terminal.setBackgroundColor(CorDeFundo);

		terminal.println(texto);

		terminal.setForegroundColor(resetFront);
		terminal.setBackgroundColor(resetBack);

	}
}
