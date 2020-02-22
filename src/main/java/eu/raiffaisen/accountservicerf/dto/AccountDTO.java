package eu.raiffaisen.accountservicerf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = -9179825084544697337L;

    private String iban;
    private String ccy;
    private Long balance;
    private LocalDate lastUpdateDate;

}
