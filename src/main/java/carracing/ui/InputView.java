package carracing.ui;

import carracing.domain.entity.Name;
import carracing.domain.entity.Number;
import carracing.domain.entity.Participant;
import carracing.domain.entity.Round;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

  private static InputView instance;

  private static final String CAR_QUESTION = "경주할 자동차 이름을 입력하세요(이름 쉼표(,)를 기준으로 구분)";
  private static final String TRY_QUESTION = "시도할 횟수는 몇 회 인가요?";
  private static final String INPUT_MESSAGE = "잘못 입력 하셨습니다. 0 이상의 자연수를 입력해주세요";

  private static final int ZERO = 0;
  private static final String COMMA =",";
  private static final String EMPTY_STRING = "";

  private InputView() {}

  public static InputView getInstance() {
    if (instance == null) {
      return instance = new InputView();
    }
    return instance;
  }

  public Participant inputNumberOfCar() {
    return inputName(CAR_QUESTION);
  }

  public Round inputTryCount() {
    return new Round(new Number(inputRound(TRY_QUESTION)));
  }

  private int inputRound(String question) {
    int count = ZERO;
    while (!isGreaterThanZero(count)) {
      System.out.println(question);
      count = inputInteger();
    }
    return count;
  }

  private Participant inputName(String question) {
    List<Name> nameList = getNames(question);
    return new Participant(nameList);
  }

  private List<Name> getNames(String question) {
    List<Name> nameList = null;
    while (nameList == null) {
      System.out.println(question);
      nameList = parseNameToList(inputKeyboard().trim());
    }
    return nameList;
  }

  private boolean isGreaterThanZero(int count) {
    return count > ZERO;
  }

  private List<Name> parseNameToList(String name) {
    List<Name> names = null;
    try {
      names = getSplitNameByDelimiter(name);
    } catch (Exception e) {}
    return names;
  }

  private List<Name> getSplitNameByDelimiter(String name) {
    return Arrays.stream(name.split(COMMA))
                 .map(Name::new)
                 .collect(toList());
  }

  private String inputKeyboard() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  private int inputInteger() {
    int count = ZERO;
    try {
      count = Integer.parseInt(inputKeyboard());
    } catch (NumberFormatException e) {
      System.out.println(INPUT_MESSAGE);
    }
    return count;
  }


}
