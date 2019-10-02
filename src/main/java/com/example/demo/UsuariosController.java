package com.example.demo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Usuario;
import com.example.demo.entities.UsuariosRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	private UsuariosRepository repository;
	
	public UsuariosController(UsuariosRepository repository) {
		this.repository = repository;  
	}
	
	@GetMapping(path = { "/", "" })
	public String list(Model model) {
		model.addAttribute("usuarios", repository.findAll());
		
		return "usuarios/list";
	}
	
	@GetMapping("/create")
	public String create(Usuario usuario) {
		return "usuarios/create";
	}
	
	@PostMapping("/create")
	public String create(@Valid Usuario usuario, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "usuarios/create";
		}
		repository.save(usuario);
		model.addAttribute("usuarios", repository.findAll());
		return "usuarios/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, Model model) {
		Usuario usuario = repository
				.findById(id)
				.orElseThrow(() -> 
					new IllegalArgumentException("Invalid user Id:" + id)); 
		
		model.addAttribute("usuario", usuario);
		
		return "usuarios/edit";
	}
	
	@PostMapping("/edit/{id}")
	public String updateUser(@PathVariable("id") int id, @Valid Usuario usuario, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        usuario.setId(id);
	        return "usuarios/edit";
	    }
	    
	    repository.save(usuario);
	    model.addAttribute("usuarios", repository.findAll());
	    return "usuarios/list";
	}

}
