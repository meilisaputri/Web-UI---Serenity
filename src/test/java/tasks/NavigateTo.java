package tasks;

import Psegameshop.pageobjects.loginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theURL(String urlType) throws Exception {
        Class url;

        switch (urlType) {
            case "Log In":
                url = loginPageObjects.class;
                break;
            default:
                throw new Exception("There is no url type: " + urlType);
        }

        return Task.where("{0} access the login url",
                Open.browserOn().the(url));
    }
}
