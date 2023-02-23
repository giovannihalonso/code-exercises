package waitAndNofityAll;


class Saludo {
	
	// atributo de control para ver si se lanza o no el wait() para evitar que un hilo se quede bloqueado asi nada mas
	private boolean haLlegadoJefe;
	
	public Saludo() {
		this.haLlegadoJefe = false;
	}
	
	// este metodo se quedara en espera por el uso de wait(), wait solo puede ser usado en bloques synchronidez
	public synchronized void saludoEmpleado( String nombre ) {
		
		try 
		{	
			// un hilo al ejecutar el metodo saludoEmpleado, se quedara esperando hasta que otro hilo lance un notifyAll()
			if( ! this.haLlegadoJefe  ) {
				wait();
				
				// despues de que un notifyAll sea recibido, se desbloquea el wait() y se imprime la linea de abajo
				System.out.println( nombre +  " : Buenos dias jefe " );
			}
			
			// si ya llego el jefe (nuestra variable de control), ya no lanzamos el wait() o el hilo se quedaria bloqueado siempre
			else {
				System.out.println( nombre +  " : Disculpas por el retraso " );
			}
			

		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	// este metodo desbloqueara todos los hilos que esten esperando por el metodo wait(), al lanzar el metodo nofifyAll()
	public synchronized void saludoJefe( String nombre ) {
		
		System.out.println( nombre +  " : Buenos dias empleados " );
		
		this.haLlegadoJefe = true;
		
		notifyAll();
	
	}	
}


class Empleado extends Thread {

	String nombre;
	Saludo saludo;
	boolean esJefe;
	
	public Empleado(String nombre, Saludo saludo, boolean esJefe) {
		this.nombre = nombre;
		this.saludo = saludo;
		this.esJefe = esJefe;
	}

	public void run() {

		System.out.println(nombre + " llego");
		
		if(esJefe) {
			saludo.saludoJefe(nombre);
		}
		else {
			saludo.saludoEmpleado(nombre);
		}
	}
	
}



public class MultiHilosSynchronidezWaitNotifyAll {

	public static void main(String[] args) {
		
		// se instancian los hilos empleados y se arrancan
		
		Saludo s = new Saludo();
		
		Empleado e1 = new Empleado("Orlas", s, false);
		Empleado e2 = new Empleado("Tachi", s, false);
		Empleado e3 = new Empleado("Gio", s, false);
		Empleado jefe = new Empleado("Gerry", s, true);
		
		// al arrancar los hilos, aquellos hilos empleados que llegen antes del jefe se quedaran esperando hasta que el jefe 
		// llegue y salude, despues ellos saludaran, aquellos hilos que lleguen despues del jefe no saludaran sino pediran 
		// disculpas por el retraso
		e1.start();
		e2.start();
		e3.start();
		jefe.start();
	}

}
