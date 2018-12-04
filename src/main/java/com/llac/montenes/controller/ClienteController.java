package com.llac.montenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llac.montenes.model.Cliente;
import com.llac.montenes.service.ClienteService;

@Controller
public class ClienteController {
	
	private ClienteService clienteService;
	
	public ClienteController() {
	}

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/inicio")
    public ModelAndView inicio() {
		
		ModelAndView mv = new ModelAndView();
		List<Cliente> clientes = clienteService.listarClientes();
		mv.addObject("listaClientes", clientes);
		mv.setViewName("inicio");
		
        return mv;
    }
}
