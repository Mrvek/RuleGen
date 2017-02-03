package presentation;

import org.json.JSONArray;
import presentation.Rest.BRDataFetch;
import presentation.Rest.ProjectDataFetch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static spark.Spark.after;
import static spark.Spark.*;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class RestService {
    public static void main(String args[]) {
        get("/hello", (req, res) -> "Hello World");

       // List<String> keys = new ArrayList<>();
       // keys.add("10");
       // JSONArray result = new BRDataFetch().getData(3);
       // System.out.println("returning: " + result + "\n");

        get("/BR/*/generate", (request, response) -> {
            JSONArray answer = new BRDataFetch().getBR(request.splat()[0]);
            return answer;
        });

        get("/BR/*/push", (request, response) -> {
            boolean answer = new BRDataFetch().pushcode(request.splat()[0]);
            return answer;
        });
        get("/check", (request, response) -> {
        	Date date = new Date();
        	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        	String formattedDate = sdf.format(date);
        	System.out.println("Connection check done at: "+formattedDate);
            return "Connection established at: " + formattedDate;
        });

        get("/project/*/new", (request, response) -> {
        	System.out.println("Started filling tables for ToolsDB of project: " + request.splat()[0]);
            JSONArray answer = new ProjectDataFetch().initialise(request.splat()[0]);
            return answer;
        });

        get("/project/update", (request, response) -> {
            JSONArray answer = new ProjectDataFetch().update(request, response);
            return answer;
        });

        after((req, res) -> {
            res.type("application/json");
        });

//        TODO: REST for targetDB Analysis!
    }
}
