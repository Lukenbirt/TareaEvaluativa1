/*
 * 4a). Realiza un programa en java para guardar datos de personajes en un fichero aleatorio, dale el nombre Marvel.dat. 
 * Introduce la información de los personajes a partir de los arrays que se te proporcionan en la plataforma Moodle. 
 * Cuando termine de realizar la carga de datos deberá informar al usuario de que la carga se ha realizado satisfactoriamente o no.
 * "La carga de los personajes ha terminado correctamente"
 * Los datos por cada personaje son: (1,5 puntos)

Id:			Numero Entero.
DNI: 			String [9].
Nombre: 		String[10].
Identidad secreta: 	String[20].
Tipo: 			String[10]
Peso: 			Numero Entero.
Altura: 		Numero Entero

 */

package Tarea4;

import java.io.*;

public class Tarea4a {

	public static void main(String[] args) {
		
		try {
			
			// creo el flujo de salida
			RandomAccessFile fic = new RandomAccessFile(new File ("src/Tarea4/Marvel.dat"), "rw");
			
			// creo los arrays con los datos
			int [] ids= {1, 2, 3, 4, 5, 6, 7};
			String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
			String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
			String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
			String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
			int[] pesos = {76,84,66,136,78,102,70};
			int[] alturas = {178,183,156,152,177,182,188};
			
			// creo 4 buffers para almacenar los datos String
			StringBuffer d = null;
			StringBuffer n = null;
			StringBuffer i = null;
			StringBuffer t = null;
			
			// especifico el nº de elementos de cada linea del archivo para el for
			int num = ids.length;
			
			// recorro los arrays y escribo los datos (total = 110 bytes)
			for(int x=0; x<num; x++) {
				
				// id ocupa 4 bytes
				fic.writeInt(ids[x]);
				
				// dni ocupa 18 bytes
				d = new StringBuffer(dnis[x]);
				d.setLength(9);
				fic.writeChars(d.toString());
				
				// nom ocupa 20 bytes
				n = new StringBuffer(noms[x]);
				n.setLength(10);
				fic.writeChars(n.toString());
				
				// identidad ocupa 40 bytes
				i= new StringBuffer(identidades[x]);
				i.setLength(20);
				fic.writeChars(i.toString());
				
				// tipo ocupa 20 bytes
				t = new StringBuffer(tipos[x]);
				t.setLength(10);
				fic.writeChars(t.toString());
				
				// peso ocupa 4 bytes
				fic.writeInt(pesos[x]);
				
				// altura ocupa 4 bytes
				fic.writeInt(alturas[x]);				
			}

			// cierro el flujo de salida
			fic.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
