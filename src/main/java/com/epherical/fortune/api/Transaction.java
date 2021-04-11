package com.epherical.fortune.api;

import java.math.BigDecimal;
import java.util.function.Function;

public interface Transaction {

    /**
     * @return Will return the amount the balance changes by for the {@link User}.
     */
    BigDecimal amountChanged();

    /**
     * @return returns the {@link User} involved in the transaction.
     */
    User user();

    /**
     * @return returns whether the state of the transaction.
     */
    Response transactionResponse();

    /**
     * @return returns whether the transaction is adding or subtracting from the {@link User}
     */
    Type transactionType();

    enum Response {
        SUCCESS,
        FAILURE
    }

    enum Type {
        ADD(input -> input),
        SUBTRACT(BigDecimal::negate);

        Function<BigDecimal, BigDecimal> modifier;

        Type(Function<BigDecimal, BigDecimal> modifier) {
            this.modifier = modifier;
        }

        public BigDecimal applyModifier(BigDecimal amount) {
            return this.modifier.apply(amount);
        }
    }

}
