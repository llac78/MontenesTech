package com.llac.montenes.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.llac.montenes.model.Cliente;
import com.llac.montenes.service.ClienteService;

@Controller
public class ClienteController {

	private ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/inicio")
	public ModelAndView inicio() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("inicio");

		Cliente cliente = new Cliente();
		mv.addObject("cliente_form", cliente);

		List<Cliente> clientes = this.listarClientes();
		if (!clientes.isEmpty() || !(clientes == null)) {
			mv.addObject("listaClientes", clientes);
		}

		return mv;
	}

	 @PostMapping()
	 public ModelAndView salvar(@Valid @ModelAttribute("cliente_form") Cliente
	 cliente, BindingResult result) {
	
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("inicio");
		 
		 if (result.hasErrors()) {
			 List<Cliente> clientes = this.listarClientes();
			 if (!clientes.isEmpty() || !(clientes == null)) {
				 mv.addObject("listaClientes", clientes);
			 }
		
			 return mv;
		
		 } else {
			 clienteService.salvar(cliente);
			 List<Cliente> clientes = this.listarClientes();
			 mv.addObject("listaClientes", clientes);
			 
			 return mv;
		 }
	
	 }

	public List<Cliente> listarClientes() {

		List<Cliente> clientes = clienteService.listarClientes();
		
		Collections.reverse(clientes);
		
		return clientes;
	}

}
