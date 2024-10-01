/*
 * b). Desde la editorial quieren tener controlado el peso de sus personajes, ya que últimamente han hecho algún exceso que otro.
 * Realiza un programa en java que te permita modificar los datos de un personaje. El programa recibe desde la línea de comandos 
 * el dni y el peso del último mes. Si el personaje no existe devolverá un mensaje de error, sino mostrará en la consola el nombre
 *  del personaje y cuantos kilos ha engordado, adelgazado o si se mantiene en su peso. (1,5 puntos)
 */

package Tarea4;

import java.io.*;
import java.util.*;

public class Tarea4b {

	public static void main(String[] args) {
		
		// pido dni y peso del último mes al usuario
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el DNI (con letra) del personaje para control de peso: ");
	    String dniPedido = sc.nextLine();
	    System.out.println("Introduzca su peso actual: ");
	    int pesoActual = 0;
	    
	    // compruebo que el dato introducido es un entero y si no lo es me salgo del programa
	    try {
	    	pesoActual = sc.nextInt();
	    } catch (InputMismatchException e){
	    	System.out.println("Error: Entrada no válida.");
	    	sc.close();
	    	System.exit(0);
	    }
	    
	    // cierro el scanner
	    sc.close();
	      
		// creo dos variables para leer los datos del fichero
	    boolean confirmacion = false;		// para salir del programa si no existe el dni	
	    int posicion = 4;					// va a marcar la posición del puntero
	    
	    // creo el flujo de entrada
	    RandomAccessFile fic;
		try {
			fic = new RandomAccessFile(new File ("src/Tarea4/Marvel.dat"), "r");
		    
			// leo los datos del fichero
			while(posicion < fic.length()) {
				
				// posiciono el puntero en el archivo
				fic.seek(posicion);
					
				// leo el dni y lo almaceno en un string
				char dni[] = new char[9], aux;
				
				for(int i = 0; i<dni.length; i++) {
					aux = fic.readChar();
					dni[i] = aux;				
				}	
					
				String dnis = new String (dni);
					
				// compruebo si coincide con el dni introducido por el usuario	
				if(dniPedido.equals(dnis)) {
					confirmacion = true;
						
					// leo el nombre asociado al dni introducido por el usuario
					char nom[] = new char[10], aux2;
					
					for(int i = 0; i<nom.length; i++) {
						aux2 = fic.readChar();
						nom[i] = aux2;				
					}				
					String noms = new String (nom);
						
					// cambio la posicion del puntero y leo el peso
					fic.seek(posicion + 98);
					int peso = fic.readInt();
						
					//calculo la diferencia de peso
					int diferencia = pesoActual - peso;
						
					// modifico el peso en el archivo Marvel
					modificarPeso(pesoActual, posicion + 98);
					
					// lanzo el mensaje de salida según corresponda
					if(diferencia == 0) {
						System.out.println(noms.trim() + " se mantiene en su peso anterior." );
					} else if (diferencia < 0){
						System.out.println(noms.trim() + " ha adelgazado " + Math.abs(diferencia) + " kilos." );
					} else {
						System.out.println(noms.trim() + " ha engordado " + diferencia + " kilos." );
					}
				}
				
				// cambio la variable posicion para que se situe en el siguiente personaje
				posicion = posicion + 110;	
				}
		    	
		    	// sale del programa si no existe el dni
		    	if(confirmacion == false) {
		    		System.out.println("No se ha encontrado el DNI. Se cierra el programa");
		    		System.exit(0);
		    	}
		  				
			} catch (IOException e) {
				e.printStackTrace();
			}
	    
	}
	
	// modifica el peso del personaje en el archivo Marvel
	public static void modificarPeso(int peso, int posi) {
		try {
			
			// creo el flujo de salida
			RandomAccessFile fic2 = new RandomAccessFile(new File ("src/Tarea4/Marvel.dat"), "rw");
			
			// selecciono la posición del puntero
			fic2.seek(posi);
			
			// escribo el nuevo peso
			fic2.writeInt(peso);

			// cierro el flujo de salida
			fic2.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
		