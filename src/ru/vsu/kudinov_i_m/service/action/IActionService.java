package ru.vsu.kudinov_i_m.service.action;

import ru.vsu.kudinov_i_m.model.ActionType;
import ru.vsu.kudinov_i_m.model.Game;

import java.util.List;

public interface IActionService
{
    void doStep(Game game, List<ActionType> possibleSteps);

    List<ActionType> findPossibleSteps(Game game);
}
