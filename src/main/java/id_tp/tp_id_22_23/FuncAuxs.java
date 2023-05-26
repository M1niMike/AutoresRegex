/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author mikae
 */
public class FuncAuxs {
    
     static String lerFicheiro(String nomeFicheiro) throws FileNotFoundException{
        String linha;
        StringBuilder texto = new StringBuilder();
        Scanner input = new Scanner(new FileInputStream(nomeFicheiro));
        
        
        while((input.hasNextLine())){
            linha = input.nextLine();
            texto.append(linha).append("\n");
        }
            
        input.close();
        return texto.toString();
    }
    
}
