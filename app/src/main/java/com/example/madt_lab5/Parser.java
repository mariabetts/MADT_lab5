package com.example.madt_lab5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Parser {
    public static ArrayList<String> getBaseUSRate(InputStream stream) throws IOException {
        String result = "";
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);


            NodeList rateNodes = doc.getElementsByTagName(FloatRate_Constant.Float_node);
            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element Fnode = (Element) rateNodes.item(i);
                if (Fnode.hasAttribute("currency")) {
                    String currencyName = Fnode.getAttribute("currency");
                    String currencyRate = Fnode.getAttribute("rate");
                    arrayList.add(currencyName + " - " + currencyRate);
                }
            }
        } catch (ParserConfigurationException exempt) {
            exempt.printStackTrace();
        } catch (SAXException exempt) {
            exempt.printStackTrace();
        }
        return arrayList;

    }
}