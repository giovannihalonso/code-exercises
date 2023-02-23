package leason4.flatmap.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FlatMapperExample {

	public static void main(String[] args) {

		List<User> users = Arrays.asList(
				
					new User("Peter", 20, Arrays.asList("1", "2") ),
					new User("Sam", 40, Arrays.asList("3", "4", "5") ),
					new User("Ryan", 60, Arrays.asList("6") ),
					new User("Adam", 70, Arrays.asList("7", "8") )
				
				);
		
		// vamos a usar flatMap para iterar en un segundo nivel de anidación, en este caso 
		// primero con map iteramos sobre la lista de usuarios para acceder a su a su vez a su listado de numeros de telefono
		// de cada User y devolver esos numeros como un listado Stream, y luego sobre ese listado Stream de telefonos
		// ver cual vale "5" y devolver la primer concidencia, con findAny() que devuelve un Optional
		// se usa el metodo ifPresent() del optional para imprimir en pantalla el valor retornado
		
		Optional<String> stringOptional = users.stream().
											map( user -> user.getPhoneNumbers().stream()  ).
												flatMap( stringStream -> stringStream.filter( phone -> phone.equals("5") )  ).
													findAny();
		
		stringOptional.ifPresent(  System.out :: println  );
	
		
		// estudiar estos metodos de clase
		Optional.of(null);
		
		Optional.ofNullable(null);
		
	}

	private static boolean isNotSam(String name) {
		return !name.equals("Sam");
	}
	
	static class User {
		
		private String name;
		private Integer age = 30 ;
		private List<String> phoneNumbers;


		public User(String name, Integer age, List<String> phoneNumbers) {
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNumbers;
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

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}	
	
		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}

	}
	
}
