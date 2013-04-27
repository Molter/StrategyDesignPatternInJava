package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;
import br.com.gabrielmolter.strategyPattern.interfaces.Tecnico;

public class Fernandao implements Tecnico{
	EsquemaTatico esquemaTatico;

	@Override
	public void saySomething() {
		System.out.println("Vamo Vamo Inter!");
	}

	@Override
	public EsquemaTatico EsquemaTaticoDefault() {
		return new Ofensivo();
	}

	@Override
	public EsquemaTatico ReavaliarEstrategia(int scoreTimeA, int scoreTimeB) {
		//Se estiver perdendo, e for por um gol de diferença
		if((scoreTimeA < scoreTimeB) && -1 == (scoreTimeA - scoreTimeB)) {
			System.out.println("Fernandao: Pelo MEIO!!");
			return new ControlePeloMeio();
			
		}else if(scoreTimeA < scoreTimeB) {
			
			System.out.println("Fernandao: Tem que ajudar na defesa");
			return new Retranca();
		}
		
		//Se nao estiver pedendo, seja ofensivo.
		System.out.println("Fernandao: Pra Frente Colorado!!");
		return new Ofensivo();
		
	}
	

}
