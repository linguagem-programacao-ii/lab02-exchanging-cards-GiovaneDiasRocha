qtdeCards = '3 4'
cardsAlice = '1 3 5 5 4'
cardsBetty = '2 4 6 8 2 4'
qtdeExchangingCards = len(cardsAlice) - cardsAlice.count(' ') if len(cardsAlice) <= len(cardsBetty) else len(cardsBetty) - cardsBetty.count(' ')

cardsMenor = cardsAlice if len(cardsAlice) - cardsAlice.count(' ') <= qtdeExchangingCards else cardsBetty
cardsMaior = cardsAlice if len(cardsAlice) - cardsAlice.count(' ') >= qtdeExchangingCards else cardsBetty
positionCardMaior = 0

for i, c in enumerate(cardsMenor, start=0):
  if cardsMenor[i] != ' ':
    positionCardMaior = i if int(cardsMenor[i]) > i else positionCardMaior
    d = cardsMenor.count(cardsMenor[i])
    if d > 1:
      if i > positionCardMaior:
        qtdeExchangingCards = qtdeExchangingCards -1
print(qtdeExchangingCards)