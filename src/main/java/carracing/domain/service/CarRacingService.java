package carracing.domain.service;

import carracing.domain.entity.Number;
import carracing.domain.entity.Round;

public interface CarRacingService {

  void initRacing(Number number, Round round);

  String gameStart();
}
