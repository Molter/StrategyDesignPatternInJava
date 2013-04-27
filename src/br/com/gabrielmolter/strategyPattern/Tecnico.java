package br.com.gabrielmolter.strategyPattern;

public interface Tecnico {
	public void saySomething();
	public EsquemaTatico EsquemaTaticoDefault();
	public EsquemaTatico ReavaliarEstrategia(int scoreTimeA, int scoreTimeB);
}
