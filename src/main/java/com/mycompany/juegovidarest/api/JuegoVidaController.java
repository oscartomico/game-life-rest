package com.mycompany.juegovidarest.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.juegovidarest.dto.TableroRequest;
import com.mycompany.juegovidarest.dto.TableroResponse;

@CrossOrigin
@RestController
@RequestMapping("/juegovida")
public class JuegoVidaController {
	@Autowired
	private JuegoVidaService service;
	
	@ResponseBody
	@RequestMapping(value = "/itera", consumes = "application/json")
	public ResponseEntity getIteracion(@Valid @RequestBody TableroRequest tablero) {
		String tableroString = service.itera(tablero.getTablero(), tablero.getIteraciones());
		TableroResponse response = new TableroResponse();
		response.setTablero(tableroString);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/saludo")
	public ResponseEntity saludo() {		
		return ResponseEntity.ok().build();
	}
}
