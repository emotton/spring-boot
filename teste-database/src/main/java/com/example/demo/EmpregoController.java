package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpregoController {

	@Autowired
	EmpregoRepository empregoRepository;
	
	@RequestMapping("/")
	public String listaEmpregos(Model model) {
		model.addAttribute("empregos", empregoRepository.findAll());
		return "list";
	}
	
	@GetMapping("/add")
	public String empregoForm(Model model) {
		model.addAttribute("emprego", new Emprego());
		return "empregoForm";
	}
	
	@PostMapping("/edit")
	public String editForm(@Validated Emprego emprego, BindingResult result) {
		if(result.hasErrors()) {
			return "empregoForm";
		}
		empregoRepository.save(emprego);
		return "redirect:/";
	}
	
}
