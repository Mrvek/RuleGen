package presentation;

import presentation.Rest.BRDataFetch;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class RestService {
    public static void main(String args[]) {

        List<String> keys = new ArrayList<>();
        keys.add("1");
        BRDataFetch dataFetch = new BRDataFetch();
        String result = dataFetch.getData(keys, "1");
        System.out.println("Generating code...");
        System.out.println(result + "\n");

        post("/hello/:BR", (request, response) -> {
            Response answer = dataFetch.getBR(request, response);
            return answer;
        });

//        TODO: REST!
    }
}
