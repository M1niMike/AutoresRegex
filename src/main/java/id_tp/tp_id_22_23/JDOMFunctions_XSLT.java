/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.jdom2.DocType;
import org.jdom2.Document;
import org.jdom2.transform.XSLTransformException;
import org.jdom2.transform.XSLTransformer;

/**
 *
 * @author mikae
 */
public class JDOMFunctions_XSLT {

    public static Document transformaDocumento(Document XMLdoc, String xmlFile, String xslFile) {

        try {
            DocType d = XMLdoc.getDocType();
            if (d != null) {
                XMLdoc.setDocType(null);
                XMLJDomFunctions.escreverDocumentoParaFicheiro(XMLdoc, xmlFile);
                XMLdoc = XMLJDomFunctions.lerDocumentoXML(xmlFile);
            }
            XSLTransformer transformer = new XSLTransformer(xslFile);

            Document doc2 = transformer.transform(XMLdoc);
            if (doc2 == null) {
                System.out.println("Null");
            }
            return doc2;
        } catch (XSLTransformException ex) {
            Logger.getLogger(JDOMFunctions_XSLT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void transformaDocumento2(String xmlFile, String xslFile, String sOutFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(xmlFile));
            String sLine;
            StringBuilder sBuffer = new StringBuilder();
            while ((sLine = br.readLine()) != null) {
                sBuffer.append(sLine).append("\n");
            }
            String sXML = sBuffer.toString();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(new StringReader(sXML)),
                    new StreamResult(new FileOutputStream(sOutFile)));
        } catch (IOException | TransformerException ex) {
            Logger.getLogger(JDOMFunctions_XSLT.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
