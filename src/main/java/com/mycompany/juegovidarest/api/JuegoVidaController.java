package com.mycompany.juegovidarest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/juegovida")
public class JuegoVidaController {
	@Autowired
	private JuegoVidaService service;
	
//	@RequestMapping(value = "/itera")
//	public Response getIteracion(Tablero tablero, @QueryParam("iterations") int iterations) {		
//		return Response.status(200).entity(this.service.itera(tablero.getTablero(), iterations)).build();
//	}
	
	@RequestMapping(value = "/saludo")
	public ResponseEntity saludo() {		
		return ResponseEntity.ok().build();
	}
}
