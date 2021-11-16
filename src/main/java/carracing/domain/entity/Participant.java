package carracing.domain.entity;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Participant {

  private static final String COMMA = ",";

  private final List<Name> participant;

  public Participant(List<Name> participant) {
    this.participant = participant;
  }

  public List<Name> getParticipant() {
    return participant;
  }

  public int size() {
    return participant.size();
  }

  public boolean isEmpty() { return  participant.isEmpty();}

  public static Participant parse(String name) {
    return new Participant(getSplitNameByDelimiter(name));
  }

  private static List<Name> getSplitNameByDelimiter(String name) {
    return Arrays.stream(name.split(COMMA))
                 .map(Name::new)
                 .collect(toList());
  }
}
