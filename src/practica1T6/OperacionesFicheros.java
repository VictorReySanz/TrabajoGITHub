/*
 * Victor Rey Sanz
 */
package practica1T6;

import java.io.*;

public class OperacionesFicheros {
	
	public void escribir() throws IOException {
		String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que viv�a un hidalgo de los de lanza en astillero, adarga antigua, roc�n flaco y galgo corredor. Una olla de algo m�s vaca que carnero, salpic�n las m�s noches, duelos y quebrantos los s�bados, lentejas los viernes, alg�n palomino de a�adidura los domingos, consum�an las tres partes de su hacienda. El resto della conclu�an sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los d�as de entre semana se honraba con su vellori de lo m�s fino. Ten�a en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que as� ensillaba el roc�n como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta a�os, era de complexi�n recia, seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza. Quieren decir que ten�a el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben), aunque por conjeturas veros�miles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento; basta que en la narraci�n d�l no se salga un punto de la verdad.";
		File fichero = new File("Quijote.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(fichero);
			for(int i=0; i<texto.length(); i++) {
				char caracter = texto.charAt(i);
				fw.write(caracter);
			}
			if(fw!=null) {
				fw.close();
			}
		}catch(FileNotFoundException e) {
			System.out.println("Error: Fichero no encontrado");
			System.out.println(e.getMessage());
		}
	}
	
	public void leerEscribir() throws IOException {
		File lectura = new File("Quijote.txt");
		File escritura = new File("Quijote_lineas.txt");
		
		if(lectura.exists()) {
				FileReader fr = new FileReader(lectura);
				FileWriter fw = new FileWriter(escritura);
				BufferedWriter bw = new BufferedWriter(fw);
				
				int caracter = 0;
				String frase = "";
				
				while(caracter != -1) {
					frase = frase + (char)caracter;
					
					if((char)caracter=='.' || (char)caracter==',' || (char)caracter==';') {
						bw.write(frase);
						bw.newLine();
						bw.flush();
						frase ="";
					}
					caracter = fr.read();
					System.out.print((char)caracter);
					
					
					
				}
				fr.close();
				bw.close();
		}
	}
	
	public void leer() throws IOException {
		File fichero = new File("Quijote_lineas.txt");
		if (fichero.exists()){
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String caracter;
			while ((caracter = br.readLine()) != null ) {
				System.out.println(caracter);
			}
			if (fr != null) {
				fr.close();
			}
		}
	}
	
}

