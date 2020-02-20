package ru.otus.homework.atm;
import java.util.List;
public interface Atm {
    void addCell(AtmCell cell);
    void removeAllCells();
    boolean getMoney(long amount, List<Banknote> pack);
    void putPack(List<Banknote> pack) throws UnsupportedBanknoteException;
    long getAmount();

}
