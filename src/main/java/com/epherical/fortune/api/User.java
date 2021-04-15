package com.epherical.fortune.api;

import java.math.BigDecimal;
import java.util.UUID;

public interface User {

    /**
     * @return Return the UUID of the user.
     */
    UUID uuid();

    /**
     * @return Return the name of the user.
     */
    String name();

    /**
     * @return Return the current balance of the user.
     */
    BigDecimal balance();

    /**
     * @param amount The amount to check against.
     * @return Return true if amount is greater than or equal to the amount specified, false otherwise.
     */
    boolean hasAmount(BigDecimal amount);

    /**
     * @param amount The amount to deposit to the user.
     * @return Return the {@link Transaction} associated with the deposit.
     */
    Transaction deposit(BigDecimal amount);

    /**
     * @param amount The amount to withdraw from the user.
     * @return Return the {@link Transaction} associated with the withdrawal.
     */
    Transaction withdraw(BigDecimal amount);

    /**
     * @param amount The amount of money we want to send.
     * @param user the {@link User} we want to send the money to.
     * @return Return the {@link Transaction} associated with the money being sent.
     */
    Transaction sendMoneyTo(BigDecimal amount, User user);

    /**
     * The type of account this user is associated with. Implementations can define their own limitations if they want to
     * discriminate against player vs non player accounts
     * @return The type of account associated with the user.
     */
    Type userType();

    interface Type {
        Type PLAYER = () -> "PLAYER";
        Type NPC = () -> "NPC";
        
        String accountType();
    }
}
