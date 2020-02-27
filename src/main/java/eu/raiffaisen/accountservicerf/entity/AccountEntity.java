package eu.raiffaisen.accountservicerf.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;





@Entity
@Table(name = "Account_Entity")
public class AccountEntity {


    @Id
    @Column(name = "IBAN", nullable = false)
    private String iban;
    @Column(name = "CURENCY", nullable = false)
    private String ccy;
    @Column(name = "BALANCE", nullable = false)
    private Double balance;
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private LocalDate lastUpdateDate;

    public AccountEntity() {
    }

    public AccountEntity(String iban, String ccy, Double balance, LocalDate lastUpdateDate) {
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountEntity)) return false;
        AccountEntity that = (AccountEntity) o;
        return iban.equals(that.iban);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "iban='" + iban + '\'' +
                ", ccy='" + ccy + '\'' +
                ", balance=" + balance +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}

