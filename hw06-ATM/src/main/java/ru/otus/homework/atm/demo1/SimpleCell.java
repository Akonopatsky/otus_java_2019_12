package ru.otus.homework.atm.demo1;

import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.BanknoteType;
import ru.otus.homework.atm.BanknotesKeeper;

import java.util.Stack;

public class SimpleCell implements BanknotesKeeper {
    final private Stack<Banknote> banknotes = new Stack<>();

    public SimpleCell(BanknoteType banknoteType) {
        this.banknoteType = banknoteType;
    }

    final private BanknoteType banknoteType;
    @Override
    public Banknote getOneBanknote() {
        return banknotes.pop();
    }
    @Override
    public boolean put(Banknote banknote) {
        if (banknote.getBanknoteType().equals(this.getBanknoteType()))
        {
            banknotes.push(banknote);
            return true;
        }
        return false;
    }
    @Override
    public long getKeeperNominal() {
        return this.getBanknoteType().getNominal();
    }
    @Override
    public int getQuantity() {
        return  banknotes.size();
    }
    @Override
    public BanknoteType getBanknoteType() {
        return banknoteType;
    }

}
