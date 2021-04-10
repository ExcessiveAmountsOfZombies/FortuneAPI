package com.epherical.fortune.api;

import java.math.BigDecimal;
import java.util.function.Function;

public interface Transaction {

    BigDecimal amountChanged();

    User user();

    Response transactionResponse();

    Type transactionType();

    enum Response {
        SUCCESS,
        FAILURE,
        NOT_IMPLEMENTED
    }

    enum Type {
        ADD(input -> input),
        SUBTRACT(BigDecimal::negate);

        Function<BigDecimal, BigDecimal> modifier;

        Type(Function<BigDecimal, BigDecimal> modifier) {
            this.modifier = modifier;
        }
    }

}
