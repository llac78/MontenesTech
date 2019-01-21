package com.llac.montenes.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.llac.montenes.model.Cliente;
import com.llac.montenes.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteServiceImpl() {
	}

	@Autowired
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		super();
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> listarClientes() {

		List<Cliente> lista = new ArrayList<Cliente>();
		clienteRepository.findAll().forEach(e -> lista.add(e));
		
		return lista;
	}
	
	@Override
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}
