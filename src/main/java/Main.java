import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList();
        nomes.add("Breno");
        nomes.add("Saber");
        nomes.add("Toshaka");
        nomes.add("Rin");
        nomes.remove("Rin");

        for (String nome :
                nomes) {
            System.out.println(nome.matches("Saber"));
        }

        System.out.println("----------------");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }
    }
}