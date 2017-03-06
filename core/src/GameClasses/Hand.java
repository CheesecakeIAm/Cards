package GameClasses;

import java.util.ArrayList;

public class Hand {
	
	private ArrayList <Card> cards;
	private boolean visible;
	
	public Hand () {
		cards = new ArrayList<Card>();
		visible = false;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Card getCard(int i) {
		return cards.get(i);
	}
	public void addCard(Card card) {
		card.setVisible(visible);
		cards.add(card);
	}
	public Card takeCard(int location) {
		if(cards.size()>1) {
			for (int i = 0; i < cards.size(); i++) {
				if (i < location) {
					cards.get(i).move(cards.get(i).getSize().x / 8, 0);
				}
				if (i > location) {
					cards.get(i).move(cards.get(i).getSize().x / -8, 0);
				}
			}
			if (cards.size() - 1 == location)
				cards.get(cards.size() - 2).setVisibleSize(cards.get(cards.size() - 2).getSize());
			else
				cards.get(cards.size() - 1).setVisibleSize(cards.get(cards.size() - 2).getSize());
		}
		return cards.remove(location);
	}
	public int getSize() {
		return cards.size();
	}
	public boolean getVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
