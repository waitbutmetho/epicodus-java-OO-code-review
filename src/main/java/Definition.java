import java.time.LocalDateTime;
import java.util.ArrayList;

public class Definition {

  private String mDefinition;
  private LocalDateTime mCreatedAt;

  public Definition(String definition) {
    mDefinition = definition;
    mCreatedAt = LocalDateTime.now();
  }

  public String getDefinition() {
    return mDefinition;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }
}
