package com.llac.montenes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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



//	@GetMapping("/inicio")
//    public ModelAndView inicio(ModelMap model) {
//		
//		//criar lista de clientes
//		List<Cliente> clientes = new ArrayList<Cliente>();
//		
//		//criar um cliente
//		Cliente c1 = new Cliente();
//		c1.setNome("Leo");
//		
//		//adicionando cliente à lista
//		clientes.add(c1);
//		
//		//definindo a lista no model para ser exibido na tela 
//		model.addAttribute("listaClientes", clientes);
//		
//        return new ModelAndView("inicio", model);
//    }
	
	@GetMapping("/inicio")
    public ModelAndView inicio() {
		
		ModelAndView mv = new ModelAndView();
		List<?> clientes = clienteService.listarClientes();
		mv.addObject("listaClientes", clientes);
		
        return mv;
    }
}
