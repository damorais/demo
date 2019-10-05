package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entities.Topico;
import com.example.demo.entities.TopicosRepository;

@Controller
public class TopicosController {
	
	private TopicosRepository repository;

	public TopicosController(TopicosRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("topicos/create")
	public String create(Topico topico) {
		return "topicos/create";
	}
	
	@PostMapping("topicos/create")
	public RedirectView create(Topico topico, BindingResult result) {
		repository.save(topico);
		
		String urlResultado = "/topicos/" + topico.getId();
		
		return new RedirectView(urlResultado);
	}
	
	@GetMapping("topicos/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		Topico topico = repository
				.findById(id)
				.orElseThrow(() -> 
					new IllegalArgumentException("Tópico Inválido:" + id));
		
		model.addAttribute("topico", topico);
		
		return "topicos/show";
	}

}
