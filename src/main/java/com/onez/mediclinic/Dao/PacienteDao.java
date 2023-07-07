package com.onez.mediclinic.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onez.mediclinic.model.Paciente;

public interface PacienteDao extends JpaRepository<Paciente, Integer>{
	
	
//	public List<Paciente> findByNombreLike(String nombre);
//	
//	public Page<Paciente> findByNombreLike(String nombre, Pageable pageable);

}
