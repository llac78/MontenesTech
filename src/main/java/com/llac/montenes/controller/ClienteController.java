package com.llac.montenes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llac.montenes.model.Cliente;

@Controller
public class ClienteController {

	@GetMapping("/inicio")
	public ModelAndView inicio(){
		return new ModelAndView("inicio", "command", new Cliente());
	}
}
