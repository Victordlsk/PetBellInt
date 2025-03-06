import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


public class MainPageTests extends BasePages {

    @Test
    @Epic("Главная страница") // группирует тесты по большой функциональности
    @Feature("Раздел книги")// выделяет конкретную функциональность в рамках эпика
    @Story("Отображение раздела книги")// описывает конкретный сценарий
    @Severity(SeverityLevel.CRITICAL)// указывает важность теста (BLOCKER.CRITICAL.NORMAL.MINOR.TRIVIAL)
    @Description("Проверка успешного нахождения раздела книги")// Просто описание теста
    @Link(name = "Документация", url = "https://confluence.company.com/test-case-123") //добавляет в отчет ссылку на что-то
    @Owner("Виктор")// Заметка кто писал тест

    //@Tag("Smoke") - добавляет тег по типу тестирования (mvn test -D groups="Smoke" - запуск по типу)

    /*@Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    } С помощь. этой аннотации к отчету добавляются файлы (скриншоты, логи, JSON-файлы и т.д)*/

    /*@Issue("BUG-456")
    public void testLoginWithInvalidPassword() { ... }
    Связывает тест с багом в баг-трекинговой системе (JIRA, YouTrack и т. д.*/

    /*@TmsLink("TC-789")
    public void testUserCanResetPassword() { ... }
    Связывает тест с тест-кейсом в тест-менеджменте (TestRail, Allure TestOps, Qase)*/

    //@Step("Открываем сайт") - записывает шаги теста (вызывается перед методом - каждое действие надо в свой метод)

    public void test1IncorrectCategoriesBug() {
        var spanCatalog = By.xpath("//li[@id='menu-item-46']");
        var books = By.xpath("//li[@class='cat-item cat-item-28']");
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(spanCatalog).click();
        try {
            Assertions.assertTrue(driver.findElement(books).isDisplayed(), "Поле есть");
        } catch (NoSuchElementException e) {
            System.out.println("Элемента нет в DOM древе");
        }
    }

    @Test
    @Epic("Раздел книги") // группирует тесты по большой функциональности
    @Feature("Отображение раздела книги")// выделяет конкретную функциональность в рамках эпика
    @Story("Поиск определенной книги")// описывает конкретный сценарий
    @Severity(SeverityLevel.NORMAL)// указывает важность теста (BLOCKER.CRITICAL.NORMAL.MINOR.TRIVIAL)
    @Description("Поиск книги Мартин Форд. Роботы наступают")// Просто описание теста
    @Link(name = "Документация", url = "https://confluence.company.com/test-case-123") //добавляет в отчет ссылку на что-то
    @Owner("Виктор")// Заметка кто писал тест
    public void test2GoToShoppingCart() {
        var spanCatalog = By.xpath("//li[@id='menu-item-46']");
        var withoutCategory = By.xpath("//li[@class='cat-item cat-item-15']//a");
        var books = By.xpath("//li[@class='cat-item cat-item-28']//a");
        var saleBook = By.xpath("//h3[text()='Мартин Форд. Роботы наступают']");
        var buttonCart = By.xpath("//button[@name='add-to-cart']");
        var moreAboutCart = By.xpath("//a[@class='button wc-forward']");
        driver.navigate().to("http://intershop5.skillbox.ru/");
        driver.findElement(spanCatalog).click();
        driver.findElement(withoutCategory).click();
        driver.findElement(books).click();
        driver.findElement(saleBook).click();
        driver.findElement(buttonCart).click();
        Assertions.assertTrue(driver.findElement(moreAboutCart).isDisplayed(), "Поле есть");
    }
}
