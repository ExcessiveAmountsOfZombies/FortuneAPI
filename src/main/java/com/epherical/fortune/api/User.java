package com.epherical.fortune.api;

import java.math.BigDecimal;
import java.util.UUID;

public interface User {

    UUID uuid();

    String name();

    double balance();

    BigDecimal hasAmount(BigDecimal amount);

    Transaction payUser(BigDecimal amount);

    Transaction sendMoneyTo(BigDecimal amount, User user);
}
