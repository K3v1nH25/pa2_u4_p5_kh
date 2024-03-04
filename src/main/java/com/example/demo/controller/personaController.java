package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Persona;
import com.example.demo.service.IPersonaService;

// http://localhost8080/
//http://localhost:8080/personas/buscar

@Controller
@RequestMapping("/personas")
public class personaController {

	@Autowired
	private IPersonaService iPersonaService;

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Persona> lista = this.iPersonaService.consultarTodos();
		modelo.addAttribute("personas", lista);
		return "vistaListaPersona";
	}

	// Cuando viaja el modelo en el response
	@GetMapping("/buscarPorCedula/{cedulaPersona}")
	public String buscarPorCedula(@PathVariable("cedulaPersona") String cedula, Model modelo) {
		Persona persona = this.iPersonaService.consultarPorCedula(cedula);
		modelo.addAttribute("persona", persona);
		return "vistaPersona";
	}

	// cuando viaja el modelo en el request
	@PutMapping("/actualizar/{cedulaPersona}")
	public String actualizar(@PathVariable("cedulaPersona") String cedula, Persona persona) {
		persona.setCedula(cedula);

		Persona pers = this.iPersonaService.consultarPorCedula(cedula);
		pers.setApellido(persona.getApellido());
		pers.setNombre(persona.getNombre());
		pers.setGenero(persona.getGenero());
		pers.setCedula(persona.getCedula());

		this.iPersonaService.actualizar(pers);
		// redirect: y la url
		return "redirect:/personas/buscarTodos";
	}

	@PostMapping("/insertar")
	public String insertar(Persona persona) {
		this.iPersonaService.guardar(persona);
		return "redirect:/personas/buscarTodos";

	}

	@GetMapping("/nuevaPersona")
	public String mostrarNuevaPersona(Model modelo) {
		modelo.addAttribute("persona", new Persona());
		return "vistaNuevaPersona";
	}

	@DeleteMapping("/borrar/{cedula}")
	public String borrar(@PathVariable("cedula") String cedula) {
		this.iPersonaService.borrarPorCedula(cedula);
		return "redirect:/personas/buscarTodos";
	}

	@PostMapping("/guardar")
	public String guardar() {
		return null;
	}

}
