package racinggame.view;

import static racinggame.message.MessageConstant.COLON;
import static racinggame.message.MessageConstant.NEW_LINE;
import static racinggame.message.MessageConstant.POSITION_INDICATE;
import static racinggame.message.MessageConstant.RACING_RESULT;
import static racinggame.message.MessageConstant.WINNER_CALL;

import java.util.List;
import racinggame.domain.model.MovingResult;
import racinggame.domain.model.RacingResult;
import racinggame.vo.CarSateInRace;

public class ResultView {

  private ResultView() {}

  public static void printRacingResult(RacingResult racingResult) {
    System.out.println(NEW_LINE + RACING_RESULT);
    List<MovingResult> movingResults = racingResult.getMovingResults();
    movingResults.forEach(ResultView::printRoundResult);
  }

  public static void printFinalWinnerCarNames(RacingResult racingResult) {
    System.out.println(racingResult.getWinnerCarNames()+WINNER_CALL);
  }

  private static void printRoundResult(MovingResult movingResults) {
    List<CarSateInRace> carSateInRaces = movingResults.getCarSateInRaces();
    carSateInRaces.forEach(ResultView::printCarMovingPosition);
    System.out.println(NEW_LINE);
  }

  private static void printCarMovingPosition(CarSateInRace carSateInRace) {
    StringBuilder sb = new StringBuilder();
    sb.append(carSateInRace.getCarName() + COLON);
    for (int i = 0; i < carSateInRace.getRacingPosition(); i++) {
      sb.append(POSITION_INDICATE);
    }
    System.out.println(sb.toString());
  }
}