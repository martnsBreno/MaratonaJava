package GenericsClasses;

import service.BarcoRentalService;
import service.CarroRentalService;

public class ClasseGenericaTeste01 {
    public static void main(String[] args) {
        CarroRentalService carroRentalService = new CarroRentalService();
        Carro carro = carroRentalService.buscarCarrosDisponivel();
        System.out.println("Usando o carro pelo tempo alugado....");
        carroRentalService.retornarCarroAlugado(carro);
        System.out.println("------------------------------");
        BarcoRentalService barcoRentalService = new BarcoRentalService();
        Barco barco = barcoRentalService.buscarBarcosDisponivel();
        System.out.println("Usando o barco pelo tempo alugado....");
        barcoRentalService.retornarBarcoAlugado(barco);
    }
}
