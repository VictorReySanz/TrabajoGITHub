package practica1T6;

import java.io.*;

public class Quijote {

	public static void main(String[] args) throws IOException {
		
		OperacionesFicheros texto = new OperacionesFicheros();
		
		texto.escribir();
		texto.leerEscribir();
		System.out.println("\n");
		texto.leer();
	}
}
