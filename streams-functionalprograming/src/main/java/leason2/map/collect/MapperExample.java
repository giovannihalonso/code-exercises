package leason2.map.collect;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperExample {

	public static void main(String[] args) {
		
		// Map y Collect ejemplo
		
		List<String> names = Arrays.asList( "Peter", "Sam", "Greg", "Ryan" );
		
		
		// map usando su functional interface "Function" con su metodo apply, 
		// Apply lo que hace es recibe un tipo de objeto A, y devuelve un tipo de Objerto B,
		// Donde B puede o no, ser del mismo tipo que A
		
		names.stream().
			filter( MapperExample::isNotSam ).
				map( new Function<String , User> () {
						@Override
						public User apply(String name) {
							User user = new User(name);
							return user;
						}
					}	
				).
					forEach( System.out::println );
		
		// map usando lambda expression, y ejemplo de lambda expression refactorizado
		names.stream().
			filter( MapperExample::isNotSam ).
				map( 
					name -> {
						User user = new User(name);
						return user;
					}
				).
					forEach( System.out::println );
		
		// ó 
		
		names.stream().
			filter( MapperExample::isNotSam ).
				map( 
					name -> {
						return new User(name);
					}
				).
					forEach( System.out::println );
			
		// ó
		
		names.stream().
			filter( MapperExample::isNotSam ).
				map( 
					name -> new User(name)
				).
					forEach( System.out::println );
		
		
		// map usando method reference, aqui map le pasa el nombre iterado al constructor de User definido
		// para devolver un objeto User, que luego ese User sera tomado por forEach y lo imprimira
		names.stream().
			filter( MapperExample::isNotSam ).
				map( 
					User::new
				).
					forEach( System.out::println );
		
		// Ahora usamos Collect, al igual que forEach es una terminal operation para streams, 
		// sive para acumular el resultado y devolverlo, Collect usa la libreria Collectors
		// aqui se hace esto: se filtra names por un String, luego se combierte al tipo User y al final
		// se retorna como una nueva lista del tipo User
		List<User> userList = names.stream().
			filter( MapperExample::isNotSam ).
				map( 
					User::new
				).
					collect( Collectors.toList() );
		
		
	}
	
	private static boolean isNotSam(String name) {
		return !name.equals("Sam");
	}
	
	static class User {
		
		private String name;
		private Integer age = 30 ;
		
		public User(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}	
		
	}

}
