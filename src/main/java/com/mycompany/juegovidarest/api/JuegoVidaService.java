package com.mycompany.juegovidarest.api;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class JuegoVidaService {
	private int tablero[][];
	private int tableroResultado[][];

	public String itera(int tablero[][], int iteraciones) {
		this.tablero = tablero;
		this.tableroResultado = new int[tablero.length][tablero[0].length];
		int iteracion = 1;
		while (iteracion <= iteraciones) {
			boolean es = this.tablero == tableroResultado;
			int g = 0;
			for (int i = 0; i < this.tablero.length; i++) {
				for (int j = 0; j < this.tablero[0].length; j++) {
					if (this.tablero[i][j] == 1) {
						// Celula viva
						if (numeroAdyacentes(i, j) == 2 || numeroAdyacentes(i, j) == 3) {
							tableroResultado[i][j] = 1;
						} else {
							tableroResultado[i][j] = 0;
						}
					} else {
						boolean es2 = this.tablero == tableroResultado;
						// Celula muerta
						if (numeroAdyacentes(i, j) == 3) {
							es2 = this.tablero == tableroResultado;
							tableroResultado[i][j] = 1;							
						}
					}
				}
			}
			this.tablero = copyArray(tableroResultado);
			iteracion++;
		}
		return dibujarMatriz();
	}
	
	private int[][] copyArray(int tableroOriginal[][]) {
		int [][] copia = new int[tableroOriginal.length][tableroOriginal[0].length];
		
		for (int i = 0; i < tableroOriginal.length; i++) {
			System.arraycopy(tableroOriginal[i], 0, copia[i], 0, tableroOriginal[i].length);
		}
		return copia;
	}

	private String dibujarMatriz() {
		String dibujo = "";
		for (int i = 0; i < tableroResultado.length; i++) {
			for (int j = 0; j < tableroResultado[0].length; j++) {
				dibujo += tableroResultado[i][j];
			}
			dibujo += "\n";
		}
		return dibujo;
	}

	private int numeroAdyacentes(int i, int j) {
		int numeroAdjuntos = 0;
		int minI = i - 1 > 0 ? i - 1 : 0;
		int maxI = i + 1 < tablero.length ? i + 1 : tablero.length - 1;
		int minJ = j - 1 > 0 ? j - 1 : 0;
		int maxJ = j + 1 < tablero[i].length ? j + 1 : tablero[i].length - 1;
		for (int subI = minI; subI <= maxI; subI++) {
			for (int subJ = minJ; subJ <= maxJ; subJ++) {
				if (subI != i || subJ != j) {
					if (tablero[subI][subJ] == 1) {
						numeroAdjuntos++;
					}
				}
			}
		}
		return numeroAdjuntos;
	}
}
