package GameClasses;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Pile {
	
	private ArrayList <Card> cards;
	private Vector2 position;
	
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
	public void hovered(Card model, Vector2 size) {
		for ( int i = 0; i < this.getSize(); i ++ ) 
			cards.get(i).setPosition(new Vector2(
					size.x/2+model.getSize().x/4*(i-cards.size()/2)-model.getSize().x/2,
					position.y));
	}
	public void reset() {
		
	}

}
