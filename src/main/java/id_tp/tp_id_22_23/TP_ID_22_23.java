/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id_tp.tp_id_22_23;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mikae
 */
public class TP_ID_22_23 {

    public static void main(String[] args) throws IOException {
        //Prototipo de chamada
        String fileIn = "obras.txt";

        System.out.println(fileIn);
        
        
        
        ArrayList<String> codes = new ArrayList<>();
        codes.add("9789897226755");
        
        ArrayList<Obras> livs = new ArrayList<>(); 
//        for(int i = 0; i < codes.size(); ++i){
//            livs.add(Obras.criaLivro(codes.get(i), fileIn)); //ver a calsse livro
//        }
// temos que ver isto 
        
        for(Obras itr: livs){
            itr.printLivro();  //ver a calsse livro
            System.out.println("");
        }
        
        
        
    }
}

