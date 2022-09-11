package PadroesDeProjeto.test;

import PadroesDeProjeto.dominio.*;

public class DataTransferObjectTest01 {
    public static void main(String[] args) {
        Aircraft aircraft = new Aircraft("777-1");
        Country country = Country.BRAZIL;
        Currency currency = CurrencyFactory.newCurrency(country);
        Person person = Person.PersonBuilder.builder()
                .firstName("Kat")
                .lastName("Oliv")
                .build();
        ReportDto.ReportDtoBuilder reportDto = ReportDto.ReportDtoBuilder.builder()
                .aircraftName(aircraft.getName())
                .personName(person.getFirstName())
                .country(country)
                .currency(currency);

        System.out.println(reportDto);
    }
}
