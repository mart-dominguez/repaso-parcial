package died.parcial02.ejercicio02;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class GrafoCiudades extends Grafo<Ciudad> {

	
	public static void main(String[] args) {
		GrafoCiudades gf = new GrafoCiudades();
		Ciudad cA = new Ciudad("A",40);
		Ciudad cB = new Ciudad("B",70);
		Ciudad cC = new Ciudad("C",50);
		Ciudad cD = new Ciudad("D",70);
		Ciudad cE = new Ciudad("E",30);
		Ciudad cF = new Ciudad("F",50);
		Ciudad cG = new Ciudad("G",30);
		Ciudad cH = new Ciudad("H",60);
		Ciudad cI = new Ciudad("I",60);
		Ciudad cK = new Ciudad("K",40);
		gf.addNodo(cA);
		gf.addNodo(cC);
		gf.addNodo(cD);
		gf.addNodo(cE);
		gf.addNodo(cF);
		gf.addNodo(cG);
		gf.addNodo(cH);
		gf.addNodo(cI);
		gf.addNodo(cK);
		gf.addNodo(cB);

		gf.conectar(cA, cC);
		gf.conectar(cA, cD);
		gf.conectar(cB, cE);
		gf.conectar(cB, cF);
		gf.conectar(cC, cG);
		gf.conectar(cD, cG);
		gf.conectar(cD, cH);
		gf.conectar(cE, cK);
		gf.conectar(cF, cG);
		gf.conectar(cF, cI);
		gf.conectar(cG, cI);
		gf.conectar(cH, cI);
		gf.conectar(cI, cK);
		gf.conectar(cA, cB);

		System.out.println(gf.camino(cA,cK,30));
	}
	
	public List<Ciudad> camino(Ciudad c1, Ciudad c2,Integer n){
		// c1 es adyacente de c2, entonces tengo un camino
		// c1 es adyacente de ci y ci es adyacente de c2..... recursiva
		List<Ciudad> caminoInicial = new LinkedList<Ciudad>();
		caminoInicial.add(c1);
		return camino(c1,c2,n,caminoInicial);
	}
	
	private List<Ciudad> camino(Ciudad ciudadOrigen, Ciudad ciudadDestino, Integer n,List<Ciudad> caminoTemporal){
		List<Ciudad> adyacentesAC1 = this.getAdyacentes(ciudadOrigen);
		for(Ciudad unaCiudad : adyacentesAC1) {
			if(unaCiudad.equals(ciudadDestino)) {
				caminoTemporal.add(unaCiudad);
				return caminoTemporal;
			} else {
				// sea parte del camino 
				if(unaCiudad.habitantes >n) {
					caminoTemporal.add(unaCiudad);
					List<Ciudad> resultado = camino(unaCiudad,ciudadDestino,n,caminoTemporal);
					if(resultado == null) caminoTemporal.remove(unaCiudad);
					else return resultado;
				}
			}
		}
		return null; // TODO acordar de retornar corecto
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Ciudad> camino2(Ciudad c1,Ciudad c2,Integer poblacion){
//		List<Ciudad> camino = new ArrayList<Ciudad>();
//		camino.add(c1);
//		return camino2(c1,c2,poblacion,camino,new LinkedHashSet<Ciudad>());		
//	}
//	
//	private List<Ciudad> camino2(Ciudad c1,Ciudad c2,Integer poblacion,List<Ciudad> camino,Set<Ciudad> procesados){
//		List<Ciudad> adyacentes = getAdyacentes(c1);
//		procesados.add(c1);
//		
//		for(Ciudad unaCiudad : adyacentes) {
//			if(unaCiudad.equals(c2)) {
//				camino.add(unaCiudad);
//				return camino;
//			} else {
//				if(unaCiudad.habitantes>=poblacion) {
//					camino.add(unaCiudad);
//					List<Ciudad> hayCamino = camino2(unaCiudad,c2,poblacion,camino,procesados);
//					if(hayCamino!=null && !hayCamino.isEmpty()) return hayCamino;
//					else camino.remove(unaCiudad);
//				}
//			}
//		}
//		return new ArrayList<Ciudad>();
//	}

}
