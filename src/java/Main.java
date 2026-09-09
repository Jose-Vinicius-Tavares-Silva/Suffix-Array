import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe principal do sistema
 * @author Jose-Vinicius-Tavares-Silva
 */
public class Main{
    /**
     * Interface com usuario
     * @param args (inutilizado)
     */
    public static void main(String[] args){
        String menu = """
                
                Escolha uma opção:
                ========== MENU ==========
                1. Contar repetições
                2. Mostrar coordenadas
                3. Terminar execução
                ==========================""";

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a String analisada");
        int opção = 0;
        String x = sc.nextLine().toLowerCase();
        BuscaPalavra bp = new BuscaPalavra(x);
        while (opção != 3){
            System.out.println(menu);
            if (!sc.hasNextInt()){
                System.out.println("Aceitamos apenas numeros. Tente novamente: ");
                sc.next();
            }
            opção = sc.nextInt();
            sc.nextLine();
            switch (opção){
                case 1 -> {
                    System.out.println("Digite a palavra buscada");
                    String k = sc.nextLine();
                    System.out.println("A palavra se repete: " + bp.contaRepetidos(k) + " vezes.");
                }
                case 2 -> {
                    System.out.println("Digite a palavra buscada");
                    String l = sc.nextLine();
                    System.out.println("A palavra se repete nas posições: " + Arrays.toString(bp.listaRepetidos(l)));
                }
                case 3 -> System.out.println("Execução encerrada");
                default -> System.out.println("Opção inválida! Escolha 1, 2 ou 3. Entendeu?");
            }
        }

    }
}
