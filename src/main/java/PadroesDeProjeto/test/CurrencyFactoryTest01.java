package PadroesDeProjeto.test;

import PadroesDeProjeto.dominio.Country;
import PadroesDeProjeto.dominio.Currency;
import PadroesDeProjeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.USA);
        System.out.println(currency.getSymbol());
    }
}
