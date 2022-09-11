import java.util.ArrayList;
import java.util.List;

public class SmartphoneTest01 {
    public static void main(String[] args) {

        Smartphone s1 = new Smartphone("12A3B", "Motorola");
        Smartphone s2 = new Smartphone("25A3B", "Xiaomi");
        Smartphone s3 = new Smartphone("53E3B", "Asus");
        List<Smartphone> SmartList = new ArrayList<>();
        SmartList.add(s2);
        SmartList.add(s3);
        SmartList.add(s1);

        for (Smartphone smart : SmartList) {
            System.out.println(smart);
        }

        Smartphone s4 = new Smartphone("12A3B", "Motorola");
        System.out.println(SmartList.contains(s4));
        int i = SmartList.indexOf(s4);
        System.out.println(i);
        System.out.println("------------");
        System.out.println(SmartList.get(i));
    }
}
