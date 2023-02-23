package leason5.files.paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingProcessingFilesExample {

	public static void main(String[] args) throws IOException {
		
		
		// vamos a leer el archivo pom de este mismo proyecto y buscar 
		// el contenido de la etiqueta <groupId>
		
		
		// usamos la api Files y la api Paths
		// el metodo Files.lines() devuelve un Stream de Strings que son cada
		// linea del archvio, al devolver un Stream ya podemos procesarlo linea a linea
		
		// nota, se pueden leer multiples files pasandole separado por como todas las url
		// al metodo Paths.get() y devolvera el contenido de todos como un Stream
		
		List<String> StringList =
		Files.lines(
					Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\streams-functionalprograming\\pom.xml")
					).
					filter( line -> line.contains("groupId") ).
						map(
								line -> line.trim()
											.replaceAll("groupId", "")
											.replaceAll("<", "")
											.replaceAll(">", "")
											.replaceAll("/", "")
											
							).
							collect( Collectors.toList() );
		
		System.out.println(StringList);

	}

}
