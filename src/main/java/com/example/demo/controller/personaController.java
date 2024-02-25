package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/buscar")
	public String buscarPorCedula(String cedula) {
		return null;
	}

	@PutMapping("/actualizar")
	public String actualizar() {
		return null;
	}

	@DeleteMapping("/borrar")
	public String borrar() {
		return null;
	}

	@PostMapping("/guardar")
	public String guardar() {
		return null;
	}

}
