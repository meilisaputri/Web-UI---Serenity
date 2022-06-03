package tasks;

import Psegameshop.pageobjects.loginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickOn {

    public static Performable button(String buttonType) throws Exception {
        Target button;

        switch (buttonType) {
            case "User Element":
                button = loginPageObjects.USER_ELEMENT;
                break;
            case "Log In":
                button = loginPageObjects.LOGIN_BUTTON;
                break;
            default:
                throw new Exception("There is no button type: " + buttonType);
        }

        WaitUntil.the(button, isVisible()).forNoMoreThan(100).seconds();

        return Task.where("{0} click " + buttonType + " button ",
                Click.on(button)
        );
    }
}
