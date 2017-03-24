package GameClasses;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Pile {
	
	private ArrayList <Card> cards;
	private Vector2 position;
	private boolean hovered;
	
	public Pile() {
		
		cards = new ArrayList <Card>();
		
	}
	public ArrayList <Card> getCards() {
		return cards;
	}
	public void setPosition(Vector2 pos) {
		position = new Vector2(pos.x,pos.y);
	}
	public Card getCard( int i ){
		return cards.get(i);
	}
	public void addCard(Card card) {
		card.setPosition(position);
		cards.add(card);
	}
	public Card takeCard(int location) { 
		return cards.remove(location);
	}
	public int getSize() {
		return cards.size();
	}
	public Vector2 getPosition() {
		return position;
	}
	public void hovered(int pileNumber) {
		switch (pileNumber) {
			case 0: //left
				for (int i = 0; i < this.getSize(); i++)
					cards.get(i).setPosition(new Vector2(position.x - 1/4f*cards.get(i).getSize().x*(this.getSize() - 1 - i), position.y));
				break;
			case 1: //up
				for (int i = 0; i < this.getSize(); i++)
					cards.get(i).setPosition(new Vector2(position.x + 1/4f*cards.get(i).getSize().x*(1/2f + i - this.getSize()/2f), position.y));
				break;
			case 2: //right
				for (int i = 0; i < this.getSize(); i++)
					cards.get(i).setPosition(new Vector2((int)(position.x + 1/4f*cards.get(i).getSize().x*(i)), position.y));
				break;
			case 3: //down
				for (int i = 0; i < this.getSize(); i++)
					cards.get(i).setPosition(new Vector2(position.x + 1/4f*cards.get(i).getSize().x*(1/2f + i - this.getSize()/2f), position.y));
				break;
		}

	}
	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}
	public boolean getHovered() {
		return hovered;
	}
	public void reset() {
		
	}
	public boolean getMoveLegality(Card newCard) {
		//System.out.println(newCard.getNumber()+", "+cards.get(cards.size()-1).getNumber());
		if (newCard.getNumber() == cards.get(cards.size()-1).getNumber() - 1) {
			if ((newCard.getSuit() - cards.get(cards.size()-1).getSuit() + 4) % 2 == 1 ) {
				return true;
			}
		}
		return false;
	}

}
