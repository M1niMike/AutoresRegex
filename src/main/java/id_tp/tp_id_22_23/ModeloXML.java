/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import java.util.Random;

/**
 *
 * @author mikae
 */
public class ModeloXML {

    public static int idGenerator() {
        Random rand = new Random();
        int upperbound = 30;

        int int_random = rand.nextInt(upperbound);

        return int_random;

    }

    public static Document adicionaAutor(Autor au, Document doc) throws IOException {
        Element raiz;
        if (doc == null) {
            raiz = new Element("autores"); //cria <catalogo>...</catalogo>
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }

        Element pai = new Element("autor");
        Attribute a = new Attribute("id", Integer.toString(idGenerator()));
        pai.setAttribute(a);

        Element x = new Element("nome").addContent(au.getNome());
        pai.addContent(x);

        x = new Element("dataNascimento").addContent(au.getData_nasc());
        pai.addContent(x);

        x = new Element("dataMorte").addContent(au.getData_morte());
        pai.addContent(x);

        x = new Element("nacionalidade").addContent(au.getNacionalidade());
        pai.addContent(x);

        x = new Element("generoLiterario").addContent(au.getGenero_literario());
        pai.addContent(x);

        x = new Element("ocupacoes");
        pai.addContent(x);

        ArrayList listaOcupacoes = WrappersWikipedia.obtem_ocupacao(au.getNome());
        for (int i = 0; i < listaOcupacoes.size(); i++) {
            String ocupa = (String) listaOcupacoes.get(i);
            Element x2 = new Element("ocupacao").addContent(ocupa);
            x.addContent(x2);
        }

        x = new Element("premios");
        pai.addContent(x);

        ArrayList listaPremios = WrappersWikipedia.obtem_premios(au.getNome());
        for (int i = 0; i < listaPremios.size(); i++) {
            String premios = (String) listaPremios.get(i);
            Element x2 = new Element("premio").addContent(premios);
            x.addContent(x2);
        }

        x = new Element("conjuge").addContent(au.getConjuge());
        pai.addContent(x);

        x = new Element("linkFoto").addContent(au.getFotografia());
        pai.addContent(x);

        raiz.addContent(pai);
        return doc;

    }

