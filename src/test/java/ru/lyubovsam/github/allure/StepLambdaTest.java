package ru.lyubovsam.github.allure;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepLambdaTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub(){
        step("Открываем главную страницу Github", () -> {
            open("https://github.com/");

        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();

        });

        step("Переходим в репозиторий" + REPOSITORY, () -> {
            $(By.linkText("eroshenkoam/allure-example")).click();

        });
        step("Открываем tab Issues",() ->{
            $(By.partialLinkText("Issues")).click();

        });
        step("Проверяем что существует Issue с номером"+ ISSUE_NUMBER);
        $(withText("#"+ ISSUE_NUMBER)).should(Condition.visible);

    }
}
