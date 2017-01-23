package presentation.Rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class RestService {
    public static void main(String args[]) {
        List<Integer> keys = new ArrayList<>();
        keys.add(1);
        BRDataFetch dataFetch = new BRDataFetch();
        String result = dataFetch.getData(keys);
        System.out.println("Generating code...");
        System.out.println(result + "\n");
    }
}
