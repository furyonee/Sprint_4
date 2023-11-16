package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;

import static common.constants.scooterOrderPage.Questions.*;

@RunWith(Parameterized.class)
public class FaqListTest extends BaseTest {
    HomePage homePage = new HomePage();
    private final String question;
    private final String questionAnswer;

    public FaqListTest(String question, String questionAnswer) {
        this.question = question;
        this.questionAnswer = questionAnswer;
    }

    @Parameterized.Parameters(name = "Question: {0}, Expected Answer: {1}")
    public static Object[][] getTextData() {
        return new Object[][]{
                {FIRST_QUESTION, FIRST_QUESTION_ANSWER},
                {QUESTION_FROM_MIDDLE_OF_LIST, QUESTION_FROM_MIDDLE_OF_LIST_ANSWER},
                {LAST_QUESTION, LAST_QUESTION_ANSWER},
        };
    }

    @Test
    public void openQuestionDropDownListElement() {
        homePage.expandQuestionsListItem(question)
                .findDisplayedText(questionAnswer);
    }
}
