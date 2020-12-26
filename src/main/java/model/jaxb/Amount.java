package model.jaxb;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Amount {

    @XmlValue()
    private String amount;

    @XmlAttribute()
    private String currency;

    public Amount() {
    }

    public Amount(String amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount='" + amount + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
