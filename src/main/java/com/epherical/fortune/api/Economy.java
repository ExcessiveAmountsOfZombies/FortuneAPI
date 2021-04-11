package com.epherical.fortune.api;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.UUID;

public interface Economy {

    /**
     * Checks if the economy implementation is enabled or not.
     * @return True if enabled, false otherwise.
     */
    boolean enabled();

    /**
     * @return The name of the economy implementation.
     */
    String economyName();

    /**
     * @return Will return the amount of decimal places the money will go out to.
     */
    default int decimals() {
        return 2;
    }

    /**
     * @return Money that is formatted for human reading.
     */
    String formatMoney(BigDecimal toBeFormatted);

    /**
     * @return The name of the currency in singular form.
     */
    String currencyNameSingular();

    /**
     * @return The name of the currency in plural form.
     */
    String currencyNamePlural();

    /**
     * @param uuid The UUID to check for.
     * @return Will return true if there is an account associated with the UUID and false if there is not.
     */
    boolean hasAccount(UUID uuid);

    /**
     * @param uuid The UUID to use when creating an account.
     * @return Will return true if an account is successfully created and false if unsuccessful.
     */
    boolean createAccount(UUID uuid);

    /**
     * @param uuid The UUID to check.
     * @param amount the amount that the UUID needs to possess.
     * @return Will return true if the UUID has the amount required, false if they do not, or the account does not exist.
     */
    boolean hasAmount(UUID uuid, BigDecimal amount);

    /**
     *
     * @param uuid The UUID to check.
     * @return If the uuid associated has an account, it will attempt to return the balance, otherwise it may return null.
     */
    @Nullable
    BigDecimal getBalance(UUID uuid);

    /**
     * @param uuid The uuid to check.
     * @param amount the amount to withdraw. The amount should be POSITIVE. Do not use negative numbers.
     * @return A transaction representing whether or not it was successful in withdrawing from the associated UUID.
     */
    Transaction withdraw(UUID uuid, BigDecimal amount);

    /**
     * @param uuid The uuid to check.
     * @param amount the amount to deposit. The amount should be POSITIVE. Do not use negative numbers.
     * @return A transaction representing whether or not it was successful in depositing to the associated UUID.
     */
    Transaction deposit(UUID uuid, BigDecimal amount);

}
