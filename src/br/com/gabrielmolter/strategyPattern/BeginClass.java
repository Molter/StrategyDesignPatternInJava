package br.com.gabrielmolter.strategyPattern;

import br.com.gabrielmolter.strategyPattern.interfaces.Tecnico;

/**
 * Demonstração do Design Pattern Strategy
 * 
 * O exemplo irá demonstrar um Técnico de Futebol que comanda seu time,
 * de acordo com tempo de jogo e o score do time, o técnico muda de estratégia.
 * 
 * A aplicação em Codigo do pattern eh facilmente visualizada dentro da classe PArtida.
 * 
 * @author Gabriel Molter <gabriel.molter@gmail.com>
 *
 */
public class BeginClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * Cria o time, e atribui um treinador, cada treinador tem um esquema tatico por padrao,
		 * o pattern se aplica nessa mundaça de esquemas taticos sem alterar o codigo principal
		 */
		Tecnico fernandao = new Fernandao();
		Time inter = new Time(fernandao, "Inter");
		
		Tecnico luxemburgo = new Luxemburgo();
		Time gremio = new Time(luxemburgo, "Grêmio");
		
		Partida jogo = new Partida(inter, gremio);
		
		//criar jogo com duração, 1 min, 3O SEG CADA TEMPO
		//aletario para tentar gol a cada 15 seg
		//mudar esquema tatico, ganhando e de acordo com o adversario
		System.out.println("Bem amigos da Rede Globo, iniciaremos o jogo:");
		
		jogo.begin();
		jogo.comemoracoes();
		jogo.posJogo();
	}

}
