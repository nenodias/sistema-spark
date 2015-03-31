package br.org.javateam.controller;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class ContatoController{

	public static void inicia() {
		get("/contato", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");
			attributes.put("templateName", "contato/contato.html"); 
				return new ModelAndView(attributes, "layout.html");
			}, new FreeMarkerEngine()
		);
	}

}
