import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListArrayConversao {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        Integer[] integers = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers));
        System.out.println("--------------------");
        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);
    }
}
