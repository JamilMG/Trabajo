package com.onez.mediclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onez.mediclinic.model.Paciente;
import com.onez.mediclinic.services.IPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired private IPacienteService pacienteService;
	
	@GetMapping("/listar")
	public String listado(Model model,@RequestParam(required = false, defaultValue = "0") Integer page) {
		Page<Paciente> pg= pacienteService.Paginados(PageRequest.of(page, 5));
		model.addAttribute("pacientes", pg);
		model.addAttribute("paginacion", "/pacientes/listar");
		return "paciente/index";
	}
	
	@GetMapping("/nuevo")
	public String registrarProducto(Model model) {
		model.addAttribute("paciente", new Paciente());
		return "paciente/registrar";
	}
	
	@PostMapping("/guardar")
	public String guardarPaciente(@ModelAttribute("paciente") Paciente paciente) {
		pacienteService.registrarPaciente(paciente);
		return "redirect:/pacientes/listar";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		pacienteService.eliminarPaciente(id);
		return "redirect:/pacientes/listar";
	}
	
	
	@GetMapping("/editar/{id}")
	public String formularioEditar(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("paciente", pacienteService.buscarPorId(id));
		return "paciente/editar";
	}

	
	@PostMapping("/actualizar/{id}")
	public String actualizarProducto(@PathVariable("id") Integer id, @ModelAttribute("paciente")Paciente paciente) {
		Paciente paExistente= pacienteService.buscarPorId(id);
		paExistente.setId(id);
		paExistente.setNombre(paciente.getNombre());
		paExistente.setApellido(paciente.getApellido());
		paExistente.setEdad(paciente.getEdad());
		paExistente.setSexo(paciente.getSexo());
		paExistente.setDireccion(paciente.getDireccion());
		paExistente.setTelefono(paciente.getTelefono());
		paExistente.setEstado(paciente.getEstado());
		
		pacienteService.actualizarPaciente(paExistente);
			
		return "redirect:/pacientes/listar";
	} 

}

