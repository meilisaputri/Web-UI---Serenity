package Psegameshop.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.psegameshop.com/")
public class loginPageObjects extends PageObject {

//ELEMENT
    public static Target USER_ELEMENT = Target.the("User Element")
            .locatedBy("(//*[contains(@href,'https://www.psegameshop.com/my-account')])[1]");
    public static Target MYACCOUNT_ELEMENT = Target.the("my account button")
            .locatedBy("//*[contains(@class,'uppercase mb-0')]");
    public static Target ERROR_MESSAGE = Target.the("error message")
            .locatedBy("//*[contains(@class,'message-container container alert-color medium-text-center')]");

//LOGIN INPUT
    public static Target USERNAME_FIELD = Target.the("username")
            .locatedBy("#username");
    public static Target PASSWORD_FIELD = Target.the("password")
            .locatedBy("#password");

//BUTTON
    public static Target LOGIN_BUTTON = Target.the("login button")
            .locatedBy("//button[contains(@class,'woocommerce-button button woocommerce-form-login__submit')]");
}
