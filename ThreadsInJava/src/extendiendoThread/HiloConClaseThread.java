package extendiendoThread;



class MyThreadClass extends Thread {

	// Sobre escribimos el metodo run heredado de la clase Thread
	// En este metodo run va la rutina que ejecutara cada Hilo instanciado de esta clase
	// Para correr esta rutina como Hilo, no se manda a llamar el metodo run() sino mas bien el metodo start()
	public void run() {
		
		// la clase Thread tiene argumentos de clase, entre ellos currentThread, del cual sacamos su id para identificarlo
		System.out.println(" Hola desde el hilo con ID "  + Thread.currentThread().getId() );
		
		try {
			// El metodo de clase, llamado sleep, detiene la ejecución de la rutina, segun el num de milisegundos
			// indicados
			Thread.sleep(5000);
	
			System.out.println(" Hola de nuevo despues de 5 mil ms osea 5 segundos, desde el hilo con ID "  + Thread.currentThread().getId() );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}	
}





public class HiloConClaseThread {

	public static void main(String[] args) {

		// instanciamos un objeto tipo Thread de la clase MyThreadClass que se creo arriba
		MyThreadClass hilo1 = new MyThreadClass();
		
		// Echamos a andar la rutina del objeto hilo1 como hilo con el metodo start
		hilo1.start();
		
		
		// hacemos lo mismo creando otro hilo o instancia de la clase MyThreadClass
		MyThreadClass hilo2 = new MyThreadClass();
		hilo2.start();
		
	}

}
