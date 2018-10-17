/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochiladinamica;

/**
 *
 * @author Felipe
 */
public class MochilaDinamica {
    private int nItens, capacidade;
    private int[] valores, pesos;
    private int[][] memo;

    public MochilaDinamica(int nItens, int capacidade, int[] valores, int[] pesos) {
        this.nItens = nItens;
        this.capacidade = capacidade;
        this.valores = valores;
        this.pesos = pesos;
        this.memo = new int[capacidade+1][nItens];
    }
    
    public void run(){
        init();
        System.out.println(mochilaRecursiva(capacidade, 0));
    }
    
    /*private int mochila(int W, int itens){
        int w = 0;
        int j = 0;
        for (; w <= W+1; ++w){
            for (; j <= itens+1; ++j){
                if ((w == 0) || (j == 0)){
                    memo[w][j] = 0;
                }else{
                    if (w < pesos[j-1]){
                        memo[w][j] = memo[w][j-1];
                    }else{
                        memo[w][j] = Math.max(memo[w - pesos[j-1]][j-1] + valores[j-1], memo[w][j-1]);
                    }
                }
            }
        }
        return memo[w-1][j-1];
    }*/
    
    private int mochilaRecursiva(int w, int i){
        if (i == nItens) return 0;
        
        if (memo[w][i] != 0){
            return memo[w][i];
        }else{
            if (w < pesos[i]){
                memo[w][i] = mochilaRecursiva(w, i+1);
            }else{
                memo[w][i] = Math.max(mochilaRecursiva(w - pesos[i], i+1) + valores[i], mochilaRecursiva(w, i+1));
            }
        }
        return memo[w][i];
    }
    
    private void init(){
        for (int i = 0; i < capacidade; ++i){
            for (int j = 0; j < nItens; ++j){
                memo[i][j] = 0;
            }
        }
    }
}
