package ru.otus.homework.atm.demo2;

import ru.otus.homework.atm.demo1.SimpleBanknote;

public class NewBanknote extends SimpleBanknote {
    final private int currencyCode;
    final private long number;
    public NewBanknote(int nominal, int currencyCode, long number) {
        super(nominal);
        this.currencyCode = currencyCode;
        this.number = number;
    }
    public int getCurrencyCode() {
        return currencyCode;
    }

    public long getNumber() {
        return number;
    }
}
