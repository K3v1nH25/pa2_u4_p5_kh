package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Persona;

public interface IPersonaRepository {

	public Persona seleccionarPorCedula(String cedula);

	public void insertar(Persona persona);

	public void actualizar(Persona persona);

	public void eliminarPorCedula(String cedula);

	public List<Persona> consultarTodos();

}
