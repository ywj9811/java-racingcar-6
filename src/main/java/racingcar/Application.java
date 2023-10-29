package racingcar;

import racingcar.controller.ProgressController;
import racingcar.controller.InitController;
import racingcar.dto.GameSettingDto;
import racingcar.repository.CarRepository;
import racingcar.service.InputService;
import racingcar.service.RacingService;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        CarRepository carRepository = new CarRepository();
        InputService inputService = new InputService(carRepository, outputView);
        InitController initController = new InitController(inputService);
        GameSettingDto gameSettingDto = initController.gameInit();
        RacingService racingService = new RacingService(gameSettingDto.getCars(), gameSettingDto.getTimes(), outputView, carRepository);
        ProgressController progressController = new ProgressController(racingService);
        progressController.gameProgress();
    }
}
