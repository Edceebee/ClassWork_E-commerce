package com.pentazon.payment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayStack implements PaymentService {

    @Override
    public boolean pay(PaymentCard card, BigDecimal amount) {
        boolean result = isValidCard(card);
        return false;
    }

    private boolean isValidCard(PaymentCard card) {
        boolean result = false;
        if (card.getExpiry().isAfter(LocalDate.now())) {
            result = true;
        }
        return result;
    }

}