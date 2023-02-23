package joinAndSynchronised;

public class MultiHilosJoinSynchronidez {

	// variable de clase o static, de uso comun para los hilos q se creen
	private static int count = 0;
	
	// variable de clase o static, de uso comun para los hilos q se creen
	private static int count2 = 0;
		
	
	// metodo de clase static que usa la palabra reservada synchronidez
	public static synchronized void incrementaConSynchronidez() {
		count ++;
	}
	
	
	public static void main(String[] args) {

		// creamos 4 hilos, 2 y 2 con la misma rutina
		
		// t1 y t2 si usan un metodo con synchronidez 
		Thread t1 = new Thread( new Runnable() {	
						@Override
						public void run() {
							for( int i = 0; i < 1000 ; i++ ) {
								incrementaConSynchronidez();
							}
						}
					}
				);
		
		Thread t2 = new Thread( new Runnable() {	
				@Override
				public void run() {
					for( int i = 0; i < 1000 ; i++ ) {
						incrementaConSynchronidez();
					}
				}
			}
		);

		
		// t1 y t3 no usan synchronized
		Thread t3 = new Thread( new Runnable() {	
				@Override
				public void run() {
					for( int i = 0; i < 1000 ; i++ ) {
						count2++;
					}
				}
			}
		);
	
		Thread t4 = new Thread( new Runnable() {	
				@Override
				public void run() {
					for( int i = 0; i < 1000 ; i++ ) {
						count2++;
					}
				}
			}
		);
		
		
		// arrancamos los 4 hilos
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		// hacemos que el thread del metodo main espere hasta q las rutinas de los 4 hilos terminen para seguir despues
		// con las demas lineas de codigo, esto lo logramos con el metodo join()
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println( " valor de count despues de la ejecucion de hilos: " + count );
		// imprime seguro 2000
		
		System.out.println( " valor de count2 despues de la ejecucion de hilos: " + count2 );
		// no imprime si o si 2000, sino un valor en el orden de los 1000 y algo
		
	}

}
