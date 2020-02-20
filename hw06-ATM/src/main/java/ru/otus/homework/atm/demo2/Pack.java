package ru.otus.homework.atm.demo2;

import ru.otus.homework.atm.Banknote;

public interface Pack {
    void putInOnebanknote(Banknote banknote);
    Banknote getOutOneBanknote();

}
