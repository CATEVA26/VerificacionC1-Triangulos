package modelo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el primer lado del triangúlo: \t");
            int ladoA = sc.nextInt();
            System.out.println("Ingrese el segundo lado del triangúlo: \t");
            int ladoB = sc.nextInt();
            System.out.println("Ingrese el tercer lado del triangúlo: \t");
            int ladoC = sc.nextInt();
            Triangulo t1 = new Triangulo(ladoA,ladoB,ladoC);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
