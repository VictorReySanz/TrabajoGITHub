/*
 * Victor Rey Sanz
 */
package practica1T6;

import java.io.*;

public class OperacionesFicheros {
	
	public void escribir() throws IOException {
		String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, adarga antigua, rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, salpicón las más noches, duelos y quebrantos los sábados, lentejas los viernes, algún palomino de añadidura los domingos, consumían las tres partes de su hacienda. El resto della concluían sayo de velarte, calzas de velludo para las fiestas con sus pantuflos de lo mismo, los días de entre semana se honraba con su vellori de lo más fino. Tenía en su casa una ama que pasaba de los cuarenta, y una sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que así ensillaba el rocín como tomaba la podadera. Frisaba la edad de nuestro hidalgo con los cincuenta años, era de complexión recia, seco de carnes, enjuto de rostro; gran madrugador y amigo de la caza. Quieren decir que tenía el sobrenombre de Quijada o Quesada (que en esto hay alguna diferencia en los autores que deste caso escriben), aunque por conjeturas verosímiles se deja entender que se llama Quijana; pero esto importa poco a nuestro cuento; basta que en la narración dél no se salga un punto de la verdad.";
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

