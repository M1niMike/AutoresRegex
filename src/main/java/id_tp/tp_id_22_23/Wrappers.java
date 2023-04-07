/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mikae
 */
public class Wrappers {
    
//    static ArrayList procura_por_cidade(String procura) throws FileNotFoundException{
//        ArrayList lista = new ArrayList();
//        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
//        String er = ""
//        Pattern p = Pattern.compile(er);
//        Matcher m;
//        String linha;
//        while((input.hasNextLine())){
//            linha = input.nextLine();
//            m = p.matcher(linha);
//            if(m.find()){
//                lista.add(m.group(1));
//            }
//        }
//        input.close();
//        return lista;
//    }
    
    public static String obtem_titulo(String isbn) throws IOException{
        String link = "https://www.bertrand.pt/pesquisa/";
        HttpRequestFunctions.httpRequest1(link, isbn, "livros.txt");
        String er ="data-product-name=\"([^\"]+)\"";
        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner read = new Scanner(new FileInputStream("livros.txt"));
        while(read.hasNextLine()){
            String linha = read.nextLine();
            m = p.matcher(linha);
            if(m.find()){
                read.close();
                return m.group(1);
            }
        }
        read.close();
        return null;
    }
    
    public static String obtem_autor(String isbn) throws IOException{
        String link = "https://www.bertrand.pt/pesquisa/";
        HttpRequestFunctions.httpRequest1(link, isbn, "livros.txt");
        String er ="";
        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner read = new Scanner(new FileInputStream("livros.txt"));
        while(read.hasNextLine()){
            String linha = read.nextLine();
            m = p.matcher(linha);
            if(m.find()){
                read.close();
                return m.group(1);
            }
        }
        read.close();
        return null;
    }
//    public static double obtem_preco(String isbn) throws IOException{
//        String link = "https://www.bertrand.pt/pesquisa/";
//        HttpRequestFunction.httpRequest1(link, isbn, "livros.txt");
//        return 0;
//    }
    
//    static String procura_nome_por_id(String procura) throws FileNotFoundException, IOException{
//        
//        
//        String link = "https://eden.dei.uc.pt/~abs/ID/pessoas.html";
//        String pesquisa ="";
//        HttpRequestFunction.httpRequest1(link, pesquisa, "pessoas.html");
//        
//        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
//        String er = "<tr>\\s*<td\\s*>"+procura+"+</td><td\\s*>([a-zA-Z\\s]+)</td>";
//        Pattern p = Pattern.compile(er);
//        Matcher m;
//        String linha;
//        while((input.hasNextLine())){
//            linha = input.nextLine();
//            m = p.matcher(linha);
//            if(m.find()){
//                return(m.group(1));
//            }
//        }
//        input.close();
//        return null;
//    }
}
