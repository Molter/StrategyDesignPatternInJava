package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;

public class ControlePeloMeio implements EsquemaTatico {

	@Override
	public String setEsquema() {
		return "3-5-2";
	}

}
