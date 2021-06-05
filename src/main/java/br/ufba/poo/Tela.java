package br.ufba.poo;

import br.ufba.myterminal.MyTerminal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tela extends Componente {
	private ArrayList<Componente> retangulos;
	private ArrayList<Componente> rotulos;

	public Tela() {
		this.retangulos = new ArrayList<Componente>();
		this.rotulos = new ArrayList<Componente>();
	}

	public void addComponente(Retangulo retangulo) {
		this.retangulos.add(retangulo);
	}

	public void addComponente(Rotulo rotulo) {
		this.rotulos.add(rotulo);
	}


	public void desenha(MyTerminal terminal) {
		
		this.rotulos.size();
		
		for (int x = 0; x < rotulos.size(); x++) {
			this.rotulos.get(x).desenha(terminal);
		}
		
		terminal.clear();
		
		for (int y = 0; y < retangulos.size(); y++) {
			this.retangulos.get(y).desenha(terminal);
		}
		
	}

	public void setRotulos(ArrayList<Componente> rotulos) {
		this.rotulos = rotulos;
	}
	
	public List<Componente> getComponentes() {
		return Collections.unmodifiableList(retangulos);
	}
}
