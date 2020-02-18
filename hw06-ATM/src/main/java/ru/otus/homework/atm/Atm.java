package ru.otus.homework.atm;
import java.util.List;
public interface Atm {
    boolean getPack(long amount, List<Banknote> pack);
    void putPack(List<Banknote> pack) throws UnsupportedBanknoteException;
    long getAmount();
}
