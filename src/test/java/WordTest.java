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

}
