/**
* A classe BuscaPalavra fornece logica de processamento e analise de Strings
* ela utiliza a estrutura de dados Suffix array para realizar buscas de repetiçoes em tempo logaritmo
* @author Jose-Vinicius-Tavares-Silva
*/
public class BuscaPalavra {
    private String str;
    private int[] arr;
    
    /**
     * Construtor do metodo
     * @param k a string original a ser analisada
     */
    public BuscaPalavra(String k) {
        this.str = k + "$";
        this.arr = SuffixArray.geraVetor(str);
    }
    /**
     * Gera um array com as posições onde a palavra buscada se repete
     * @param s a string a ser buscada dentro da string original
     * @return uma lista de posições
     */
    public int[] listaRepetidos(String s){
        if (s.length() > str.length()) return null;
        int inicio = achaInicio(s);
        if (inicio == -1) return null;
        int fim = achaFim(inicio, s);
        int[] array = new int[fim + 1 - inicio];
        for (int i = 0; i < array.length; i ++){
            array[i] = arr[inicio ++];
        }
        return array;
    }
    /**
     * Conta a quantidade de vezes que a palavra buscada se repete
     * @param s a string a ser procurada
     * @return a quantidade de vezes que se repete
     */
    public int contaRepetidos (String s){
        if (s.length() > str.length()) return 0;
        int inicio = achaInicio(s);
        if (inicio == -1) return 0;
        int fim = achaFim(inicio, s);
        return (fim - inicio) + 1;
    }
    /**
     * Realiza uma busca binaria para encontar o momento em que se iniciam as repetições a partir de um array de coordenadas ordenadas
     * @param s a string a ser procurada
     * @return o indice do momento em que começa as repetições
     */
    private int achaInicio(String s){
        int inicio = 0;
        int fim = arr.length - 1;
        while (inicio <= fim){
            int meio = (inicio + fim) / 2;
            int comp = Util.compare(str, s, arr[meio]);
            if (comp > 0) fim = meio-1;
            else if (comp < 0) inicio = meio + 1;
            else if (meio != 0) {
                int anterior = Util.compare(str, s, arr[meio - 1]);
                if (anterior != 0) return meio;
                else fim = meio - 1;
            }else return meio;
        }
        return -1;
    }
    /**
     * Realiza uma busca binario para encontar o momento em que se finalizam as repetições a partir de um array de coordenadas ordenadas
     * @param ini o inicio ja é encontrado pelo metodo achaInicio
     * @param s a string procurada
     * @return o memento que as repetições terminam
     */
    private int achaFim(int ini, String s){
        int inicio = ini;
        int fim = arr.length - 1;
        while (inicio <= fim){
            int meio = (inicio + fim) / 2;
            int comp = Util.compare(str, s, arr[meio]);
            if (comp > 0) fim = meio - 1;
            else if (comp < 0) inicio = meio + 1;
            else if (meio < arr.length -1){
                int posterior = Util.compare(str, s, arr[meio + 1]);
                if (posterior != 0) return meio;
                else inicio = meio + 1;
            }else return meio;
        }
        return -1;
    }
}
