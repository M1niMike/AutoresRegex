/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import java.util.Random;

/**
 *
 * @author mikae
 */
public class ModeloXML {
    
    public static int idGenerator(){
        Random rand = new Random();
        int upperbound = 30;
        
        int int_random = rand.nextInt(upperbound);
        
        return int_random;
        
    }
    
     public static Document adicionaLivro(Autor au, Document doc) {
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
        
        x = new Element("conjuge").addContent(au.getConjuge());
        pai.addContent(x);
        
        x = new Element("linkFoto").addContent(au.getFotografia());
        pai.addContent(x);
        
//        x = new Element("premios").addContent(au.getFotografia());
//        pai.addContent(x);
//        
//        x = new Element("ocupacoes").addContent(au.getFotografia());
//        pai.addContent(x);
       
        raiz.addContent(pai);
        return doc;
    }
}
