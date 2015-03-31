package br.org.javateam.main;

import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Spark;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;
import br.org.javateam.controller.ContatoController;

public class Aplicacao implements SparkApplication {
	
	public static void main(String[] args) {
		new Aplicacao().init();
	}

	@Override
	public void init() {
		port(1234);
		//Nessa Pasta ficarão css javascript
		staticFileLocation("/static");
		Spark.get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("templateName", "index.html"); 
				return new ModelAndView(attributes, "layout.html");
			}, new FreeMarkerEngine()
		);
		ContatoController.inicia();
	}

}
