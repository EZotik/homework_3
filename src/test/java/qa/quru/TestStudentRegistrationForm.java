package qa.quru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestStudentRegistrationForm {


    @Test
    void fillFormTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // Скрытие рекламы
        executeJavaScript("$('footer').remove()"); // Скрытие футера
        //Configuration.holdBrowserOpen = true; // Браузер открыт после выполенения теста

        // Поиск полей и заполнение значениями
        $("#firstName").setValue("Ekaterina");
        $("#lastName").setValue("Zotova");
        $("#userEmail").setValue("zotova23@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("7495641005");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("M").sendKeys(Keys.ENTER);
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("AH2I0605.jpg");
        $("#currentAddress").setValue("123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100");
        $("#react-select-3-input").setValue("NCR").sendKeys(Keys.ENTER);
        $("#react-select-4-input").setValue("Delhi").sendKeys(Keys.ENTER);
        $("#submit").click();

        // Проверка полей на соответствие заполненным значениямgi
        $(".modal-open").shouldBe(visible);
        $(".table").shouldHave(text("Ekaterina Zotova"));
        $(".table").shouldHave(text("zotova23@mail.ru"));
        $(".table").shouldHave(text("7495641005"));
        $(".table").shouldHave(text("13 November,1989"));
        $(".table").shouldHave(text("Maths"));
        $(".table").shouldHave(text("Sports, Reading"));
        $(".table").shouldHave(text("AH2I0605.jpg"));
        $(".table").shouldHave(text("123456,Moscow region, Moscow, st. Moskovskaya 12, apt. 100"));
        $(".table").shouldHave(text("NCR Delhi"));
    }
}
