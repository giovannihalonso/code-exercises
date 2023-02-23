package implementandoRunnable;


class MyThreadClass implements Runnable {

	// Sobre escribimos el metodo run implementado en la interfaz Runnable
	// En este metodo run va la rutina que ejecutara cada Hilo instanciado de esta clase
	// Para correr esta rutina como Hilo, no se manda a llamar el metodo run() sino mas bien el metodo start() como se hace al extender de Thread
	@Override
	public void run() {

		// al implementar la interfaz Runnable, esta clase accede a atributos y metodos de la clase Thread , igual como lo 
		// hacen las clases que heredan de Thread, en este caso el metodo sleep() y el atributo currentTread()
		
		System.out.println(" Hola desde el hilo con Runnable, con ID "  + Thread.currentThread().getId() );
		
		try {
			Thread.sleep(5000);
	
			System.out.println(" Hola de nuevo despues de 5 mil ms osea 5 segundos, desde el hilo con ID "  + Thread.currentThread().getId() );
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		
	}
	
}


public class HiloConInterfazRunnable {

	public static void main(String[] args) {

		// donde se se diferancia la clase Thread de la interfaz Runnable es como se instancia los hilos
		
		// eje 1: instancias de hilos definiendo nuestra propia clase, aparte, que implementa Runnable
		Thread hilo1 = new Thread(    new MyThreadClass()    );
		Thread hilo2 = new Thread(    new MyThreadClass()    );
		
		hilo1.start();
		hilo2.start();
		
		// eje 2: instancia de un hilo sin definir una clase aparte, sino especificando su rutina en la instanciacion misma
		//        usando new Runnable
		Thread hilo3 = new Thread (
				
						new Runnable() {
			
							@Override
							public void run() {
								
								System.out.println(" Hola desde el hilo con Runnable sin clase aparte, con ID "  + Thread.currentThread().getId() );
								
								try {
									Thread.sleep(5000);
							
									System.out.println(" Hola de nuevo despues de 5 mil ms osea 5 segundos, desde el hilo con ID "  + Thread.currentThread().getId() );
									
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								
							}
						}
				
				      );
		
		hilo3.start();
		
	}

}