    public static Document removeAutorNome(String nomeAutor, Document doc) {
        Element raiz;
        if (doc == null) {
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosAutores = raiz.getChildren("autor");
        boolean found = false;
        for (int i = 0; i < todosAutores.size(); i++) {
            Element autor = (Element) todosAutores.get(i);
            if (autor.getChild("nome").getText().contains(nomeAutor)) {
                autor.getParent().removeContent(autor);
                found = true;
            }
        }
        if (!found) {
            return null;
        }
        return doc;
    }

    public static Document alterarDataNasc(String nomeAutor, String novaDataNasc, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;
        for (int i = 0; i < todosAutores.size(); i++) {
            Element autor = (Element) todosAutores.get(i);
            if (autor.getChild("nome").getText().contains(nomeAutor)) {
                String dataNasc = autor.getChild("dataNascimento").getText();
                System.out.println("Nome: " + nomeAutor);
                System.out.println("Data Nascimento: " + dataNasc);
                autor.getChild("dataNascimento").setText(novaDataNasc);
                System.out.println("DataNascimento alterada com sucesso");

                found = true;
            }
        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document alterarNacionalidade(String nomeAutor, String novaNacionalidade, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;
        for (int i = 0; i < todosAutores.size(); i++) {
            Element autor = (Element) todosAutores.get(i);
            if (autor.getChild("nome").getText().contains(nomeAutor)) {
                String nacionalidade = autor.getChild("nacionalidade").getText();
                System.out.println("Nome: " + nomeAutor);
                System.out.println("nacionalidade: " + nacionalidade);
                autor.getChild("nacionalidade").setText(novaNacionalidade);
                System.out.println("nacionalidade alterada com sucesso");

                found = true;
            }
        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document alterarConjuge(String nomeAutor, String newConjuge, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;
        for (int i = 0; i < todosAutores.size(); i++) {
            Element autor = (Element) todosAutores.get(i);
            if (autor.getChild("nome").getText().contains(nomeAutor)) {
                String conjuge = autor.getChild("conjuge").getText();
                System.out.println("Nome: " + nomeAutor);
                System.out.println("conjuge: " + conjuge);
                autor.getChild("conjuge").setText(newConjuge);
                System.out.println("conjuge alterado com sucesso");

                found = true;
            }
        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document alterarGeneroLit(String nomeAutor, String newGeneroLit, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;
        for (int i = 0; i < todosAutores.size(); i++) {
            Element autor = (Element) todosAutores.get(i);
            if (autor.getChild("nome").getText().contains(nomeAutor)) {
                String generoLiterario = autor.getChild("generoLiterario").getText();
                System.out.println("Nome: " + nomeAutor);
                System.out.println("generoLiterario: " + generoLiterario);
                autor.getChild("generoLiterario").setText(newGeneroLit);
                System.out.println("Genero Literario alterado com sucesso");

                found = true;
            }
        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document removePremio(String nomeAutor, String premio, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;

        for (int i = 0; i < todosAutores.size(); i++) {

            Element autor = (Element) todosAutores.get(i);
            Element premios = autor.getChild("premios");

            if (autor.getChild("nome").getText().contains(nomeAutor)) {

                if (premios.getChild("premio").getText().contains(premio)) {
                    premios.getParent().removeContent(premios);
                    found = true;
                }

            }
        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document adicionaPremio(String nomeAutor, String novoPremio, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe");
            return null;

        } else {
            raiz = doc.getRootElement();
        }

        List todosAutores = raiz.getChildren("autor");
        boolean found = false;

        for (int i = 0; i < todosAutores.size(); i++) {

            Element autor = (Element) todosAutores.get(i);
            Element premios = autor.getChild("premios");

            if (premios == null) {
                Element newPremios = new Element("premios");
                autor.addContent(newPremios);

                if (autor.getChild("nome").getText().contains(nomeAutor)) {
                    Element x = new Element("premio").addContent(novoPremio);

                    newPremios.addContent(x);
                    found = true;
                }
            } else {

                if (autor.getChild("nome").getText().contains(nomeAutor)) {
                    Element x = new Element("premio").addContent(novoPremio);

                    premios.addContent(x);
                    found = true;
                }

            }

        }
        if (!found) {
            System.out.println("O Autor " + nomeAutor + " não foi encontrado");
            return null;
        }

        return doc;

    }

    public static Document adicionaObra(ArrayList<Obras> o, Document doc) {

        for (int i = 0; i < o.size(); i++) {

            Element raiz;
            if (doc == null) {
                raiz = new Element("obras");
                doc = new Document(raiz);
            } else {
                raiz = doc.getRootElement();
            }
            Element pai = new Element("livro");

            Element x = new Element("isbn").addContent(o.get(i).getIsbn());
            pai.addContent(x);

            x = new Element("titulo").addContent(o.get(i).getTitulo());
            pai.addContent(x);

            x = new Element("autor").addContent(o.get(i).getNome_autor());
            pai.addContent(x);

            x = new Element("editora").addContent(o.get(i).getEditora());
            pai.addContent(x);

            x = new Element("preco").addContent(Double.toString(o.get(i).getPreco()));
            pai.addContent(x);

            x = new Element("quantidadePaginas").addContent(Integer.toString(o.get(i).getQuant_paginas()));
            pai.addContent(x);

            x = new Element("anoEdicao").addContent(o.get(i).getAno_edicao());
            pai.addContent(x);

            x = new Element("idioma").addContent(o.get(i).getIdioma());
            pai.addContent(x);

            x = new Element("encadernacao").addContent(o.get(i).getEncadernacao());
            pai.addContent(x);

            x = new Element("fotoCapa").addContent(o.get(i).getFoto_capa());
            pai.addContent(x);

            raiz.addContent(pai);
        }

        return doc;
    }
    
    
    public static Document removeLivroTitulo(String tituloObra, Document doc) {
        Element raiz;
        if (doc == null) {
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todosLivros = raiz.getChildren("livro");
        boolean found = false;
        for (int i = 0; i < todosLivros.size(); i++) {
            Element livro = (Element) todosLivros.get(i);
            if (livro.getChild("titulo").getText().contains(tituloObra)) {
                livro.getParent().removeContent(livro);
                found = true;
            }
        }
        if (!found) {
            return null;
        }
        return doc;
    }

}
