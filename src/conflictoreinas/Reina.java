package conflictoreinas;

import java.util.ArrayList;
import java.util.Comparator;

public class Reina implements Comparable<Reina>{
	private int idReina;
	private int posicionFila;
	private int posicionColumna;
	private int conflictos = 0;
	private double distancia = 0;
	private ArrayList <Reina> conflictoCon;
	private ArrayList <Reina> arrayConflictoDiagonal;
	
	
	

	public Reina(int idReina, int posicionFila, int posicionColumna) {
		this.idReina = idReina;
		this.posicionFila = posicionFila;
		this.posicionColumna = posicionColumna;
		this.conflictoCon = new ArrayList<Reina>();
		this.arrayConflictoDiagonal = new ArrayList<Reina>();
	}

	public int getIdReina() {
		return idReina;
	}


	public void setIdReina(int idReina) {
		this.idReina = idReina;
	}
	
	public int getConflictos() {
		return conflictos;
	}


	public void setConflictos(int conflictos) {
		this.conflictos = conflictos;
	}


	public int getPosicionFila() {
		return posicionFila;
	}


	public void setPosicionFila(int posicionFila) {
		this.posicionFila = posicionFila;
	}


	public int getPosicionColumna() {
		return posicionColumna;
	}


	public void setPosicionColumna(int posicionColumna) {
		this.posicionColumna = posicionColumna;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public ArrayList<Reina> getConflictoCon() {
		return conflictoCon;
	}


	public void setConflictoCon(ArrayList<Reina> conflictoCon) {
		this.conflictoCon = conflictoCon;
	}
	
	public ArrayList<Reina> getArrayConflictoDiagonal() {
		return arrayConflictoDiagonal;
	}

	public void setArrayConflictoDiagonal(ArrayList<Reina> arrayConflictoDiagonal) {
		this.arrayConflictoDiagonal = arrayConflictoDiagonal;
	}
	
	
	public int compareTo(Reina reina){
			if (this.posicionFila == reina.posicionFila)
				return Integer.compare(reina.posicionColumna, this.posicionColumna);
			else
				return this.posicionFila-reina.posicionFila;
	}
	
	public static Comparator<Reina> ReinasIdComparator = new Comparator<Reina>(){
		public int compare(Reina r1, Reina r2){
			return r1.idReina - r2.idReina;
		}
	};
	
	public static Comparator<Reina> ReinasDistanciaComparator = new Comparator<Reina>(){
		public int compare(Reina r1, Reina r2){
			if (r1.distancia < r2.distancia) return -1;
	        if (r1.distancia > r2.distancia) return 1;
	        return 0;
			//return  r1.distancia - r2.distancia;
		}
	};
	
	public void agregarConflicto(Reina reinaConflictuando){
		this.conflictoCon.add(reinaConflictuando);
	}
	
	public void agregarConflictoDiagonal(Reina reinaConflictuando){
		this.arrayConflictoDiagonal.add(reinaConflictuando);
	}
	
	public static Comparator<Reina> ReinasColumnasComparator = new Comparator<Reina>(){
		public int compare(Reina r1, Reina r2){
			if(r1.posicionColumna == r2.posicionColumna){
				//return r1.posicionFila.compareTo(r2.posicionFila);
				return Integer.compare(r1.posicionFila, r2.posicionFila);
			}
			return r1.posicionColumna - r2.posicionColumna;
		}
		
	};
	
	
	
	
	public boolean conflictoDiagonal(Reina r2){
		
		if(Math.toDegrees(Math.atan((Math.pow(r2.getPosicionColumna()-this.getPosicionColumna(), 2))/(Math.pow(r2.getPosicionFila()-this.getPosicionFila(), 2)))) == 45)
			return true;
			else
				return false;
	}

}