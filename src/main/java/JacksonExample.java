import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.XmlFormatter;
import model.jackson.Document;


public class JacksonExample {
    public static void main(String[] args) {
        XmlMapper mapper = new XmlMapper();
        XmlFormatter formatter = new XmlFormatter();
        try {
            Document document = new Document();
            String xml = mapper.writeValueAsString(document);
            System.out.println("\nRAW XML");
            System.out.println(formatter.format(xml));

            String xmlCDATA = toCDATA(xml);
            System.out.println("\nCDATA");
            System.out.println(xmlCDATA);


             document = mapper.readValue(xml, Document.class);
            System.out.println("\nJAVA OBJECT");
            System.out.println(document.toString());

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static String toCDATA(String xml) {
        return "<![CDATA[<?xml version=\"1.0\"?>" + xml + "]]>".trim();
    }
}
