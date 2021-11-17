package ru.lyubovsam.github.allure;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.lyubovsam.github.allure.steps.WebSteps;


public class StepAnnotatedTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private WebSteps steps = new WebSteps();

    @Test
    @Owner("LyubovSam")
    @DisplayName("Тест на проверку наличия Issue")
    @Link(name = "Github", url = "https://github.com/")
    @Feature("Авторизация")
    @Story("Проверка наличия Issue")
    @Severity(SeverityLevel.BLOCKER)

    public void testGithub(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);

    }
}
