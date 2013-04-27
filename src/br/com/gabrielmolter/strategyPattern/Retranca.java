package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;

public class Retranca implements EsquemaTatico{

	@Override
	public String setEsquema() {
		return "5-4-1";
	}

}
