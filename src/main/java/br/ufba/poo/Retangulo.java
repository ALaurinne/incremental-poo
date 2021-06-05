package br.ufba.poo;

import com.googlecode.lanterna.TextColor;

import br.ufba.myterminal.MyTerminal;

public class Retangulo extends Rotulo {
	
	public Retangulo(Ponto origem, Ponto cantoOposto) {
		super(origem, String.valueOf(caractere));
		if(cantoOposto.getX() < getOrigem().getX() || cantoOposto.getY() < getOrigem().getY())
			throw new IllegalArgumentException("Dimensoes invalidas");
		else
			this.cantoOposto = cantoOposto;
	}

	public Retangulo(Ponto origem, int largura, int altura) {
		super(origem, String.valueOf(caractere));
		if(largura <= 0 || altura <= 0 )
			throw new IllegalArgumentException("Dimensoes invalidas");
		else
			this.cantoOposto = super.getOrigem().comDeslocamento(largura - 1, altura - 1);
	}

	public void redimensiona(int largura, int altura) {
		if(largura <= 0 || altura <= 0 )
			throw new IllegalArgumentException("Dimensoes invalidas");
		else
			this.cantoOposto = super.getOrigem().comDeslocamento(largura - 1, altura - 1);
	}

	public void desloca(int dx, int dy) {
		setOrigem(getOrigem().comDeslocamento(dx, dy));
		setCantoOposto(getCantoOposto().comDeslocamento(dx, dy));
	}

	public char getCaractere() {
		return caractere;
	}

	public void setCaractere(char caractere) {
		Retangulo.caractere = caractere;
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

	public void setLargura(int largura) {
		if(largura <= 0)
			throw new IllegalArgumentException("Dimensoes invalidas");
		else
			this.cantoOposto = super.getOrigem().comDeslocamento(largura - 1, getAltura() - 1);
	}

	public int getLargura() {
		return cantoOposto.getX() - getOrigem().getX() + 1;
	}

	
	public void setAltura(int altura) {
		if(altura <= 0)
			throw new IllegalArgumentException("Dimensoes invalidas");
		else	
			this.cantoOposto = super.getOrigem().comDeslocamento(getLargura() - 1, altura - 1);
	}
	
	public int getAltura() {
		return cantoOposto.getY() - getOrigem().getY() + 1;
	}
	
	public void desenha(MyTerminal terminal) {

		TextColor defaultForegroundColor = terminal.getForegroundColor();
		TextColor defaultBackgroundColor = terminal.getBackgroundColor();

		terminal.setForegroundColor(getCorDeFrente());
		terminal.setBackgroundColor(getCorDeFundo());

		for (int x = 0; x < getAltura(); x++) {
			terminal.setPosition(getOrigem().getX(), getOrigem().getY() + x);
			for (int y = 0; y < getLargura(); y++) {
				setTexto(String.valueOf(caractere));
				terminal.print(getTexto());
			}
		}

		terminal.setForegroundColor(defaultForegroundColor);
		terminal.setBackgroundColor(defaultBackgroundColor);
		super.desenha(terminal);
	}
}
