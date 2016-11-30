package GameClasses;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Deck {
	
	private ArrayList <Card> cards;
	private Vector2 position;

	public Deck(int suits, int numbers, Vector2 position) {
		cards = new ArrayList <Card>();
		this.position = position;
		for ( int i = 0; i < suits; i++ ) {
			for ( int ii = 0; ii < numbers; ii++ ) {
				cards.add(new Card(i,ii));
				cards.get(this.getSize()-1).setSize(new Vector2(140,210));
				cards.get(this.getSize()-1).setPosition(this.position);
			}
		}
	}
	
	public void shuffle () {
		Card temp;
		int tempIndex;
		Random rand = new Random();
		for ( int i = 0; i < cards.size(); i++ ) {
			temp = new Card(cards.get(i));
			temp.setSize(cards.get(i).getSize());
			temp.setPosition(cards.get(i).getPosition());
			tempIndex = rand.nextInt(cards.size());
			cards.set(i, cards.get(tempIndex));
			cards.set(tempIndex, temp);
		}
	}
	public ArrayList<Card> getCards() {
		return cards;
	}
	public Card getCard( int i ){
		return cards.get(i);
	}
	public Card drawCard(int number) {
		return cards.remove(cards.size()-1);
	}
	public void printDeck() {
		for (int i = 0; i < 52; i ++) 
			System.out.println(cards.get(i).getSuit() + ", " + cards.get(i).getNumber());
	}
	public int getSize() {
		return cards.size();
	}
}
