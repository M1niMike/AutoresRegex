/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id_tp.tp_id_22_23;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import net.sf.saxon.Configuration;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.trans.XPathException;

/**
 *
 * @author mikae
 */
public class SaxonFunctions_XQuery {

    public static void xQueryToText(String outputFile, String queryFile) throws XPathException, IOException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);

        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, "text");
        exp.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }

    public static void xQueryToHtml(String outputFile, String queryFile) throws XPathException, IOException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);

        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, "html");
        exp.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }

    public static void xQueryToXml(String outputFile, String queryFile) throws XPathException, IOException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);

        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, "xml");
        exp.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }

    public static void xQueryToHtmlInput(String outputFile, String queryFile, String nomeAutor) throws XPathException, IOException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);

        dynamicContext.setParameter("author", nomeAutor);

        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, "html");
        exp.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }

    public static void xQueryToXmlInput(String outputFile, String queryFile, String nomeAutor) throws XPathException, IOException {
        Configuration config = new Configuration();
        StaticQueryContext sqc = new StaticQueryContext(config);
        XQueryExpression exp = sqc.compileQuery(new FileReader(queryFile));
        DynamicQueryContext dynamicContext = new DynamicQueryContext(config);

        dynamicContext.setParameter("author", nomeAutor);
        
        Properties props = new Properties();
        props.setProperty(OutputKeys.METHOD, "xml");
        exp.run(dynamicContext, new StreamResult(new File(outputFile)), props);
    }
}
