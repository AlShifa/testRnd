package com.syne.XSLT;

import java.io.File;
import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class CsvToXml {
    private void converCsvToXml(File xsltFileName, File inputXml) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance(
                    "net.sf.saxon.TransformerFactoryImpl", getClass().getClassLoader());
            StringWriter output = new StringWriter();
            StreamResult result = new StreamResult(output);
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFileName));
            
            StreamSource input = new StreamSource(inputXml);
            transformer.transform(input, result);

            System.out.println(output);

        } catch (Exception e) {
            System.err.println(" <<< Error from convertCsvToXml() >>> " + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CsvToXml csvToXml = new CsvToXml();
        // csvToXml.converCsvToXml();

        File xsltFileName = new File("C://CSV_XML//xslt_files//xslt_files//csvToALMapper2.xsl");
        File xmlsource = new File("C://CSV_XML//xslt_files//xslt_files//csvAlmapper.xml");
        csvToXml.converCsvToXml(xsltFileName, xmlsource);
    }
}

