package aplicacao;

import java.util.Date;
import entidades.Pedido;
import entidades.enums.Status;

public class Programa {

	public static void main(String[] args) {
		Pedido pedido = new Pedido(1232, new Date(), Status.AGUARDANDO_PAGAMENTO);
		System.out.println(pedido);
		
		Status ps1 = Status.ENTREGE;
		Status ps2 = Status.valueOf("ENTREGE");
		System.out.println(ps1);
		System.out.println(ps2);
	}
}
