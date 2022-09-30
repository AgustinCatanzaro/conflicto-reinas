package conflictoreinas;

import java.io.*;
import java.util.*;


public class ConflictoReinas {
	private int cantidadReinas;
	private ArrayList <Reina> reinas;
	private int dimensionTablero;
	
	
	
	public ConflictoReinas(String misReinas) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(misReinas));
		
		this.dimensionTablero = sc.nextInt();
		
		this.cantidadReinas = sc.nextInt();
		
		this.reinas = new ArrayList <Reina>();
		
		for(int i = 0 ; i < this.cantidadReinas ; i++){
			reinas.add(new Reina((i+1),sc.nextInt(),sc.nextInt()));
			
		}
		
	}
	
	
	
	public void calcularConflicto() throws IOException{
		
		
		//Crear Archivo
		PrintWriter salida = null;
		String miPath="C:\\Users\\agust\\Desktop\\Facultad\\POO\\POO2\\WorkSpace\\ConflictoEntreReinas\\";
		

		Collections.sort(reinas);
		for(int i = 0 ; i < this.cantidadReinas-1 ; i++){//Ordenar/Comparar segun Fila
			//reinas.get(i).setConflictoCon(new ArrayList<Reina>());
			
			if(reinas.get(i).getPosicionFila() == reinas.get(i+1).getPosicionFila()){
				reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
				reinas.get(i).agregarConflicto(reinas.get(i+1));
				
				reinas.get(i+1).setConflictos(reinas.get(i+1).getConflictos()+1);
				reinas.get(i+1).agregarConflicto(reinas.get(i));
				
			}
		
		}//Termina for para Ordenar/Comparar Segun Fila
		
		for(int i = 0 ; i < this.cantidadReinas ; i++){ // Cargar todos los conflictos diagonales
			for(int j = 0 ; j < this.cantidadReinas ; j++){
				if(reinas.get(i).conflictoDiagonal(reinas.get(j)) == true){
					reinas.get(i).agregarConflictoDiagonal(reinas.get(j));
					/*reinas.get(j).setDistancia(Math.sqrt(Math.pow(reinas.get(j).getPosicionFila()-reinas.get(i).getPosicionFila(), 2)
				+Math.pow(reinas.get(j).getPosicionColumna()-reinas.get(i).getPosicionColumna(), 2)));*/
					reinas.get(j).setDistancia(Math.sqrt(Math.pow(reinas.get(j).getPosicionColumna()-reinas.get(i).getPosicionColumna(), 2)
							+Math.pow(reinas.get(j).getPosicionFila()-reinas.get(i).getPosicionFila(), 2)));
				}
			}
			
			Collections.sort(reinas.get(i).getArrayConflictoDiagonal(), Reina.ReinasDistanciaComparator);
			int flagTL = 0, flagTR = 0, flagBL = 0, flagBR = 0;
			for (int j = 0 ; j < reinas.get(i).getArrayConflictoDiagonal().size() ; j ++){//Determinar Conflictos Diagonales validos
				if(reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionFila() > reinas.get(i).getPosicionFila() && reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionColumna() > reinas.get(i).getPosicionColumna() && flagBR == 0){// Diagonal Abajo/Derecha
					reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
					reinas.get(i).agregarConflicto(reinas.get(i).getArrayConflictoDiagonal().get(j));
					flagBR = 1;
				}
				else if(reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionFila() > reinas.get(i).getPosicionFila() && reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionColumna() < reinas.get(i).getPosicionColumna() && flagBL == 0){// Diagonal Abajo/Izquierda
					reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
					reinas.get(i).agregarConflicto(reinas.get(i).getArrayConflictoDiagonal().get(j));
					flagBL = 1;
				}
				else if(reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionFila() < reinas.get(i).getPosicionFila() && reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionColumna() > reinas.get(i).getPosicionColumna() && flagTR == 0){// Diagonal Arriba/Derecha
					reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
					reinas.get(i).agregarConflicto(reinas.get(i).getArrayConflictoDiagonal().get(j));
					flagTR = 1;
				}
				else if(reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionFila() < reinas.get(i).getPosicionFila() && reinas.get(i).getArrayConflictoDiagonal().get(j).getPosicionColumna() < reinas.get(i).getPosicionColumna() && flagTL == 0){// Diagonal Arriba/Izquierda
					reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
					reinas.get(i).agregarConflicto(reinas.get(i).getArrayConflictoDiagonal().get(j));
					flagTL = 1;
				}
			}
			}//Termina Determinar Diagonales
			

		Collections.sort(reinas, Reina.ReinasColumnasComparator);
		for(int i = 0 ; i < this.cantidadReinas-1 ; i++){//Orderanar/Comparar segun Columna
			
			if(reinas.get(i).getPosicionColumna() == reinas.get(i+1).getPosicionColumna()){
				reinas.get(i).setConflictos(reinas.get(i).getConflictos()+1);
				reinas.get(i).agregarConflicto(reinas.get(i+1));
				
				reinas.get(i+1).setConflictos(reinas.get(i+1).getConflictos()+1);
				reinas.get(i+1).agregarConflicto(reinas.get(i));
				
			}
			
			
		}//Termina for para Ordenar/Comparar Segun Columna
		
		
		salida=new PrintWriter(new FileWriter(miPath+"output.txt"/*, true*/));

		Collections.sort(reinas, Reina.ReinasIdComparator);
		
		for(int i = 0 ; i < this.cantidadReinas ; i++){
			if(reinas.get(i).getConflictoCon() == null){
				salida.println(0);
			}else{
				Collections.sort(reinas.get(i).getConflictoCon(), Reina.ReinasIdComparator);
				salida.print(reinas.get(i).getConflictos());
				for(int j = 0 ; j < reinas.get(i).getConflictoCon().size() ; j++){
				salida.print(" "+reinas.get(i).getConflictoCon().get(j).getIdReina());
				}
				salida.println(" ");
			}
			
		}
		
		
		salida.close();
	
		
	}

	

	public static void main(String[] args) throws IOException {
		ConflictoReinas r1 = new ConflictoReinas("input");

		r1.calcularConflicto();
		
		//r1.calcularConflicto();

		
	}

}
