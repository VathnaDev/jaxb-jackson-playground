import model.jaxb.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbExample {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

        Document document = new Document();
        StringWriter writer = new StringWriter();
        System.out.println("\nRAW XML");
        marshaller.marshal(document,writer);

        String xml = writer.toString();
        System.out.println(xml);


        String xmlCDATA = toCDATA(xml);
        System.out.println("\nCDATA");
        System.out.println(xmlCDATA);

        /*ISSUE:
        * Not sure why after I tried to Unmarshaller the xml with xmlns namespce it throw error
        * I believed it conflicts with default namespace
        * But in our project it no need that data when Unmarshaller the xml. So it should be fine
        * */
        xml = xml.replace("xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.05\"","");

        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        document = (Document) unmarshaller.unmarshal(reader);
        System.out.println("\nJAVA OBJECT");
        System.out.println(document.toString());

    }

    public static String toCDATA(String xml) {
        return "<![CDATA[" + xml + "]]>".trim();
    }

}
