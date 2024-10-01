/*
 2.	 Flujos de caracteres: (BufferedReader, BufferedWriter) (1,5 puntos)
Crea un programa en Java que lea un archivo con nombres y apellidos separados
por espacios, y escriba en un nuevo archivo solo los nombres que tienen exactamente cinco letras.

 */

package Tarea2;

import java.io.*;

public class Tarea2 {
	
	public static void main(String[] args) {
		try {
			// creo el flujo de entrada sobre un fichero de lectura
			BufferedReader fic1 = new BufferedReader(new FileReader(new File("src/Tarea2/ArchivoEntrada.txt")));

            // creo el flujo de salida sobre un fichero de escritura
            BufferedWriter fic2 = new BufferedWriter(new FileWriter(new File("src/Tarea2/ArchivoSalida.txt")));

            // variable para agregar o no una nueva línea en el fichero de salida
            boolean agregarLinea = false;
            
            // leo el fichero de entrada línea por línea
            String linea;
            while ((linea = fic1.readLine()) != null) {
                
            	// divido la línea en palabras
                String[] palabras = linea.split(" ");

                // proceso solo la primera palabra (el nombre) y si cumple los requisitos la escribo en el archivo de salida
                String palabra = palabras[0];
                if (palabra.length() == 5) {
                	
                    // agrega o no una nueva línea antes de escribir el nombre
                    if (agregarLinea) {
                        fic2.newLine();
                    }
                    
                    fic2.write(palabra);
                    agregarLinea = true;              	

                }
            }            
                     
            // cierro el flujo de entrada
            fic1.close();
            
            // cierro el flujo de salida        
            fic2.close();
            System.out.println("Tarea Finalizada.");
		} catch (IOException e) {
			e.printStackTrace();
		}		// 

	}

}
