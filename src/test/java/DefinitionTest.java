import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void Definition_instantiatesCorrectly() {
    Definition myDefinition = new Definition("of or at a fairly low temperature.");
    assertEquals(true, myDefinition instanceof Definition);
  }
}
