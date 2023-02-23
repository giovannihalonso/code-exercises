package leason3.mapToInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperIntExample {

	public static void main(String[] args) {

		
		List<String> names = Arrays.asList( "Peter", "Sam", "Greg", "Ryan" );
		
		List<User> userList = names.stream().
				filter( MapperIntExample::isNotSam ).
					map( 
						User::new
					).
						collect( Collectors.toList() );

		// Vamos a acumular las edades de los usuarios,
		// iterando los usarios y sumando sus edades
		
		int sum = userList.stream().
						mapToInt( user -> {
							return user.getAge();
						}).sum();
		
		System.out.println(sum);
		
		// refactor 1
		int sum2 = userList.stream().
						mapToInt( user -> user.getAge() ).sum();

		System.out.println(sum2);
		
		// refactor 2 con Method Reference
		int sum3 = userList.stream().
						mapToInt( User::getAge ).sum();

		System.out.println(sum3);
		
		
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
