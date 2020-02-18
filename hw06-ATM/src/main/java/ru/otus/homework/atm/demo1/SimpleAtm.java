package ru.otus.homework.atm.demo1;
import ru.otus.homework.atm.Atm;
import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.BanknotesKeeper;
import ru.otus.homework.atm.UnsupportedBanknoteException;

import java.util.*;

public class SimpleAtm implements Atm {
    private ArrayList<BanknotesKeeper> cells;

    @Override
    public boolean getPack(long amount, List<Banknote> pack) {
        if(!checkAmount(amount)) return false;
        long ost = amount;
        int i = cells.size()-1;
        BanknotesKeeper currentCell;
        while (i>=0) {
            if (ost == 0) return true;
            currentCell = cells.get(i);
            if (currentCell.getQuantity()>0 && ost >= currentCell.getKeeperNominal()) {
                pack.add(currentCell.getOneBanknote());
                ost-=currentCell.getKeeperNominal();
            }
            else {
                i--;
            }
        }
        return false;
    }
    private boolean checkAmount(long amount) {

        long ost = amount;
        int[] tempCells = new int[cells.size()];
        for (int i = 0; i < cells.size(); i++) {
            tempCells[i] = cells.get(i).getQuantity();
        }
        int i = tempCells.length-1;
        long nominal;
        while (i>=0) {
            if (ost == 0) return true;
            nominal = cells.get(i).getKeeperNominal();
            if (tempCells[i]>0 && ost >= nominal) {
                tempCells[i]--;
                ost-=nominal;
            }
            else {
                i--;
            }
        }
        return false;
    }

    @Override
    public void putPack(List<Banknote> pack) throws UnsupportedBanknoteException {
        for (Banknote banknote : pack) {
            putBanknoteIn(banknote);
        }

    }
    private void putBanknoteIn(Banknote banknote) throws UnsupportedBanknoteException {
        for (int i = 0; i < cells.size() ; i++) {
            BanknotesKeeper cell = cells.get(i);
            if (banknote.getBanknoteType().equals(cell.getBanknoteType())) {
                cell.put(banknote);
                return;
            }
        }
        throw new UnsupportedBanknoteException();
    }
    @Override
    public long getAmount() {
        long amount = 0;
        for (BanknotesKeeper cell : cells) {
            amount+=cell.getKeeperNominal()*cell.getQuantity();
        }
        return amount;
    }
    public SimpleAtm() {
        this.cells = new ArrayList<>();

    }
    public void addCell(BanknotesKeeper cell) {
        cells.add(cell);
        cells.sort(Comparator.comparing(BanknotesKeeper::getKeeperNominal));
    }
    public void clearCells() {
        cells.clear();
    }
}
