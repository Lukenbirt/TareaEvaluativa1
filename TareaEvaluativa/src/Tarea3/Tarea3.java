/*
 * 3.	 (Flujos binarios:InputStream) (1,5 puntos)
Realiza un programa en Java que lea la cabecera de un fichero PDF y verifique si realmente se trata de un archivo PDF válido.
Para que un archivo sea un PDF válido, debe comenzar con la siguiente secuencia de bytes: {37, 80, 68, 70}. 
Si la cabecera no coincide con esta secuencia, el programa debe informar al usuario de que el archivo no es válido (1 punto)

 */

package Tarea3;

import java.io.*;

public class Tarea3 {

	public static void main(String[] args) {
        
        if (validacion()) {
            System.out.println("El archivo es un PDF válido.");
        } else {
            System.out.println("El archivo NO es un PDF válido.");
        }
	}

    // Método para verificar si el archivo tiene una cabecera PDF válida
    public static boolean validacion() {
    	
        // establezco los primeros cuatro bytes que debe tener un PDF válido
        byte[] cabeceraPDF = {37, 80, 68, 70};
        
        // creo un array vacío para recoger los bytes del pdf
        byte[] bytesLeidos = new byte[4];

        // creo el flujo de entrada sobre el fichero pdf
        // lo hago dentro de un try-with-resources por lo que no hace falta cerrar el flujo manualmente
        try (InputStream is = new FileInputStream("src/Tarea3/ArchivoValido.pdf");){
        			
            // leo los primeros 4 bytes del archivo y retorno false si no se leen 4 bytes
            if (is.read(bytesLeidos) != 4) {
                return false;
            }

            // comparo los bytes leídos en el archivo con la cabecera PDF esperada y retorno false si alguno no coincide
            for (int i = 0; i < 4; i++) {
                if (bytesLeidos[i] != cabeceraPDF[i]) {
                    return false;
                }
            }
            
            // si todos los bytes coinciden devuelvo true
            return true;                     
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }
    }

}
