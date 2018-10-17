/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochiladinamica;

/**
 *
 * @author felipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Leitor leitor = new Leitor("mochila01.txt");
        MochilaDinamica mochila = new MochilaDinamica(leitor.getNItens(), leitor.getCapacidade(), leitor.getValores(), leitor.getPesos());
        mochila.run();
    }
    
}
