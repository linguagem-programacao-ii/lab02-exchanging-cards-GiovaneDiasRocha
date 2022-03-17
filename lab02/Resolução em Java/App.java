public class App {
    public static void main(String[] args) throws Exception {
        String primeiraLinha = "3 4";
        String segundaLinha = "3 7 9";
        String terceiraLinha = "1 5 7 9";

        int qtdeCardsAlice = QuantidadeDeCards(primeiraLinha, 0);
        int qtdeCardsBetty = QuantidadeDeCards(primeiraLinha, 1);

        int[] cardsAlice = getCards(segundaLinha, qtdeCardsAlice);

        int[] cardsBetty = getCards(terceiraLinha, qtdeCardsBetty);

        int qtdeExchangingCards = getQtdeExchangingCards(cardsAlice, cardsBetty);

        System.out.print(qtdeExchangingCards);

    }

    public static int QuantidadeDeCards(String numeral, int position) {
        String[] arrayNumeral = numeral.split(" ");
        return Integer.parseInt(arrayNumeral[position]);
    }

    public static int[] getCards(String numeral, int qtdeCards) {
        String[] arrayNumeral = numeral.split(" ");
        int[] cards = new int[qtdeCards];
        for (int i = 0; i < qtdeCards; i++) {
            cards[i] = Integer.parseInt(arrayNumeral[i]);
        }
        return cards;
    }

    public static int getQtdeExchangingCards(int[] cards1, int[] cards2) {
        int greaterIdentityCard = 0;
        int totalCards = cards1.length + cards2.length;
        int[] allCards = new int[totalCards];
        int qtdeCardsMaior = cards1.length > cards2.length ? cards1.length : cards2.length;
        int qtdeExchangingCards = cards1.length < cards2.length ? cards1.length : cards2.length;
        
        for (int i = 0; i < qtdeCardsMaior; i++) {
            if (i < totalCards - cards2.length) {
                allCards[i] = cards1[i];
            }
            if (i < totalCards - cards1.length) {
                allCards[i + cards1.length] = cards2[i];
            }
        }

        for (int i = 0; i < allCards.length; i++) {
            int currentCardI = allCards[i];
            for (int j = 0; j < allCards.length; j++) {
                int currentCardJ = allCards[j];
                if (currentCardJ == currentCardI && j != i && currentCardI > greaterIdentityCard) {
                    greaterIdentityCard = currentCardI;
                    qtdeExchangingCards--;
                    break;
                }
            }
        }
        return qtdeExchangingCards;
    }
}
