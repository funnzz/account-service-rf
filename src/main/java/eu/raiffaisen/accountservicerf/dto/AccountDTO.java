package eu.raiffaisen.accountservicerf.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = -9179825084544697337L;

    private String iban;
    private String ccy;
    private Long balance;
    private LocalDate lastUpdateDate;

    public AccountDTO() {
    }

    public AccountDTO(String iban, String ccy, Long balance, LocalDate lastUpdateDate) {
        this.iban = iban;
        this.ccy = ccy;
        this.balance = balance;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
