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

    public static String obtem_link(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", nome_autor, "obras.txt");
        String er = "<a class=\"track\" href=\"([^\"]+)\">";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return "https://www.bertrand.pt" + m.group(1);
            }

        }
        ler.close();
        return null;
    }

    public static String obtem_titulo(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", nome_autor, "obras.txt");
        String er = "data-product-name=\"([^\"]+)\"";
        Pattern p = Pattern.compile(er);
        Matcher m;
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
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

    public static String obtem_autor(String nome_autor) throws FileNotFoundException, IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", nome_autor, "obras.txt");
        String er = "<a href=\"/autor/[a-zA-Z0-9-/]+\">([^<]+)</a>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;

    }

    public static int obtem_paginas(String nome_autor) throws IOException {
        String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest1(link_sec, "", "obras.txt");
        String er = "<div\\s*class=\"info\">([0-9]+)</div>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return Integer.parseInt(m.group(1));
            }

        }
        ler.close();
        return -1;

    }

    public static double obtem_preco(String nome_autor) throws FileNotFoundException, IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", nome_autor, "obras.txt");
        //String er = "data-price=\"([0-9\\.]+)\"";
        String er = "<span class=\"active-price\">([0-9,]+)€</span>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return Double.parseDouble(m.group(1).replace(",", "."));
            }

        }
        ler.close();
        return -1;

    }

    public static String obtem_capa(String nome_autor) throws IOException {
        String link = obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest1(link, "", "obras.txt");
        String er = "<meta property=\"og:image\" content=\"(https://img.bertrand.pt/images/[^\"]+)\"";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p = Pattern.compile(er);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }

        }
        ler.close();
        return null;

    }

    public static String obtem_editora(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", nome_autor, "obras.txt");
        String er1 = "data-brand=\"([^\"]+)\"";

        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p1 = Pattern.compile(er1);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p1.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }

        ler.close();
        return null;
    }

    public static String obtem_isbn(String nome_autor) throws IOException {
        String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest1(link_sec, "", "obras.txt");
        String er1 = "<div\\s*class=\'info\'>([0-9-]+)</div>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p1 = Pattern.compile(er1);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p1.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }

        ler.close();
        return null;
    }

    public static String obtem_anoEdicao(String nome_autor) throws IOException {
        String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest1(link_sec, "", "obras.txt");
        String er1 = "Ano de edição:\\s*<div\\s*class=\"info\">([^<]+)</div>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p1 = Pattern.compile(er1);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p1.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }

        ler.close();
        return null;
    }
    //<div id=\"productPageSectionDetails-collapseDetalhes-content-language\" class=\"col-xs-12\">\\s*Idioma:\\s*<div class=\"info\">\\s*([a-zA-zê]+)\\s*</div>

    public static String obtem_encadernacao(String nome_autor) throws IOException {
        String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest1(link_sec, "", "obras.txt");
        String er1 = "Encadernação:\\s*<div class=\"info\">([^<]+)</div>";
        Scanner ler = new Scanner(new FileInputStream("obras.txt"));
        Pattern p1 = Pattern.compile(er1);
        String linha;
        while (ler.hasNextLine()) {
            linha = ler.nextLine();
            Matcher m = p1.matcher(linha);
            if (m.find()) {
                ler.close();
                return m.group(1);
            }
        }

        ler.close();
        return null;
    }

    public static Obras criaObras(String nome_autor) throws IOException {
        String titulo = WrappersBertrand.obtem_titulo(nome_autor);
        String isbn = WrappersBertrand.obtem_isbn(nome_autor);
        String editora = WrappersBertrand.obtem_editora(nome_autor);
        Double preco = WrappersBertrand.obtem_preco(nome_autor);
        int quant_paginas = WrappersBertrand.obtem_paginas(nome_autor);
        String idioma = WrappersBertrand.obtem_anoEdicao(nome_autor);
        String encadernacao = WrappersBertrand.obtem_encadernacao(nome_autor);
        String capa = WrappersBertrand.obtem_capa(nome_autor);

        Obras x = new Obras(isbn, nome_autor, titulo, editora, preco, quant_paginas, idioma, encadernacao, capa);
        return x;

    }
}

//    static ArrayList<String> procura_fixo_por_id(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "\\b" + procura + "\\s*-\\s*\\d+\\s*-\\s*(\\d+)\\b";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_tlm_por_id(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "\\b" + procura + "\\s*-\\s*(\\d+)\\s*-\\s*\\d*\\b";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_idade_por_id(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "<\\s*tr\\s*>\\s*"
//                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\s*\\w+\\s+\\w+\\s*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\s*([0-9]+)\\s*<\\s*/td\\s*>";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_nome_por_id(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "<\\s*tr\\s*>\\s*"
//                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\s*(\\w+\\s+\\w+)\\s*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\s*[0-9]+\\s*<\\s*/td\\s*>";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_profissao_por_id(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "<\\s*tr\\s*>\\s*"
//                + "<\\s*td\\s*>\\s*" + procura + "\\s*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\w+\\s+\\w+<\\s*/td\\s*>"
//                + "<\\s*td\\s*>[0-9]+<\\s*/td\\s*>"
//                + "<\\s*td\\s*>[^<>]*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>(\\w+)<\\s*/td\\s*>[^<>]*<\\s*/tr\\s*>";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_por_cidades(String procura, String fileIn) throws FileNotFoundException {
//        ArrayList<String> arr = new ArrayList<>();
//        String er
//                = "<\\s*tr\\s*>\\s*"
//                + "<\\s*td\\s*>\\d*<\\s*/td\\s*>"
//                + "<\\s*td\\s*>\\w+\\s+\\w+<\\s*/td\\s*>"
//                + "<\\s*td\\s*>[0-9]+<\\s*/td\\s*>"
//                + "<\\s*td\\s*>(\\w*,?\\s*" + procura + ")<\\s*/td\\s*>";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
//
//    static ArrayList<String> procura_nomes(String procura, String fileIn) throws FileNotFoundException {
//
//        ArrayList<String> arr = new ArrayList<String>();
//        String er = "<\\s*tr\\s*>\\s*<\\s*td\\s*>\\d*<\\s*/td\\s*><\\s*td\\s*>(\\w+\\s+" + procura + ")<\\s*/td\\s*>\\s*<\\s*td\\s*>";
//
//        return Wrappers.matchIntoArrayList(arr, er, fileIn);
//    }
