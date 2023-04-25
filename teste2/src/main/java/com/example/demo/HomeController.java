package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homeApp(Model model) {
		model.addAttribute("mensagem", "mensagem injetada");
		return "index";
	}
}
