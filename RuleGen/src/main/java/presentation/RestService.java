package presentation;

import org.json.JSONArray;
import presentation.Rest.BRDataFetch;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.after;
import static spark.Spark.*;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class RestService {
    public static void main(String args[]) {
        get("/hello", (req, res) -> "Hello World");

        List<String> keys = new ArrayList<>();
        keys.add("1");
        JSONArray result = new BRDataFetch().getData(keys, "1");
        System.out.println("Generating code...");
        System.out.println("returning: " + result + "\n");

        get("/hello/BR", (request, response) -> {
            JSONArray answer = new BRDataFetch().getBR(request, response);
            return answer;
        });

        after((req, res) -> {
            res.type("application/json");
        });

//        TODO: REST!
    }
}
