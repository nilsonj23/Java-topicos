package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.entidades.Reserva;
import modelo.execptions.Exception01;

public class Programa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numero = entrada.nextInt();
			
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(entrada.next()); 
			
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(entrada.next());
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva.toString());
			
			System.out.println();
			System.out.println("Ente com os dados para atualizar a reserva:");
			System.out.print("Data de check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(entrada.next()); 
			
			System.out.print("Data de check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(entrada.next());
			
			reserva.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva.toString());
		}
		catch (ParseException e){
			System.out.println("Data no formato invalido!");
		}
		catch (Exception01 e){
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e){
			System.out.println("Erro inesperado");
		}
		/*
		try {
			System.out.println("Entre com nomes: ");
			String[] vet = entrada.nextLine().split(" ");
			
			System.out.print("Entre com a posicao do vetor: ");
			int pos = entrada.nextInt();
			
			System.out.println(vet[pos]);
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.print("Posição invalida!");
		}
		catch (InputMismatchException e){
			System.out.print("Erro de entrada!");
		}
		*/
		entrada.close();		
	}
}