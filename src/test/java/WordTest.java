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
	public void all_returnsAllInstanceOfWord_true() {
		Word firstWord = new Word("cool");
		Word secondWord = new Word("cool");
		assertTrue(Word.all().contains(firstWord));
		assertTrue(Word.all().contains(secondWord));
	}

  @Test
	public void clear_removesAllWordInstancesFromMemory() {
		Word testWord = new Word("cool");
		Word.clear();
		assertEquals(Word.all().size(), 0);
	}

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("cool");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void addDefinition_addsDefinitionToList() {
    Word testWord = new Word("cool");
    Definition testDefinition = new Definition("of or at a fairly low temperature.");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}
