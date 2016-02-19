import java.time.LocalDateTime;
import java.util.ArrayList;

public class Definition {
  private static ArrayList<Definition> instances = new ArrayList<Definition>();

  private String mDefinition;
  private LocalDateTime mCreatedAt;
  private int mId;

  public Definition(String definition) {
    mDefinition = definition;
    mCreatedAt = LocalDateTime.now();
    instances.add(this);
    mId = instances.size();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList<Definition> all() {
    return instances;
  }

  public static Definition find(int id) {
  try {
    return instances.get(id - 1);
  } catch (IndexOutOfBoundsException e) {
    return null;
  }
}
}
