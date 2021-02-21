package com.currency.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "exchange")
public class Exchange {
    @XmlElements(@XmlElement(name = "currency", type = CurrencyEntity.class))
    List<CurrencyEntity> currencies = new ArrayList<>();

    public Exchange() {
    }

    public List<CurrencyEntity> getCurrencies() {
        return currencies;
    }


}
