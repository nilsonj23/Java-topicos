package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DaoFabrica;
import modelo.dao.DepartamentoDao;
import modelo.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartamentoDao departamentoDao = DaoFabrica.criarDepartamentoDao();

		System.out.println("=== TESTE 1: findById =======");
		Departamento dep = departamentoDao.findById(1);
		System.out.println(dep);

		System.out.println("\n=== TESTE 2: findAll =======");
		List<Departamento> lista = departamentoDao.findAll();
		for (Departamento d : lista) {
			System.out.println(d);
		}

		System.out.println("\n=== TESTE 3: Insert =======");
		Departamento newDepartamento = new Departamento(null, "Music");
		departamentoDao.insert(newDepartamento);
		//DepartamentoDao.insert(newDepartamento);
		System.out.println("Inserted! New id: " + newDepartamento.getId());

		System.out.println("\n=== TESTE 4: Update =======");
		Departamento dep2 = departamentoDao.findById(1);
		dep2.setNome("Food");
		departamentoDao.update(dep2);
		System.out.println("Update completo");

		System.out.println("\n=== TESTE 5: Delete =======");
		System.out.print("Entre com o ID para deletar: ");
		int id = sc.nextInt();
		departamentoDao.deleteById(id);
		System.out.println("Delete completo");

		sc.close();
	}

}
