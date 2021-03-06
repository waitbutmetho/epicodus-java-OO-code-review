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

  @Test
  public void Definition_instantiatesWithDefinition() {
    Definition myDefinition = new Definition("of or at a fairly low temperature.");
    assertEquals("of or at a fairly low temperature.", myDefinition.getDefinition());
 }

 @Test
  public void getCreatedAt_instantiatesWithCurrentTime_today() {
  Definition myDefinition = new Definition("of or at a fairly low temperature.");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myDefinition.getCreatedAt().getDayOfWeek());
 }

  @Test
  public void all_returnsAllInstancesOfDefinition() {
     Definition firstDefinition = new Definition("of or at a fairly low temperature.");
     Definition secondDefinition = new Definition("having a high degree of heat or a high temperature.");
     assertTrue(Definition.all().contains(firstDefinition));
     assertTrue(Definition.all().contains(secondDefinition));
   }

   @Test
  public void newId_definitionsInstantiateWithAnID_true() {
    Definition myDefinition = new Definition("of or at a fairly low temperature.");
    assertEquals(Definition.all().size(), myDefinition.getId());
  }

  @Test
  public void find_returnsDefinitionWithSameId_secondTask() {
    Definition firstDefinition = new Definition("of or at a fairly low temperature.");
    Definition secondDefinition = new Definition("having a high degree of heat or a high temperature.");
    assertEquals(Definition.find(secondDefinition.getId()), secondDefinition);
  }

  @Test
  public void find_returnsNullWhenNoTaskFound_null() {
    assertTrue(Definition.find(999) == null);
  }


  @Test
  public void clear_emptiesAllDefinitionsFromArrayList() {
    Definition myDefinition = new Definition("of or at a fairly low temperature.");
    Definition.clear();
    assertEquals(Definition.all().size(), 0);
  }
}
