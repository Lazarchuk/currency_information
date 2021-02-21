package com.currency.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "currency")
@XmlRootElement(name = "currency")
public class CurrencyEntity {

    @Id
    private Integer r030;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "code")
    private String code;

    @Column(name = "exchangedate")
    private String exchangedate;

    public CurrencyEntity() {
    }

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "txt")
    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "cc")
    public void setCode(String code) {
        this.code = code;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }
}
