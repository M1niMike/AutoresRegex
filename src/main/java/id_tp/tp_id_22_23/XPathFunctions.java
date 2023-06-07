/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

/**
 *
 * @author mikae
 */

import java.io.File;
import java.util.List;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XPathCompiler;
import net.sf.saxon.s9api.XPathSelector;
import net.sf.saxon.s9api.XdmItem;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;


public class XPathFunctions {
    static XdmValue executaXpath(String xp, String xmlFile) throws SaxonApiException {
        XdmValue resultado = null;
        File f = new File(xmlFile);
        if (f.exists()) {
            Processor proc = new Processor(false);
            XPathCompiler xpath = proc.newXPathCompiler();

            DocumentBuilder builder = proc.newDocumentBuilder();

            XdmNode xml = builder.build(new File(xmlFile));
            XPathSelector selector = xpath.compile(xp).load();

            selector.setContextItem(xml);
            resultado = selector.evaluate();
        }
        return resultado;
    }
    
    
    static String listaResultado(XdmValue lista) {
        StringBuilder texto = new StringBuilder();
        System.out.println("RESULTADO DA PESQUISA XPATH:");
        for (XdmItem item : lista) {
            texto = texto.append(item.getStringValue()).append("\n");
        }
        return texto.toString();
    }
    
}
