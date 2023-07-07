package com.onez.mediclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.onez.mediclinic.Dao.PacienteDao;
import com.onez.mediclinic.model.Paciente;

@Service
public class PacienteService implements IPacienteService{
	
	@Autowired private PacienteDao pacienteDao;

	@Override
	public List<Paciente> listadoPacientes() {
		return pacienteDao.findAll();
	}
	
	
	@Override
	public Paciente buscarPorId(Integer id) {
		return pacienteDao.findById(id).orElse(null);
	}


	@Override
	public void registrarPaciente(Paciente paciente) {
		pacienteDao.save(paciente);
		
	}


	@Override
	public Paciente actualizarPaciente(Paciente producto) {
		return pacienteDao.save(producto);
	}

	
	@Override
	public void eliminarPaciente(Integer id) {
		pacienteDao.deleteById(id);
	}


	@Override
	public Page<Paciente> Paginados(Pageable pageable) {
		return pacienteDao.findAll(pageable);
	}
}

