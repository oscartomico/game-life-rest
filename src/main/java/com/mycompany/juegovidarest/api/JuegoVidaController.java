package com.mycompany.juegovidarest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity getIteracion(@RequestBody TableroRequest tablero, @RequestParam("iteraciones") int iteraciones) {
		String tableroString = service.itera(tablero.getTablero(), iteraciones);
		TableroResponse response = new TableroResponse();
		response.setTablero(tableroString);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/saludo")
	public ResponseEntity saludo() {		
		return ResponseEntity.ok().build();
	}
}
