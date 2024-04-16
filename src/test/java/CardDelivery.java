import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.conditions.datetime.DateConditions.date;
import static io.netty.handler.codec.DateFormatter.format;

class CardDelivery {

    @Test
    void cardOrderMainTest() {
        open("http://localhost:9999");
        var deliveryDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(deliveryDate);
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79007007009");
        $(".checkbox__box").click();
        $(".button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Успешно! Встреча успешно забронирована на " + deliveryDate));
    }

    @Test
    void cardOrderSecondTest() {
        open("http://localhost:9999");
        var deliveryDate = LocalDate.now().plusDays(21).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        var deliveryMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        $("[placeholder='Город']").type("Пе");
        $(byText("Петропавловск-Камчатский")).click();
        $("[placeholder='Дата встречи']").click();
        $(".calendar__arrow.calendar__arrow_direction_right").click();
        $$(".calendar__day").findBy(text("7")).click();
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79007007009");
        $(".checkbox__box").click();
        $(".button").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15)).shouldHave(text("Успешно! Встреча успешно забронирована на " + deliveryDate));
    }
}
