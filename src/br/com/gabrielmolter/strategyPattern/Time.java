package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;
import br.com.gabrielmolter.strategyPattern.interfaces.Tecnico;

public class Time {
	Tecnico tecnico;
	EsquemaTatico esquemaTatico;
	String nome;
	
	public Time(Tecnico tecnico, String nome) {
		this.tecnico = tecnico;
		this.esquemaTatico = new ControlePeloMeio();
		this.nome = nome;
		
		mudaEstategia(tecnico.EsquemaTaticoDefault());
	}

	public void comemora() {
		System.out.println(this.nome + ": Feito!");
	}
	
	public void chora(){
		System.out.println(this.nome + ": mimimimi!");		
	}

	public void mudaEstategia(EsquemaTatico esquemaTatico) {
		System.out.println(this.nome + " mudou seu esquema para " + esquemaTatico.setEsquema());
		this.esquemaTatico = esquemaTatico;
	}
}
