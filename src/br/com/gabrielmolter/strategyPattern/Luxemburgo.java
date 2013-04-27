package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;
import br.com.gabrielmolter.strategyPattern.interfaces.Tecnico;

public class Luxemburgo implements Tecnico {
	EsquemaTatico esquemaTatico;
	
	@Override
	public void saySomething() {
		System.out.println("Tem que passar a Bola!");
	}

	@Override
	public EsquemaTatico EsquemaTaticoDefault() {
		return new ControlePeloMeio();
	}

	@Override
	public EsquemaTatico ReavaliarEstrategia(int scoreTimeA, int scoreTimeB) {
		if(scoreTimeA > scoreTimeB) {
			System.out.println("Luxemburgo: Garra Tricolor!");
			return new Ofensivo();
		}
		
		if(scoreTimeA < scoreTimeB) {
			System.out.println("Luxemburgo: Vamos Marcar, tem que marcar!");
			return new ControlePeloMeio();
		}

		System.out.println("Luxemburgo: Tem que passar a Bola!!!");
		return new ControlePeloMeio();	
	}

}
