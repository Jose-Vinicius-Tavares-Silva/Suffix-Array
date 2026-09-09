/**
 * Estrutura de dados Suffix Array
 * Esta classe fornece métodos estáticos para a criação e ordenação de um vetor 
 * que contém os índices iniciais de todos os sufixos de uma string, ordenados lexicograficamente.
 *
 *@author Jose-Vinicius-Tavares-Silva
 */
public final class SuffixArray{
    /**
     * Construtor privado para não ser instanciado
     */
    private SuffixArray(){
    }

    
    /**
     * Gera o vetor de sufixos, ordenados lexicograficament
     * @param s a String usada para gerar o vetor
     * @return um vetor com as coordenadas iniciais da string ordenadas lexicograficamentes
     */
    public static int[] geraVetor(String s){
        int[] arr = indexs(s);
        quickSort(s, arr, 0, arr.length - 1);
        return arr;   
    }

    /**
     * Algoritmo de ordenação quicksort com modificações para ordenar os indices do array lexicograficament
     * com particionamento lomuto
     * @param s a String de entrada, utilizada como base para ordenar o array
     * @param arr o array a ser ordenado
     * @param ini o indice inicial do particionamento
     * @param fim indice final do particionamento
     */
    private static void quickSort(String s, int[] arr, int ini, int fim){
        if (ini >= fim) return;
        int i = ini;
        int pivot = fim;
        for (int j = ini; j < fim; j ++){
            if (Util.compare(s, arr[j], arr[pivot]) < 0){
                Util.swap(arr, i, j);
                i++;
            }
        }
        Util.swap(arr, i, pivot);
        quickSort(s, arr, ini, i -1);
        quickSort(s, arr, i + 1, fim);
    }

    /**
     * criador do array com os indices das substrings sem ordenar
     * @param s
     * @return
     */
    private static int[] indexs(String s){
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }
}