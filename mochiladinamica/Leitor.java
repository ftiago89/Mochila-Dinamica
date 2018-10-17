/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochiladinamica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Leitor {
    private int nItens, capacidade;
    private int[] valores, pesos;
    private String nomeArquivo;

    public Leitor(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        leArquivo();
    }
    
    private void leArquivo() {
        String linha = null;
        String[] aux = null;
        int i = 0;

        try {
            FileReader r = new FileReader(nomeArquivo);
            BufferedReader buffer = new BufferedReader(r);

            linha = buffer.readLine();
            aux = linha.split(" ");
            
            nItens = Integer.parseInt(aux[0]);
            capacidade = Integer.parseInt(aux[1]);
            valores = new int[nItens];
            pesos = new int[nItens];
            

            while ((linha = buffer.readLine()) != null) {
                aux = linha.split(" ");
                pesos[i] = Integer.parseInt(aux[0]);
                valores[i] = Integer.parseInt(aux[1]);
                ++i;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro na leitura do arquivo.");
        } catch (IOException ex) {
            System.err.println("Erro na leitura da linha do arquivo.");
        }
    }

    public int getNItens(){
        return nItens;
    }
    
    public int[] getValores(){
        return valores;
    }
    
    public int[] getPesos(){
        return pesos;
    }
    
    public int getCapacidade(){
        return capacidade;
    }
}
