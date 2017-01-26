package presentation.Rest;

import org.json.JSONArray;
import spark.Request;
import spark.Response;
import taskSpecific.ProjectUpdate.ProjectController;

/**
 * Created by Mitchell on 26/01/2017.
 */
public class ProjectDataFetch {
    public JSONArray initialise(Request request, Response response) {
        int projectId = Integer.parseInt(request.attribute("project"));
        JSONArray result = new ProjectController().initialiseProject(projectId);
        return result;
    }

    public JSONArray update(Request request, Response response) {
        JSONArray result = new ProjectController().updateProject();
        return result;
    }
}
