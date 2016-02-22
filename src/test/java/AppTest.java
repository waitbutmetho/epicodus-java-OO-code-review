import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver(true);

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Custom Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a new Word to the dictionary"));
    fill("#name").with("cool");
    submit(".btn");
    assertThat(pageSource()).contains("Your addition has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("cool");
    submit(".btn");
    click("a", withText("View Word List"));
    assertThat(pageSource()).contains("cool");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("cool");
    submit(".btn");
    click("a", withText("View Word List"));
    await().atMost(100).untilPage().isLoaded();
    click("a", withText("cool"));
    click("a", withText("Add a new Definition"));
    assertThat(pageSource()).contains("Add a Definition to cool");
  }

  @Test
  public void defintionsAreAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#name").with("cool");
    submit(".btn");
    click("a", withText("View Word List"));
    click("a", withText("cool"));
    click("a", withText("Add a new Definition"));
    fill("#definition").with("of or at a fairly low temperature.");
    submit(".btn");
    assertThat(pageSource()).contains("of or at a fairly low temperature.");
  }
}
