package racingcar.validation;

public class RacingRoundValidation {
    private static final Integer ROUND_CRITERION_NUMBER = 1;

    public static boolean validateRacingRoundType(String racingRound) {
        return !racingRound.matches("^[0-9]+$");
    }

    public static boolean validateRacingRoundNumberRange(Integer racingRound) {
        return racingRound < ROUND_CRITERION_NUMBER;
    }
}
