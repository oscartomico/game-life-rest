package com.mycompany.juegovidarest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mycompany.juegovidarest.api.JuegoVidaController;

@Component
@ApplicationPath("/JuegoVidaRest")
public class JuegoVidaConfig extends ResourceConfig {

	public JuegoVidaConfig () {
		register(JuegoVidaController.class);
	}
	
}
