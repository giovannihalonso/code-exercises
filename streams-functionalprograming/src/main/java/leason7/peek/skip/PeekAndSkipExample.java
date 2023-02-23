package leason7.peek.skip;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekAndSkipExample {

	public static void main(String[] args) {
	
		
		// se usa peek() para imprimir mirar o debuggear los resultados de alguna operación intermedia en Streams
		// es un tipo  logger. Nota, se debe de asegurar que despues de un peek() siga una termial operation para asegurarnos
		// que peek() se ejecutara
		
		// aqui se crea un stream, al que se le filtra la palabra One, por ello solo pasan Two y Three, por ello peek() solo imprimira Two y Three
		// y al final se devolveran como una lista de Stings
		List<String> strings =  Stream.of("One", "Two", "Three")
			.filter(obj -> !obj.equals("One") )
			.peek( obj -> System.out.println( "Peeked-logged: " + obj ) )
			.collect(Collectors.toList());
		
		// skip() se aplica a un stream y se le pasa un argumento numerico, ese argumento dice cuantos elementos ya no se tomaran en cuenta de se stream partiendo del inicio, para las operaciones
		// que se le apliquen al stram, es el analogo a un substring
		
		// solo imprimira 6 y 7, pues al decir skip(2), ya no se contemplan los valores 1 y 23 del stream original. De los valores restantes solo 6 y 7 cumplen la condicion del filter
		IntStream.of(1,23,4,5,6,7)
			.skip(2)
			.filter( i -> i > 5 )
			.forEach( i -> System.out.println( i ) );
		
		
		
	}

}
