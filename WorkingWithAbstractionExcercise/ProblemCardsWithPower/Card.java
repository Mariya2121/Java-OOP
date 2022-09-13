package WorkingWithAbstractionExcercise.ProblemCardsWithPower;

import WorkingWithAbstractionExcercise.CardRank.CardRanks;
import WorkingWithAbstractionExcercise.CardSuit.CardSuits;

public class Card {
    private CardRanks cardRanks;
    private CardSuits cardSuits;

    public Card(CardRanks cardRanks, CardSuits cardSuits) {
        this.cardRanks = cardRanks;
        this.cardSuits = cardSuits;
    }

    public CardRanks getCardRanks() {
        return cardRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public int getPower() {
        return cardSuits.getSuitPower() + cardRanks.getRankPower();
    }
}
