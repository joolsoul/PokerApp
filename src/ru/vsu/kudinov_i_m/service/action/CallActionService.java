package ru.vsu.kudinov_i_m.service.action;

import ru.vsu.kudinov_i_m.model.ActionType;
import ru.vsu.kudinov_i_m.model.Game;

import java.util.List;

public class CallActionService implements IActionService
{

    @Override
    public void doStep(Game game, List<ActionType> possibleSteps)
    {

    }

    @Override
    public List<ActionType> findPossibleSteps(Game game)
    {
        return null;
    }
}
