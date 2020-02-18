package ru.otus.homework.atm.demo1;
import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.BanknotesKeeper;
import ru.otus.homework.atm.UnsupportedBanknoteException;
import ru.otus.homework.atm.demo2.NewBanknote;

import java.util.ArrayList;

public class SimpleAtmDemo {
    public static void main(String[] args) {
        ArrayList<BanknotesKeeper> cells = new ArrayList<>();
        SimpleAtm atm1 = new SimpleAtm();
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(10)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(50)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(100)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(500)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(1000)));
        ArrayList<Banknote> pack = new ArrayList<>();
        pack.add(new SimpleBanknote(50));
       // pack.add(new SimpleBanknote(100));
        pack.add(new NewBanknote(100,810,12365478954456L));
        pack.add(new NewBanknote(10,840,123654455456546L));
        try {
            atm1.putPack(pack);
            atm1.putPack(pack);
        } catch (UnsupportedBanknoteException e) {
            e.printStackTrace();
        }
        System.out.println(atm1.getAmount());
        ArrayList<Banknote> gettingPack = new ArrayList<>();
        System.out.println(atm1.getPack(300, gettingPack ));
        System.out.println(atm1.getAmount());
        for (Banknote banknote : gettingPack) {
            if (banknote instanceof NewBanknote) {
                System.out.println(((NewBanknote)banknote).getNumber());
            }
        }

    }
}
