package br.com.gabrielmolter.strategyPattern.interfaces;


public interface Tecnico {
	public void saySomething();
	public EsquemaTatico EsquemaTaticoDefault();
	public EsquemaTatico ReavaliarEstrategia(int scoreTimeA, int scoreTimeB);
}
