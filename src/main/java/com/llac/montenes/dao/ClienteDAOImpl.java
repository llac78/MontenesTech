//package com.llac.montenes.dao;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.llac.montenes.model.Cliente;
//
//@Repository
//public class ClienteDAOImpl implements ClienteDAO {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Transactional(readOnly = true)
//	public List<Cliente> listarClientes() {
//		String jpql = "FROM cliente c";
//		TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
//				
//		return query.getResultList();
//	}
//
//	
//
//}
