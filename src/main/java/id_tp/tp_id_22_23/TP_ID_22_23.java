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
        Scanner dados = new Scanner(System.in);
        String nome, quant;
   
        
        System.out.println("Insira um nome de autor:");
        nome = dados.nextLine();

        System.out.println("Quantas obras voce deseja procurar?:");
        quant = dados.nextLine();
        int number = Integer.parseInt(quant);

        ArrayList<Obras> obs = new ArrayList<>();
        ArrayList<String> linkObras = WrappersBertrand.obtem_link(nome, number);
         
        
        for(int i = 0; i < linkObras.size(); i++){
            obs.add(WrappersBertrand.criaObras(linkObras.get(i)));
        }
        
        for (Obras itr : obs) {
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
