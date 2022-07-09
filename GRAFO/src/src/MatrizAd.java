package src;


import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


import java.util.Scanner;

public class MatrizAd {
    private final int vertices;
    private final int[][] matriz;
    Graph graph = new SingleGraph("Vertices");

    public MatrizAd(int vertices){
        this.vertices = vertices;
        matriz = new int[this.vertices][this.vertices];
        for(int i=0; i<vertices;i++){
            for(int j=0;j<vertices;j++){
                matriz[i][j] =0;
            }
            graph.addNode(String.valueOf(i+1));
            graph.getNode(i).setAttribute("ui.label", "->Vertice "+(i+1)+" ");
            graph.getNode(i).setAttribute("ui.style","text-alignment:right;");
        }
    }
    public void AgregarAristas(int vertices){
        Scanner sc=new Scanner(System.in);
        for(int i=0; i<vertices;i++){
            System.out.println("VECTOR "+(i+1) + "-----------------------------------------------------");
            for(int j=0; j<vertices;j++){
                int Arista = 2;
                while (Arista != 1 && Arista != 0){
                    System.out.println("el vertice "+(i)+" es arista con el vertice "+(j)+"? SI = 1, NO = 0");
                    Arista=sc.nextInt();
                    switch (Arista) {
                        case 1, 0 -> {
                            matriz[i][j] = Arista;
                            if (Arista == 1) {
                                graph.addEdge(String.valueOf(i + 1) + (j + 1), graph.getNode(i), graph.getNode(j), true);
                            }
                        }
                        default -> System.out.println("Respuesta no valida");
                    }
                }
            }
        }
        System.setProperty("org.graphstream.ui", "swing");
        graph.display();
    }
    public void imprimir(){
        System.out.println(" ");
        System.out.println("Matriz de adyacencia");
        for(int i=0;i<vertices;i++){
            for(int j=0;j<vertices;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}