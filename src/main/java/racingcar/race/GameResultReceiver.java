package racingcar.race;

import java.util.List;

public interface GameResultReceiver {
    void notifyFinishRace(List<Integer> carPositions);
}