package com.llac.montenes.service;

import java.util.List;

import com.llac.montenes.model.Cliente;

public interface ClienteService {

	public List<Cliente> listarClientes();
	
	public Cliente salvar(Cliente cliente);
	
	
}
