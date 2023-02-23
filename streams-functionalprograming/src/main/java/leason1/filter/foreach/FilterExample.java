package leason1.filter.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList( "Peter", "Sam", "Greg", "Ryan" );
	
		
		System.out.println("con for e if");
		
		// iteramos los elementos de la lista, y filtramos, imprimiendo los nombre diferentes a Sam, usando el condicional if
		for (String name : names) {
			if(  !name.equals("Sam")  ) {
				System.out.println( name );
			}
		}
		
		System.out.println("con filter y foreach con predicaco y consumer anonimos");
		
		// con Streams, 
		// usando filter con su functional interfaz anonima Predicate y sobreescribimos el metodo test, 
		// y forEach usando su Consumer Anonimo
		names.stream()
				.filter(  new Predicate <String> () {
							public boolean test(String name) {
								return !name.equals("Sam");
							}
						} )
							.forEach( new Consumer<String>() {
								
								@Override
								public void accept(String name) {
									System.out.println( name);
								}
								
							});
		
		System.out.println("con filter y foreach con lambda notation");
		
		// Con Streams
		// usando filter con lambda notation 
		// y forEach con lambda notation
		names.stream().
				filter( name -> !name.equals("Sam")  ).
					forEach( name -> System.out.println( name )  );
		
		System.out.println("con filter y foreach con method reference");
		
		// Con Streams
		// usando filter con method reference
		// y forEach con method reference
		names.stream().
				filter( FilterExample::isNotSam).
					forEach( System.out::println);
		
		
	}

	private static boolean isNotSam(String name) {
		return !name.equals("Sam");
	}

}
