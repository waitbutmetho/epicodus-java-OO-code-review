import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  @Test
  public void getWord_returnsWord() {
    Word testWord = new Word("cool");
    assertEquals("cool", testWord.getWord());
  }

  @Test
	public void getId_returnsWordsId() {
		Word testWord = new Word("cool");
		assertTrue(Word.all().size() == testWord.getId());
	}

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList() {
    Word testWord = new Word("cool");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

  @Test
	public void all_returnsAllInstanceOfTask_true() {
		Word firstWord = new Word("cool");
		Word secondWord = new Word("cool");
		assertTrue(Word.all().contains(firstWord));
		assertTrue(Word.all().contains(secondWord));
	}

}
