package eu.raiffaisen.accountservicerf.dto;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.Map;


public class ExchangeRatesDTO implements Serializable {

    private static final long serialVersionUID = 5765003232033187827L;

    private String base;
    private LocalDate date;
    private Map rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map getRates() {
        return rates;
    }

    public void setRates(Map rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRatesDTO{" +
                "base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
