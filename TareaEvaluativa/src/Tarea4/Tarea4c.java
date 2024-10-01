/*
 * 4c). Realiza un programa en Java que te permita visualizar los personajes de un tipo concreto (héroe o villano). El programa recibe desde la línea de comandos el tipo de personaje y visualiza cuantos personajes hay de dicho tipo y todos los datos de dichos personajes. Verifica que exista dicho tipo en el fichero, si no existe saca un mensaje de error por pantalla. (1,5 puntos)
Nota: Hay que pensar que el fichero puede crecer en un futuro y aparecer nuevos tipos

 */
package Tarea4;

import java.io.*;
import java.util.*;

public class Tarea4c {

	public static void main(String[] args) {
		
		// pregunto el tipo de personaje
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce un tipo de personaje: ");
	    String tipoUsuario = sc.nextLine();
	    sc.close();

		// creo variables para leer los datos del fichero
		int posicion = 4;					// va a marcar la posición del puntero
		int contadorTipos = 0;				// cuento los tipos que existen
		ArrayList<String> listaDni = new ArrayList<>();
		ArrayList<String> listaNombre = new ArrayList<>();
		ArrayList<String> listaIdentidad = new ArrayList<>();
		ArrayList<String> listaTipo = new ArrayList<>();
		ArrayList<Integer> listaPeso = new ArrayList<>();
		ArrayList<Integer> listaAltura = new ArrayList<>();

	    // creo el flujo de entrada
	    RandomAccessFile fic;
		try {
			fic = new RandomAccessFile(new File ("src/Tarea4/Marvel.dat"), "r");
			
			// recorro los datos del fichero
			while(posicion < fic.length()) {
				
				// posiciono el puntero en el archivo
				fic.seek(posicion);
				
				// leo los datos
				char dni[] = new char[9], aux1;
				
				for(int i = 0; i<dni.length; i++) {
					aux1 = fic.readChar();
					dni[i] = aux1;				
				}				
				String dnis = new String (dni);
				dnis = dnis.trim();
				
				char nom[] = new char[10], aux2;
				
				for(int i = 0; i<nom.length; i++) {
					aux2 = fic.readChar();
					nom[i] = aux2;				
				}				
				String noms = new String (nom);
				noms = noms.trim();
				
				char identidad[] = new char[20], aux3;
				
				for(int i = 0; i<identidad.length; i++) {
					aux3 = fic.readChar();
					identidad[i] = aux3;				
				}				
				String identidades = new String (identidad);
				identidades = identidades.trim();
				
				char tipo[] = new char[10], aux4;
				
				for(int i = 0; i<tipo.length; i++) {
					aux4 = fic.readChar();
					tipo[i] = aux4;				
				}				
				String tipos = new String (tipo);
				tipos = tipos.trim();
				
				int peso = fic.readInt();
				int altura = fic.readInt();
				
				// si coincide el tipo  introduzco los datos en arrays
				if(tipoUsuario.equals(tipos)) {
					contadorTipos++;
					listaDni.add(dnis);
					listaNombre.add(noms);
					listaIdentidad.add(identidades);
					listaTipo.add(tipos);
					listaPeso.add(peso);
					listaAltura.add(altura);
				}
				
				// modifico la variable posicion para que se situe en el siguiente personaje
				posicion = posicion + 110;
			}
			
		  				
		} catch (IOException e) {
				e.printStackTrace();
		}		

		// si no existe el tipo lo visualizo por consola
		if(contadorTipos == 0) {
			System.out.print("No existen " + tipoUsuario + " en el fichero.");
		}
		
		// muestro el resultado por consola
		if(contadorTipos != 0) {
			
			// visualizo el numero de tipos
			System.out.println("Se han encontrado " + contadorTipos + " " + tipoUsuario + "s.");
			
			// visualizo los datos de los personajes encontrados
			for(int i=0; i < listaDni.size(); i++) {
			    System.out.printf("Personaje [dni=%s, nombre=%-10s, identidad=%-20s, tipo=%-5s, peso=%-3d, altura=%-3d]%n",
	                      listaDni.get(i),
	                      listaNombre.get(i),
	                      listaIdentidad.get(i),
	                      listaTipo.get(i),
	                      listaPeso.get(i),
	                      listaAltura.get(i));
			}
		}
	}

}
