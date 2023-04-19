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

    static ArrayList<String> matchIntoArrayList(ArrayList<String> arr, String regex, String fileIn) throws FileNotFoundException {
        try (Scanner reader = new Scanner(new FileInputStream(fileIn))) {
            Pattern p = Pattern.compile(regex);
            
            int count = 0;
            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                Matcher m = p.matcher(line);
                while (m.find()) {
                    arr.add(m.group(1));
                    count++;
                }
            }
            if (count == 0) {
                arr.add("empty");
            }
        }
        return arr;
    }

    static String matchIntoString(String regex, String fileIn) throws FileNotFoundException {
        try (Scanner reader = new Scanner(new FileInputStream(fileIn))) {
            Pattern p = Pattern.compile(regex);

            String line;
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                Matcher m = p.matcher(line);
                if (m.find()) {
                    reader.close();
                    return m.group(1);
                }
            }
        }
        return "nullStr";
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
    
    
    
    
//TESTAR!!!    
//String input = "<tr>\n" +
//               "\t<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Cônjuge</td>\n" +
//               "\t<td style=\"vertical-align: top; text-align: left;\">Micael Eid (1989-2015)</td>\n" +
//               "</tr>";
//               
//Pattern pattern = Pattern.compile("<td[^>]*>[^<]*\\b([A-Z][a-z]+\\s+[A-Z][a-z]+)\\b[^<]*</td>");
//Matcher matcher = pattern.matcher(input);
//
//if (matcher.find()) {
//    String output = matcher.group(1);
//    System.out.println(output);
//}

}
