package aplicacao;

import java.util.Date;
import java.util.List;

import modelo.dao.DaoFabrica;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {
		
		VendedorDao vendedorDao = DaoFabrica.criarVendedorDao();
		
		System.out.println("==== TESTE 1: Vendedor findByID ====");	
		Vendedor vendedor = vendedorDao.findById(3);
		System.out.println(vendedor);
		
		System.out.println("\n==== TESTE 2: Vendedor findByDepartment ====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.findByDepartment(departamento);
		for (Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 3: Vendedor findByAll ====");
		lista = vendedorDao.findAll();
		for (Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TESTE 4: Vendedor Insert ====");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departamento);
		vendedorDao.insert(novoVendedor);
		System.out.println("Inserido! Novo id = " + novoVendedor.getId());
		
		System.out.println("\n==== TESTE 5: Vendedor Update ====");
		vendedor = vendedorDao.findById(4);
		vendedor.setNome("Martha Waine");
		vendedorDao.update(vendedor);
		System.out.println("Update completo");
		
		System.out.println("\n==== TESTE 6: Vendedor Delete ====");
		vendedorDao.deleteById(10);
		System.out.println("Delete completo");


	}

}
