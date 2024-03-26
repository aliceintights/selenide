import com.codeborne.selenide.SelenideElement;
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

        $("[placeholder='Город']").setValue("Санкт-Петербург");
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder='Дата встречи']").setValue(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79007007009");
        $(".checkbox__box").click();
        $(".button").click();
        $(byText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
    }

//    @Test
//    void cardOrderSecondTest() {
//        open("http://localhost:9999");
//
//        $("[placeholder='Город']").type("Пе");
//        $(byText("Петропавловск-Камчатский")).click();
//        $("[placeholder='Дата встречи']").click();
//        $(By.xpath("//div[@class='popup__container'])")).shouldBe(visible, Duration.ofSeconds(10));
//        $(".calendar-input__custom-control").sendKeys("05.04.2024");
////                sendKeys(LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
////        $(".popup").sendKeys(LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
////        $x("//div[@class='popup']").sendKeys(LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
////        $(".popup").selectOption(LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
//        $("[name='name']").setValue("Иванов Иван");
//        $("[name='phone']").setValue("+79007007009");
//        $(".checkbox__box").click();
//        $(".button").click();
//    }
}
