/**
 * Classe utilitaria contendo funções auxiliares
 * 
 * @author Jose-Vinicius-Tavares-Silva
 */
public final class Util {
    /**
     * Construtor privado do metodo
     */
    private Util(){

    }

    /**
     * Compara lexicograficamente 2 sufixos a partir de uma string
     * @param s a string original
     * @param i o inicio da primeira substring 
     * @param j o inicio da segunda substring
     * @return inteiro com valores (-1, 0, 1) respectivamente (menor, igual, maior)
     */
    public static int compare(String s, int i, int j){
        while (i < s.length() && j < s.length()){
            if (s.charAt(i) != s.charAt(j)) {
                if (s.charAt(i) > s.charAt(j)) return 1;
                if (s.charAt(i) < s.charAt(j)) return -1;
            }
            i ++;
            j ++;
        }
        
        if (i == s.length() && j == s.length())return 0;
        if (j == s.length()) return 1;
        return -1;
    }

    /**
     * Compara um sufixo de uma string com outra string
     * @param str a string original geradora da substring
     * @param s a segunda string a ser comparada com a original
     * @param i o inicio da substring
     * @return inteiro com valores (-1, 0, 1) respectivamente (menor, igual, maior)
     */
    public static int compare(String str, String s, int i){
        int j = 0;
        while (i < str.length() && j < s.length()){
            if (str.charAt(i) != s.charAt(j)) {
                if (str.charAt(i) > s.charAt(j)) return 1;
                if (str.charAt(i) < s.charAt(j)) return -1;
            }
            i ++;
            j ++;
        }
        if (j >= s.length()) return 0;
        return 1;
    }

    /**
     * troca os valores de um array
     * @param ind o array
     * @param a o primeiro indice
     * @param b o segundo indice
     */
    public static void swap(int[] ind, int a, int b){
        int aux = ind[a];
        ind[a] = ind[b];
        ind[b] = aux;
    }
}
