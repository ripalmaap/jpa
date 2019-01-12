package com.venta.test;

import javax.persistence.*;

import org.junit.*;
import com.venta.dto.Categoria;
import com.venta.dto.Cliente;
import com.venta.dto.Factura;
import com.venta.dto.Producto;

public class AddTest {
	EntityManagerFactory emf;
	EntityManager em;

	@Before
	public void iniciar() {

		emf = Persistence.createEntityManagerFactory("venta");
		em = emf.createEntityManager();

	}

	@Test
	public void addcategoria() {
		em.getTransaction().begin();
		Categoria ncat = new Categoria(1, "Bebidas espirituosas");
		Categoria ncat1 = new Categoria(2, "Bebidas normales");

		em.persist(ncat);
		em.persist(ncat1);
		em.getTransaction().commit();

		Categoria c = em.find(Categoria.class, 1);
		Categoria c2 = em.find(Categoria.class, 2);
		
		em.getTransaction().begin();
		Producto p = new Producto("Cerveza Cuzqueña", 200, c);
		Producto p1 = new Producto("Cerveza Pilsen", 250, c2);

		em.persist(p);
		em.persist(p1);
		em.getTransaction().commit();

		em.getTransaction().begin();
		Cliente cli= new Cliente("Carlos", "Del Rio", "Jr. San Cristobal 275", "12345678");
		Cliente cli2= new Cliente("Milagros", "Montalvo", "Av. Confraternidad s/n", "87654321");
		
		em.persist(cli);
		em.persist(cli2);
		em.getTransaction().commit();
		
		Cliente cl = em.find(Cliente.class, 1);
		Cliente cl2 = em.find(Cliente.class, 2);
		
		em.getTransaction().begin();
		Factura f = new Factura(001, "02-ENE-2019", cl);
		Factura f1 = new Factura(002,"04-ENE-2019", cl2);

		em.persist(f);
		em.persist(f1);
		em.getTransaction().commit();
		
				
		
	}

}
