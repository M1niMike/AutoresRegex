/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

/**
 *
 * @author BrunoOliveira
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jlope
 */
public class WrappersBertrand {

  
    public static String obtem_link_e_acede_pagina_livro(String fileIn) throws FileNotFoundException, IOException {
        String er = "<a\\s+class=\"title-lnk track\"\\s+href=\"([^\"]+)\">[^<]+</a>";
        String link = "https://www.bertrand.pt" + Wrappers.matchIntoString(er, fileIn);
        HttpRequestFunctions.httpRequest1(link, "", fileIn);
        return link;
    }

    //pagina livro
    public static String obtem_capa(String fileIn) throws FileNotFoundException {
        String er = "data-srcset=\"(https://img.bertrand.pt/images/[^\"]+)\"";
        return Wrappers.matchIntoString(er, fileIn);
    }

    public static String obtem_editora(String fileIn) throws FileNotFoundException {
        String er = "<div\\s+class=\"publisher portlet-product-publisher-[^\"]+\">([^<]+)</div>";
        return Wrappers.matchIntoString(er, fileIn);
    }

    public static int obtem_paginas(String fileIn) throws FileNotFoundException {
        String er = "<span\\s+id=\"productPageSectionDetails-collapseDetalhes-content-nrPages\"\\s+class=\"[^\"]+\">Páginas:\\s+<span\\s+class=\"info\">([^<]+)</span></span>";
        return Integer.parseInt(Wrappers.matchIntoString(er, fileIn));
    }

    public static String obtem_titulo(String fileIn) throws FileNotFoundException {
        String er = "data-product-name=\"([^\"]+)";
        return Wrappers.matchIntoString(er, fileIn);
    }

    ;
    public static String obtem_autor(String fileIn) throws FileNotFoundException {
        String er = "<p>de <a href=[^>]+>([^<]+)</a>&nbsp;</p>";
        return Wrappers.matchIntoString(er, fileIn);
    }

    ;
    
    public static double obtem_preco(String fileIn) throws FileNotFoundException {
        String er
                = "<span\\s+class=.+active-price.+>([^€]+)€</span>";
        return Double.parseDouble(Wrappers.matchIntoString(er, fileIn).replaceAll(",", "."));
    }

    ;
    
    static ArrayList<String> procura_fixo_por_id(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "\\b" + procura + "\\s*-\\s*\\d+\\s*-\\s*(\\d+)\\b";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_tlm_por_id(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "\\b" + procura + "\\s*-\\s*(\\d+)\\s*-\\s*\\d*\\b";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_idade_por_id(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "<\\s*tr\\s*>\\s*"
                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\s*\\w+\\s+\\w+\\s*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\s*([0-9]+)\\s*<\\s*/td\\s*>";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_nome_por_id(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "<\\s*tr\\s*>\\s*"
                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\s*(\\w+\\s+\\w+)\\s*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\s*[0-9]+\\s*<\\s*/td\\s*>";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_profissao_por_id(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "<\\s*tr\\s*>\\s*"
                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\w+\\s+\\w+<\\s*/td\\s*>"
                + "<\\s*td\\s*>[0-9]+<\\s*/td\\s*>"
                + "<\\s*td\\s*>[^<>]*<\\s*/td\\s*>"
                + "<\\s*td\\s*>(\\w+)<\\s*/td\\s*>[^<>]*<\\s*/tr\\s*>";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_por_cidades(String procura, String fileIn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        String er
                = "<\\s*tr\\s*>\\s*"
                + "<\\s*td\\s*>\\d*<\\s*/td\\s*>"
                + "<\\s*td\\s*>\\w+\\s+\\w+<\\s*/td\\s*>"
                + "<\\s*td\\s*>[0-9]+<\\s*/td\\s*>"
                + "<\\s*td\\s*>(\\w*,?\\s*" + procura + ")<\\s*/td\\s*>";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }

    static ArrayList<String> procura_nomes(String procura, String fileIn) throws FileNotFoundException {

        ArrayList<String> arr = new ArrayList<String>();
        String er = "<\\s*tr\\s*>\\s*<\\s*td\\s*>\\d*<\\s*/td\\s*><\\s*td\\s*>(\\w+\\s+" + procura + ")<\\s*/td\\s*>\\s*<\\s*td\\s*>";

        return Wrappers.matchIntoArrayList(arr, er, fileIn);
    }
}