package com.mycompany.juegovidarest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TableroRequest {	
	@NotNull(message = "Se debe introducir un tablero inicial")
	private int[][] tablero;
	
	@Min(value = 1, message = "Se debe de introducir un valor igual o superior a 1")
	private int iteraciones;

	public int getIteraciones() {
		return iteraciones;
	}

	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}

	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}
}
