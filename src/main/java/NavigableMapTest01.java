import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {

        Consumidor consumidor1 = new Consumidor("Breno Martins");
        Consumidor consumidor2 = new Consumidor("Kitagawa Marin");

        NavigableMap<String, String> map = new TreeMap<>();
        map.put("A ", "Letra A");
        map.put("B ", "Letra B");
        map.put("C ", "Letra C");
        map.put("D ", "Letra D");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        System.out.println("------------");

        System.out.println(map.headMap("C"));

        //LOWER
        //HIGHER
        //FLOOR
        //CEILING
    }
}
