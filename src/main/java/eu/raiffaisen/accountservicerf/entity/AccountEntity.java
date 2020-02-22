package eu.raiffaisen.accountservicerf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Account_Entity")
public class AccountEntity {


    @Id
    @Column(name = "IBAN", nullable = false)
    private String iban;
    @Column(name = "CURENCY", nullable = false)
    private String ccy;
    @Column(name = "BALANCE", nullable = false)
    private Long balance;
    @Column(name = "LAST_UPDATE_DATE", nullable = false)
    private LocalDate lastUpdateDate;


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
