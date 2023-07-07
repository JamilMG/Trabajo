package com.onez.mediclinic.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.onez.mediclinic.model.Paciente;

public interface IPacienteService {

	List<Paciente> listadoPacientes();
	Paciente buscarPorId(Integer id);
	void registrarPaciente(Paciente paciente);
	Paciente actualizarPaciente(Paciente paciente);
	void eliminarPaciente(Integer id);
	Page<Paciente> Paginados(Pageable pageable);
}
