package died.parcial02.ejercicio01;

import java.util.Arrays;

/**
 * Given a sorted array A, size N, of integers; 
 * every element appears twice except for one. 
 * Find that element that appears once in array.
 * 
 * 
 * |0|1|2|3|4|5|6|7|8|
 * ---------------
 * |1|2|2|3|3|4|4|5|5| = 0   - 2*n + 1 .... pARES INDICES Y LONG imPAR  MEDIO SIEMPRE ES L/2
 * |1|1|2|3|3|4|4| = 2
 * |1|1|2|2|3|4|4| = 4
 * |1|1|2|2|3|3|4| = 6
 *   
 * 0,1 siempre el indice impar es el segundo de la tupla hasta que encuentre un elemento solo
 * a partir de ahi, el indice par es el segundo de la tupla (1,2)
 * Buscar en el medio, (siempre es IMPAR porque el arreglo tiene 2N+1 elementos)
 * Si el siguiente al medio es mayor al medio, y el anterior es igual , entonces el elemento faltante está adelante<
 * Si el siguiente al medio es igual al medio, y el anterior es menor, entonces el elemento faltante está atras
 * Si el siguiente al medio es mayor al medio, y el anterior es menor, entonces el elemento faltante es el medio
 * @author marti
 *
 */
public class ElementoNoDuplicado {

	public Integer elementoSinDuplicar(Integer[] lista) {		
		return this.elementoSinDuplicar(lista, 0, lista.length-1);
	}

	private Integer elementoSinDuplicar(Integer[] lista, int inicio, int fin) {
		if (fin<inicio) return -1; 
		int medio = (fin+inicio)/2;
		if(fin==inicio) return lista[medio];
		
		if(lista[medio]<lista[medio+1] && lista[medio]>lista[medio-1]) return lista[medio];
		
		if(medio%2==0) {
			if(lista[medio].equals(lista[medio+1])) return elementoSinDuplicar(lista,medio, fin);

			if(lista[medio].equals(lista[medio-1])) return elementoSinDuplicar(lista,  inicio, medio-1);
			
		}

		if(medio%2==1) {
			if(lista[medio].equals(lista[medio-1])) return elementoSinDuplicar(lista,medio+1, fin);

			if(lista[medio].equals(lista[medio+1])) return elementoSinDuplicar(lista,  inicio, medio-1);
			
		}
		return -2;
	}
	
	public static void main(String[] args) {
		ElementoNoDuplicado esd = new ElementoNoDuplicado();
		Integer[] lista1 = {1,1,2,2,3,4,4,5,5};
		System.out.println("RESULTADO:::: ____ "+esd.elementoSinDuplicar(lista1));
		Integer[] lista2 = {1,1,2,2,3,3,4,4,5};
		System.out.println("RESULTADO:::: ____ "+esd.elementoSinDuplicar(lista2));
		Integer[] lista3 = {2,2,3,4,4,5,5};
		System.out.println("RESULTADO:::: ____ "+esd.elementoSinDuplicar(lista3));
		Integer[] lista4 = {1,1,2};
		System.out.println("RESULTADO:::: ____ "+esd.elementoSinDuplicar(lista4));
	}

}
