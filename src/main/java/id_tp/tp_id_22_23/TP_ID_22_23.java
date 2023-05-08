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
        //Prototipo de chamada
        
        ///
        String fileIn = "escritores.txt";
         ArrayList<String> nome_autor = new ArrayList<>();
        
        lerFicheiro(fileIn, nome_autor);
        
       for (String nome : nome_autor) {
            System.out.println(nome);
        }
       
       //WrappersBertrand.criaObras("Nicholas Sparks");
       
        
       ArrayList<Obras> obs = new ArrayList<>(); 
       obs.add(WrappersBertrand.criaObras("Nicholas+Sparks")); 
        
       for(Obras itr: obs){
            itr.printLivro();  //ver a calsse livro
           System.out.println("");
       } 
    }
    
    static void lerFicheiro(String nomeFicheiro, ArrayList<String> nomes_autor) throws FileNotFoundException {
        Scanner input = new Scanner(new FileInputStream(nomeFicheiro));

        while (input.hasNextLine()) {
            String linha = input.nextLine();
            nomes_autor.add(linha);
        }

        input.close();
    }
}



// try {
//            String texto;
//            texto = Ficha2_project.lerFicheiro("alunos.txt");
//            jTextArea1.setText(texto);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
//        }