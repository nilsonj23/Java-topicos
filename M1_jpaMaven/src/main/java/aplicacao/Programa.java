package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		/* CREATE TABLE Pessoa
		Pessoa p1 = new Pessoa(null, "Carlos Da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		*/
		
		// Conectar com o banco de dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/* INSERT
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		// SELECT
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		// DELETE
		Pessoa p2 = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		//em.remove(p2);
		em.getTransaction().commit();
		
		System.out.println("Feito!");
		em.close();
		emf.close();
	}
}
