/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id_tp.tp_id_22_23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mikae
 */
public class TP_ID_22_23 {

    public static void main(String[] args) throws IOException {
       Scanner dados = new Scanner(System.in) ;
       String nome; 
        
       System.out.println("Insira um nome de autor:");
       nome = dados.nextLine(); 
       
       ArrayList<Obras> obs = new ArrayList<>(); 
       obs.add(WrappersBertrand.criaObras(nome)); 
        
       for(Obras itr: obs){
            itr.printLivro();  //ver a calsse livro
           System.out.println("");
       } 
    }
}



// try {
//            String texto;
//            texto = Ficha2_project.lerFicheiro("alunos.txt");
//            jTextArea1.setText(texto);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
//        }