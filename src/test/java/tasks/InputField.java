package tasks;

import Psegameshop.pageobjects.loginPageObjects;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class InputField {
    public static Performable onField(String fieldType, String value) throws Exception {
        Target field;

        switch (fieldType) {
            case "username":
                field = loginPageObjects.USERNAME_FIELD;
                break;
            case "password":
                field = loginPageObjects.PASSWORD_FIELD;
                break;
            default:
                throw new Exception("There is no field type: " + fieldType);
        }

        return Task.where("{0} input: '" + value + "'",
                Enter.theValue(value)
                        .into(field)
        );
    }
}
