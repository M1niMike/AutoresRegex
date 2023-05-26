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
public class WrappersWikipedia {

    public static String obtem_nome(String nome_autor) throws IOException {
        //String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er = "<span\\s*class=\"mw-page-title-main\">([^<]+)</span>";
        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("autores.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);

            }

        }
        ler.close();
        return null;
    }

    public static String obtem_dataNasc(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er = "<a\\s*href=\"[^<]+#Nascimentos\"\\s*title=\"[^<]+\">([^<]+)</a>\\s*de\\s*<a\\s*href=\"/wiki/[0-9]+\"\\s*title=\"[0-9]+\">([0-9]+)</a>";

        Pattern p = Pattern.compile(er);
        Matcher m;

        String res = "";

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                res = m.group(1) + " " + m.group(2);
                ler.close();
                return res;

            }

        }
        ler.close();
        return null;
    }
    
    
    
    public static String obtem_dataMorte(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er= "<span style=\"white-space:nowrap;\"><a\\s*href=\"/wiki/[^<]+\"\\s*title=\"[^<]+\">([^<]+)</a>\\s*de\\s*<a\\s*href=\"/wiki/[0-9]+\"\\s*title=\"[0-9]+\">([0-9]+)</a>";

        Pattern p = Pattern.compile(er);
        Matcher m;

        String res = "";

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);

            if (m.find()) {
                res = m.group(1) + " " + m.group(2);
                ler.close();
                return res;

            }

        }
        ler.close();
        return "O Autor ainda esta vivo";
    }
    
    
    public static String obtem_nacionalidade(String nome_autor) throws IOException {
        //String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er = "Nacionalidade\\s*</td>\\s*<td\\s*style=\"[^<]+\"><a\\s*href=\"/wiki/[^<]+\"\\s*title=\"[^<]+\">([^<]+)</a>";
        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("autores.txt"));
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);

            }

        }
        ler.close();
        return null;
    }

}
