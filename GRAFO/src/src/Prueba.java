package src;

import java.util.Scanner;

public class Prueba {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese cantidad de vertices: ");
        int n = sc.nextInt();
        MatrizAd matriz = new MatrizAd(n);
        matriz.AgregarAristas(n);
        matriz.imprimir();
        sc.close();
    }
}
