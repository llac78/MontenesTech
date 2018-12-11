package com.llac.montenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		mv.setViewName("inicio");

		Cliente cliente = new Cliente();
		mv.addObject("cliente_form", cliente);

		List<Cliente> clientes = clienteService.listarClientes();
		if( !clientes.isEmpty() || !(clientes == null) ){
			mv.addObject("listaClientes", clientes);
		}

		return mv;
	}
	
	@PostMapping
	public ModelAndView salvar(@ModelAttribute("cliente_form") Cliente cliente) {
		
		clienteService.salvar(cliente);
		
		return new ModelAndView("redirect:inicio");
	}

	public List<Cliente> listarClientes(){
		
		List<Cliente> clientes = clienteService.listarClientes();

		return clientes;
	}
}
