package model.jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement()
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document  {
    @JacksonXmlProperty(isAttribute = true)
    private final String xmlns = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.05";

    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private final String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";

    @JacksonXmlProperty(isAttribute = true, localName = "xsi:schemaLocation")
    private final String xsiSchemaLocation = "xsd/pain.001.001.05.xsd";

    private String element = "html";

    @JacksonXmlCData
    private String content = "Hello World This is CDATA";

    @JacksonXmlProperty(localName = "Amount")
    private Amount amount = new Amount("99","KHR");

    public String getXmlns() {
        return xmlns;
    }

    public String getXmlnsXsi() {
        return xmlnsXsi;
    }

    public String getXsiSchemaLocation() {
        return xsiSchemaLocation;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Document{" +
                "xmlns='" + xmlns + '\'' +
                ", xmlnsXsi='" + xmlnsXsi + '\'' +
                ", xsiSchemaLocation='" + xsiSchemaLocation + '\'' +
                ", element='" + element + '\'' +
                ", content='" + content + '\'' +
                ", amount=" + amount +
                '}';
    }
}
