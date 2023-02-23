package leason6.lambda.expressions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda {

	public static void main(String[] args) {

		
		//  instanciamos un obejeto Game, implementando la interfaz en estilo imperativo o normal
		
		Game football = new Game() {
			public void play() {
				System.out.println("I'm Playing FootBall");
			}
		};
		
		football.play();
		
		// instanciamos un obejeto Game, implementando la interfaz en functional style o con lambdas
		//  aqui como la interfaz Game tiene un solo metodo a implementar toma por default que el
		// System.out.println es para el metodo play()
		
		Game footballLambda = () -> System.out.println("I'm Playing FootBall with lambdas");
	
		footballLambda.play();
		
		// ahora lambda expressions con argumentos, para la interfaz Series, igual con solo un metodo a
		// implementar
		
		Series odiSeries = ( type ) -> System.out.println("It's a "+ type + " series ");
		
		odiSeries.play("ODI");
		
		// de un arreglo de strings con nombres de jugadores ver si alguno de ellos
		// es Sachin
		
		List<String> players = Arrays.asList("Kholi", "David", "Sachin");
		
		// de forma imperativa
		
		for (String player : players) {
			if( player.equals("Sachin") ) {
				System.out.println("yes, Sachin is in the squad");
			}
		}
		
		// con lambda notation
		players.stream().
					filter( player -> player.equals("Sachin") ).
						forEach( player -> System.out.println("yes, Sachin is in the squad" ) );
		
		
		// ahora validando una bandera 
		
		// de forma imperativa
		boolean SachinFlag = false;
		for (String player : players) {
			if( player.equals("Sachin") ) {
				System.out.println("yes, Sachin is in the squad");
				SachinFlag = true;
			}
		}
		
		if(SachinFlag) {
			System.out.println("yes");
		}
		
		// con lambda expressions
		Optional<String> op = players.stream().
								filter( player -> player.equals("Sachin") ).
									findFirst();
		
		if( op.isPresent()  ) {
			System.out.println("yes");
		}
		
	}

	interface Game {
		
		void play();
		
	}
	
	interface Series {
		
		void play ( String type );
		
	}
	
}
