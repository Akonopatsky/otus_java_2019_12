package ru.otus.homework.atm;

public interface BanknotesKeeper {
    Banknote getOneBanknote();
    boolean put(Banknote banknote);
    long getKeeperNominal();
    int getQuantity();
    BanknoteType getBanknoteType();
}
