package br.com.gabrielmolter.strategyPattern;

import java.util.Random;


public class Partida {
	Time timeA;
	Time timeB;
	
	int scoreTimeA = 0;
	int scoreTimeB = 0;
	
	int randowDelimiter = 10;
	
	Integer duracao = 15000; //duração de cada tempo
	
	public Partida(Time timeA, Time timeB) {
		this.timeA = timeA;
		this.timeB = timeB;
	}

	public void begin() {

		long inicioJogo = System.currentTimeMillis();
		long fimJogo = inicioJogo + this.duracao;
		
		int chanceA;
		int chanceB;
		
		while(System.currentTimeMillis() < fimJogo) {
			try {
				// para evitar muitas mudanças eh uma a cada 8 segundos
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Random random = new Random();
			//Gerar chance de Gol
			chanceA = random.nextInt(randowDelimiter);
			
			//Gerar Change de defesa
			chanceB = random.nextInt(randowDelimiter);
			
			if(chanceA > chanceB) {
				this.scoreTimeA++;
			}
			//System.out.println("changeA: "+chanceA);
			//System.out.println("changeB: "+chanceB);
			
			//Contra Ataque
			chanceA = random.nextInt(randowDelimiter);
			chanceB = random.nextInt(randowDelimiter);
			
			if(chanceB > chanceA) {
				this.scoreTimeB++;
			}
			//System.out.println("changeA: "+chanceA);
			//System.out.println("changeB: "+chanceB);
			
			//Mudar Estrategia
			
			//::::::::::::::::::: PATTERN SE APLICA AKI ::::::::::::::::::::::::::::::::::
			System.out.println("::Hora de Mudar Estratégias::");
			System.out.println("::::::::::::::::::::::::::::");
			System.out.println("Score " + timeA.nome + ": " + this.scoreTimeA);
			System.out.println("Score " + timeB.nome + ": " + this.scoreTimeB);
			timeA.mudaEstategia(timeA.tecnico.ReavaliarEstrategia(scoreTimeA, scoreTimeB));
			timeB.mudaEstategia(timeB.tecnico.ReavaliarEstrategia(scoreTimeB, scoreTimeA));
			System.out.println("::::::::::::::::::::::::::::");
			
			
			try {
				// para evitar muitas mudanças eh uma a cada 7 segundos
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
		System.out.println("Fim do Jogo O placar foi ");
		System.out.println( timeA.nome + " " + scoreTimeA);
		System.out.println( timeB.nome + " " + scoreTimeB);
	}
	
	

	public void comemoracoes() {
		if(this.isEmpate()) {
			System.out.println("nenhum time declarou entrevista");
			return;
		}
		
		Time vencedor = this.getVencedor();
		Time perdedor = this.getPerdedor();
		
		vencedor.comemora();
		perdedor.chora();
	}
	
	public Time getVencedor() {
		if(scoreTimeA > scoreTimeB) {
			return timeA;
		}else if(scoreTimeA < scoreTimeB){
			return timeB;
		}else {
			return null;
		}
	}
	
	public void posJogo() {
		if(this.isEmpate()) {
			return;
		}
		Time perdedor = this.getPerdedor();
		perdedor.tecnico = null;
		System.out.println(perdedor.nome + ": Demitiu seu técnico");	
	}
	
	public Time getPerdedor() {
		if(scoreTimeA < scoreTimeB) {
			return timeA;
		}else if(scoreTimeA > scoreTimeB){
			return timeB;
		}else {
			return null;
		}
	}
	
	public Boolean isEmpate(){
		return scoreTimeA == scoreTimeB;
	}
	

}
