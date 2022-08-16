package application;

import exceptions.DomainException;
import models.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.println("Numero do quarto: ");
            int numero = sc.nextInt();
            System.out.println("Data do check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Data do check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numero,checkIn,checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite a data para atualizar a reserva: ");
            System.out.println("Data check-in (dd/MM/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data check-out (dd/MM/yyyy)");
            checkOut = sdf.parse(sc.next());

            reserva.atualizarDatas(checkIn,checkOut);

            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e){
            System.out.println("Formato de data inválido");
        }
        catch (DomainException e) {
            throw new RuntimeException(e);
        }

        sc.close();
    }
}