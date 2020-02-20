package ru.otus.homework.atm.demo1;
import ru.otus.homework.atm.Banknote;
import ru.otus.homework.atm.AtmCell;

import java.util.ArrayList;
import java.util.List;

public class SimpleAtmDemo {
    public static void main(String[] args) {
        ArrayList<AtmCell> cells = new ArrayList<>();
        SimpleAtm atm1 = new SimpleAtm();
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(10)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(50)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(100)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(500)));
        atm1.addCell(new SimpleCell(new SimpleBanknoteType(1000)));
        List<Banknote> pack = new ArrayList<>();
        Banknote s50 = new SimpleBanknote(50);
        pack.add(s50);
        pack.add(new SimpleBanknote(73));
        //atm1.putPack(pack);

        System.out.println(atm1.getAmount());
/*            atm1.putPack(pack);

        System.out.println(atm1.getAmount());
        ArrayList<Banknote> gettingPack = new ArrayList<>();
        System.out.println(atm1.getMoney(300, gettingPack ));
        System.out.println(atm1.getAmount());
        for (Banknote banknote : gettingPack) {
            if (banknote instanceof NewBanknote) {
                System.out.println(((NewBanknote)banknote).getNumber());
            }
        }*/

    }
}
