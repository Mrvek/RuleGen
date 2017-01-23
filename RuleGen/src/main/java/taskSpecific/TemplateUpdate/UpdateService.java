package taskSpecific.TemplateUpdate;

import domainGeneric.TemplateBuilderService;

import java.util.Calendar;

/**
 * Created by Mitchell on 18/01/2017.
 */
public class UpdateService {
    private Calendar dateTime;
    private TemplateBuilderService builder = new TemplateBuilderService();

    public void update() {
        if (checkTime()) {
            Boolean check = builder.checkForNewTemplates();

            if (check) {
                setTime();
                System.out.println("Check done on: " + dateTime.getTime() + "\n");
            } else {
                System.out.print("No new templates found\n");
            }
        }

    }

    private boolean checkTime() {
        Calendar checkwith = Calendar.getInstance();
        if (dateTime == null || dateTime.compareTo(checkwith) >= 3600000) {
            return true;
        }else return false;

    }

    private void setTime() {
        dateTime = Calendar.getInstance();
    }
}
