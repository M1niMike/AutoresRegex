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
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er1 = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Nome completo";
        String er2 = "<td style=\"vertical-align: top; text-align: left;\">([^<]+)";
        String er3 = "<span class=\"\">([^<]+)</span>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);

        Matcher m1;
        Matcher m2;
        Matcher m3;

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);
            m3 = p3.matcher(linha);

            if (m1.find()) {
                while (ler.hasNextLine()) {
                    linha = ler.nextLine();

                    m2 = p2.matcher(linha);

                    if (m2.find()) {

                        ler.close();
                        return m2.group(1);
                    }

                }

            } else if (m3.find()) {
                ler.close();
                return m3.group(1);
            }
        }
        ler.close();
        return "Sem informacao";
    }

    public static String obtem_dataNasc(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er1 = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Nascimento";
        String er2 = "<a\\s*href=\"/wiki/[^<]+#Nascimentos\"\\s*title=\"[^<]+\">([^<]+)</a>\\s*de\\s*<a\\s*href=\"/wiki/[0-9]+\"\\s*title=\"[0-9]+\">([0-9]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1;
        Matcher m2;

        String res = "";

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);

            if (m1.find()) {
                while (ler.hasNextLine()) {
                    linha = ler.nextLine();

                    m2 = p2.matcher(linha);

                    if (m2.find()) {
                        res = m2.group(1) + " " + m2.group(2);
                        ler.close();
                        return res;
                    }

                }

            }
        }
        ler.close();
        return "Sem informacao";
    }

    public static String obtem_dataMorte(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");
        String er1 = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Morte";
        String er2 = "<span style=\"white-space:nowrap;\"><a\\s*href=\"/wiki/[^<]+\"\\s*title=\"[^<]+\">([^<]+)</a>\\s*de\\s*<a\\s*href=\"/wiki/[0-9]+\"\\s*title=\"[0-9]+\">([0-9]+)</a>";
        String er3 = "<a href=\"/wiki/[^<]+\" title=\"[^<]+o\">([^<]+)</a>\\s*de\\s*<a href=\"/wiki/[0-9]+\" title=\"[0-9]+\">([0-9]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);

        Matcher m1;
        Matcher m2;
        Matcher m3;

        String res = "";

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);

            if (m1.find()) {
                while (ler.hasNextLine()) {
                    linha = ler.nextLine();

                    m2 = p2.matcher(linha);
                    m3 = p3.matcher(linha);
                    if (m2.find()) {
                        res = m2.group(1) + " " + m2.group(2);
                        ler.close();
                        return res;
                    } else if (m3.find()) {
                        res = m3.group(1) + " " + m3.group(2);
                        ler.close();
                        return res;
                    }

                }

            }
        }
        ler.close();
        return "O Autor ainda esta vivo";
    }

    public static String obtem_nacionalidade(String nome_autor) throws IOException {
        //String link_sec = WrappersBertrand.obtem_link(nome_autor);
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er1 = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Nacionalidade";
        String er2 = "<td\\s*style=\"[^<]+\"><a\\s*href=\"/wiki/[^<]+\"\\s*title=\"[^<]+\">([^<]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1;
        Matcher m2;

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);
            m2 = p2.matcher(linha);

            if (m1.find()) {
                while (ler.hasNextLine()) {
                    linha = ler.nextLine();

                    m2 = p2.matcher(linha);

                    if (m2.find()) {

                        ler.close();
                        return m2.group(1);
                    }

                }

            }
        }
        ler.close();
        return "Sem informacao";
    }

    public static String obtem_generoLiterario(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er1 = "Gênero literário";
        String er2 = "<a href=\"/wiki/[^<]+\" title=\"[^<]+\">([^<]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1;
        Matcher m2;

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        //String res = "";
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);
            // m2 = p2.matcher(linha);

            if (m1.find()) {
                ler.nextLine();
                linha = ler.nextLine();

                m2 = p2.matcher(linha);

                if (m2.find()) {
                    //res = m2.group(1) + " " + m2.group(2) + " " + m2.group(3);
                    ler.close();
                    return m2.group(1);
                }

            }

        }

        ler.close();
        return "Sem informacao";
    }

    public static String obtem_conjuge(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er1 = "<td scope=\"row\" style=\"vertical-align: top; text-align: left; font-weight:bold;\">Cônjuge";
        String er2 = "<a href=\"/wiki/[^<]+\" title=\"[^<]+\">([^<]+)</a>";
        String er3 = "<td style=\"vertical-align: top; text-align: left;\">([^<]+)";
        String er4 = "<td style=\"vertical-align: top; text-align: left;\">[^<]+ <span style=\"font-size:[0-9]+%;\">[0-9()]+</span><br />([^<]+) <span style=\"font-size:[0-9]+%;\">([a-zA-Z0-9()]+)</span>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);
        Pattern p4 = Pattern.compile(er4);

        Matcher m1;
        Matcher m2;
        Matcher m3;
        Matcher m4;

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);

            if (m1.find()) {
                while (ler.hasNextLine()) {
                    linha = ler.nextLine();

                    m2 = p2.matcher(linha);
                    m3 = p3.matcher(linha);
                    m4 = p4.matcher(linha);

                    if (m2.find()) {

                        ler.close();
                        return m2.group(1);
                    } else if (m3.find()) {
                        ler.close();
                        return m3.group(1);
                    } else if (m4.find()) {
                        ler.close();
                        return m4.group(1);
                    }

                }

            }
        }
        ler.close();
        return "Sem informacao";
    }

    public static String obtem_linkFoto(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er2 = "<meta property=\"og:image\" content=\"([^<]+.png)\">";
        String er3 = "<meta property=\"og:image\" content=\"([^<]+.jpg)\">";

        Pattern p2 = Pattern.compile(er2);
        Pattern p3 = Pattern.compile(er3);

        Matcher m2;
        Matcher m3;

        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m2 = p2.matcher(linha);
            m3 = p3.matcher(linha);
            if (m2.find()) {
                ler.close();
                return m2.group(1);

            } else if (m3.find()) {
                ler.close();
                return m3.group(1);
            }
        }
        ler.close();
        return "Sem informacao";
    }

    public static ArrayList obtem_ocupacao(String nome_autor) throws IOException {
        HttpRequestFunctions.httpRequest2("https://pt.wikipedia.org/wiki/", nome_autor, "autores.txt");

        String er1 = "Ocupação";
        String er2 = "<td style=\"vertical-align: top; text-align: left;\"><a href=\"/wiki/[^<]+\" title=\"[^<]+\">([^<]+)</a>";

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Matcher m1;
        Matcher m2;

        int i = 0;
        ArrayList lista = new ArrayList();
        Scanner ler = new Scanner(new FileInputStream("autores.txt"));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();

            m1 = p1.matcher(linha);

            if (m1.find()) {
                ler.nextLine(); {
                    String linha2 = ler.nextLine();

                    m2 = p2.matcher(linha2);
                    
                    if (m2.find() && i < 3) {
                     
                        lista.add(m2.group(1));
                        i++;

                    }
                    
                }
            }

        }
        ler.close();
        return lista;
    }


    public static Autor criaAutor(String nome_autor) throws IOException {

        String nome = nome_autor;
        String data_Nasc = WrappersWikipedia.obtem_dataNasc(nome_autor);
        String dataMorte = WrappersWikipedia.obtem_dataMorte(nome_autor);
        String nacionalidade = WrappersWikipedia.obtem_nacionalidade(nome_autor);
        String generoLit = WrappersWikipedia.obtem_generoLiterario(nome_autor);
        ArrayList ocupacoes = WrappersWikipedia.obtem_ocupacao(nome_autor);
        // String premios = WrappersBertrand.obtem_anoEdicao(linkObras);
        String conjuge = WrappersWikipedia.obtem_conjuge(nome_autor);
        String link_foto = WrappersWikipedia.obtem_linkFoto(nome_autor);

        Autor a = new Autor(nome, data_Nasc, dataMorte, nacionalidade, generoLit, ocupacoes, conjuge, link_foto);
        return a;
    }

}
