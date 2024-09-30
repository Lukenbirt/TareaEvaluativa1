/*
 * 1.	Flujos de caracteres: (FileReader, FileWriter) (1,5 puntos)
Escribe un programa en Java que lea una línea de texto desde un archivo y devuelva la misma línea,
pero con las palabras invertidas individualmente. Es decir, si el archivo contiene "Hola Mundo", 
el archivo de salida debería contener "aloH odnuM".

 */

package Tarea1;

import java.io.*;

public class Tarea1 {

	public static void main(String[] args) {
		
		try {
			// creo el flujo de entrada sobre un fichero de lectura
			FileReader fic1 = new FileReader(new File("src/Tarea1/ArchivoEntrada.txt"));
			
			// creo un StringBuilder para almacenar el contenido
			StringBuilder contenido = new StringBuilder();
			
			// leo el contenido del fichero y lo almaceno
            int i;
            while ((i = fic1.read()) != -1) {
                contenido.append((char) i);
            }
            
            // cierro el flujo de entrada
            fic1.close(); //

            // separo el contenido en palabras
            String[] palabras = contenido.toString().split(" ");
            
            // creo un StringBuilder que almacenará el contenido de salida
            StringBuilder resultado = new StringBuilder();
            
            // invierto cada palabra y voy almacenando el resultado
            for (String palabra : palabras) {
                resultado.append(new StringBuilder(palabra).reverse().toString()).append(" ");
            }

            // creo el flujo de salida sobre un fichero de escritura
            FileWriter fic2 = new FileWriter(new File("src/Tarea1/ArchivoSalida.txt"));
            
            // escribo el resultado eliminando los espacios iniciales y finales y cierro el flujo de salida
            fic2.write(resultado.toString().trim());
            fic2.close();
            System.out.println("Tarea Finalizada.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
