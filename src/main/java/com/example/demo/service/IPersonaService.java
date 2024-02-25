package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Persona;

public interface IPersonaService {

	public Persona consultarPorCedula(String cedula);

	public void guardar(Persona persona);

	public void actualizar(Persona persona);

	public void borrarPorCedula(String cedula);

	public List<Persona> consultarTodos();

}
