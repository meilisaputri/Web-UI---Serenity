package Psegameshop.stepdefinitions;

import Psegameshop.pageobjects.loginPageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.cdimascio.dotenv.Dotenv;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.ClickOn;
import tasks.InputField;
import tasks.NavigateTo;
import net.serenitybdd.screenplay.Actor;
import tasks.VerifyDisplayed;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class loginstepdefinitions {
    @Given("{actor} open the website")
    public void visitorOpenTheWebsite(Actor actor) throws Exception {
        actor.wasAbleTo(NavigateTo.theURL("Log In"));

    }

    @When("{actor} click on user icon element")
    public void visitorClickOnUserIconElement(Actor actor) throws Exception {
        actor.attemptsTo(
                ClickOn.button("User Element"),
                WaitUntil.the(loginPageObjects.USER_ELEMENT, isVisible()).forNoMoreThan(30).seconds()
        );
    }

//    @And("{actor} input username and password")
//    public void visitorInputUsernameAndPassword(Actor actor) throws Exception {
//        Dotenv dotenv = Dotenv.load();
//
//        String username = dotenv.get("USERNAME");
//        String password = dotenv.get("PASSWORD");
//
//        actor.attemptsTo(
//                InputField.onField("username", username),
//                InputField.onField("password", password));
//    }

    @And("{actor} input username {string}")
    public void visitorInputUsername(Actor actor, String username) throws Exception {
        actor.attemptsTo(InputField.onField("username", username));
    }

    @And("{actor} input password {string}")
    public void visitorInputPassword(Actor actor, String password) throws Exception {
        actor.attemptsTo(InputField.onField("password", password));
    }

    @And("{actor} click on login button")
    public void visitorClickOnButton(Actor actor) throws Exception {
        actor.attemptsTo(ClickOn.button("Log In"));
    }

    @Then("{actor} logged in successfully")
    public void validateLoggedInSuccessfully(Actor actor) throws Exception{
        actor.attemptsTo(
                WaitUntil.the(loginPageObjects.USER_ELEMENT, isVisible()).forNoMoreThan(30).seconds(),
                ClickOn.button("User Element"),
                Ensure.that(loginPageObjects.MYACCOUNT_ELEMENT).isDisplayed());
    }

    @Then("{actor} direct to homepage and should see login error message")
    public void visitorDirectToHomepageAndShouldSeeErrorMessage(Actor actor, String elementType) throws Exception {
        actor.attemptsTo(VerifyDisplayed.elementDisplayed(elementType));
    }
}
