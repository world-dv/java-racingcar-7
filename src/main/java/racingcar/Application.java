package racingcar;

import java.util.List;
import racingcar.context.RacingCar;
import racingcar.service.Racing;
import racingcar.service.RacingCars;
import racingcar.service.RacingResult;
import racingcar.util.CarNameSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.PrintMessage;

public class Application {
    public static void main(String[] args) {
        OutputView.printMessageWithLine(PrintMessage.INPUT_CAR_NAME_MESSAGE);
        String carName = InputView.inputUser();

        //컨트롤러 영역에서 해야 할 일
        //1. 이름 입력 받아 쉼표 기준 분리
        List<String> carNameGroup = CarNameSeparator.splitCarNameWithSeparator(carName);

        //2. 이름 검증(공백 제거, 5자 이하 검증)
        //3. Car List 생성
        RacingCars createCarGroup = new RacingCars(carNameGroup);
        List<RacingCar> carGroup = createCarGroup.getRacingCars();

        //라운드 수 입력 받기
        OutputView.printMessageWithLine(PrintMessage.INPUT_TRY_CAR_MOVEMENT_MESSAGE);
        String totalRound = InputView.inputUser();
        //4. 라운드 수만큼 반복하면서 자동차 이동 시도
        Racing carRace = new Racing(totalRound, carGroup);

        //자동차 경기 현황 출력
        OutputView.printMessageWithLine(PrintMessage.LINE_SPACE);
        OutputView.printMessageWithLine(PrintMessage.CAR_RACE_RESULT_MESSAGE);
        carRace.startRacing();

        //5. 경기 결과 판단
        RacingResult carRacingResult = new RacingResult(carRace.getRacingCars());
        //자동차 경기 결과 출력
        OutputView.printMessage(PrintMessage.CAR_RACE_WINNER_MESSAGE);
        OutputView.printCarRacingResult(carRacingResult.getCarRacingWinners());
    }
}
