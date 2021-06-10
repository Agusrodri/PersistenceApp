package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Cliente;
import entidades.Domicilio;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em= emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			
			//Cliente cliente = new Cliente("Agustin", "Rodriguez", 42307059);
			//Domicilio domicilio= new Domicilio("Mitre", 2783);
			
			//cliente.setDomicilio(domicilio);
			//domicilio.setCliente(cliente);
			
			//em.persist(cliente);
			
			Domicilio dom = em.find(Domicilio.class, 1L);
			Cliente client = em.find(Cliente.class, 1L);
			
			System.out.println("Cliente de domicilio ---> DNI: " + dom.getCliente().getDni());
			System.out.println("Domicilio de cliente ---> Nombre Calle: " + client.getDomicilio().getNombreCalle());
			
			em.flush();
			
			em.getTransaction().commit();
			
		}catch(Exception e) {
			
			em.getTransaction().rollback();
		}
		
		em.close();
		emf.close();
		
	}

}
