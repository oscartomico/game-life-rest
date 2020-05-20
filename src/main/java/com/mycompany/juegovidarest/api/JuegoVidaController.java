package com.mycompany.juegovidarest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.juegovidarest.dto.Tablero;

@Path("/juegovida")
public class JuegoVidaController {
	@Autowired
	private JuegoVidaService service;
	
	@GET
	@Path("/itera")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getIteracion(Tablero tablero, @QueryParam("iterations") int iterations) {		
		return Response.status(200).entity(this.service.itera(tablero.getTablero(), iterations)).build();
	}	
}
