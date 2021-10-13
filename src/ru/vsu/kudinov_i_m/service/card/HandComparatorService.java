package ru.vsu.kudinov_i_m.service.card;

import ru.vsu.kudinov_i_m.model.Card;
import ru.vsu.kudinov_i_m.model.Combination;
import ru.vsu.kudinov_i_m.model.CombinationType;
import ru.vsu.kudinov_i_m.model.Player;
import ru.vsu.kudinov_i_m.service.card.CardComparatorService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class HandComparatorService implements Comparator<Map.Entry<Player, Combination>>
{

    @Override
    public int compare(Map.Entry<Player, Combination> o1, Map.Entry<Player, Combination> o2)
    {
        Combination combination1 = o1.getValue();
        Combination combination2 = o2.getValue();

        if(combination1.getType().equals(CombinationType.ROYAL_FLUSH) && combination2.getType().equals(CombinationType.ROYAL_FLUSH))
        {
            return 0;
        }

        if(combination1.getType().equals(combination2.getType()))
        {
            List<Card> cardList1 = combination1.getCardList();
            List<Card> cardList2 = combination2.getCardList();
            cardList1.sort(Comparator.comparing(Card::getRank));
            cardList2.sort(Comparator.comparing(Card::getRank));

            return new CardComparatorService().compare(cardList1.get(cardList1.size() - 1), cardList2.get(cardList2.size() - 1));
        }

        return combination1.getType().compareTo(combination2.getType());
    }
}
