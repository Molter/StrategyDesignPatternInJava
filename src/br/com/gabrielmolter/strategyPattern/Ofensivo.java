package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.EsquemaTatico;

public class Ofensivo implements EsquemaTatico {

	@Override
	public String setEsquema() {
		return "4-3-3";
	}

}
