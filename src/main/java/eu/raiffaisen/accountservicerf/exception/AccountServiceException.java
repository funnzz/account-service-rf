package eu.raiffaisen.accountservicerf.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccountServiceException extends RuntimeException {

    public AccountServiceException(String exception) {
        super(exception);
    }


}
