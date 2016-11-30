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
