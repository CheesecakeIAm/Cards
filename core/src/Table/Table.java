package Table;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import GameClasses.Card;
import GameClasses.Deck;
import GameClasses.Hand;
import GameClasses.Pile;

public class Table {
	private Vector2 size;
	private Card model;
	private Deck deck;
	private ArrayList <Hand> hands;
	private ArrayList <Pile> piles;
	private boolean drawing;
//	private ArrayList <Vector2> pileLocations;
	
	public Table() {
		size = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		
		model = new Card(0,0);
		model.setSize(new Vector2(140,210));
		
		deck = new Deck(4, 13, new Vector2(size.x/2-model.getSize().x/2, size.y/2-model.getSize().y/2 ));
		
		hands = new ArrayList <Hand>();
		for ( int i = 0; i < 2; i ++ ){
			hands.add(new Hand());
		}
		hands.get(0).setVisible(true);

		piles = new ArrayList <Pile>();
		for ( int i = 0; i < 4; i ++ ){
			piles.add(new Pile());
		}

//		pileLocations = new ArrayList <Vector2>();
//		pileLocations.add(new Vector2(size.x/2-3*model.getSize().x/2-model.getSize().x/4, size.y/2-model.getSize().y/2));
//		pileLocations.add(new Vector2(size.x/2-model.getSize().x/2, size.y/2-3*model.getSize().y/2-model.getSize().x/4));
//		pileLocations.add(new Vector2(size.x/2+model.getSize().x/2+model.getSize().x/4, size.y/2-model.getSize().y/2));
//		pileLocations.add(new Vector2(size.x/2-model.getSize().x/2, size.y/2+model.getSize().y/2+model.getSize().x/4));
		
		deck.shuffle();
		
		for ( int i = 0; i < deck.getSize(); i ++ )
			deck.getCard(i).setVisible(false);
		
		for ( int i = 0; i < 2; i ++ )
			this.deal(7,i);

		for ( int i = 0; i < 4; i ++ )
			this.makePile(i);

		this.drawing = false;
	}
	
	public void update(float delta) {
		size = new Vector2(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	public Vector2 getSize() {
		return size;
	}
	public void setSize(int x, int y) {
		this.size = new Vector2(x,y);
	}
	public Deck getDeck() {
		return deck;
	}
	public Hand getHand(int hand) {
		return hands.get(hand);
	}
	public ArrayList<Hand> getHands() {
		return hands;
	}
	public Pile getPile(int pile) {
		return piles.get(pile);
	}

	public void deal (int number, int hand) {
		for ( int i = 0; i < number; i ++ ) {
			hands.get(hand).addCard(deck.drawCard(1));
			switch (hand) {
			case 0:
				hands.get(hand).getCard(i).setPosition(new Vector2(
						size.x/2+model.getSize().x/4*(i-number/2)-model.getSize().x/2,
						size.y-model.getSize().y/2));
				break;
			case 1:
				hands.get(hand).getCard(i).setPosition(new Vector2(
						size.x/2+model.getSize().x/4*(i-number/2)-model.getSize().x/2,
						0-model.getSize().y/2));
				break;
			}
		}
		for ( int i = 0; i < number - 1; i ++ ) {
			hands.get(hand).getCard(i).setVisibleSize(new Vector2(model.getSize().x/4, model.getSize().y));
		}
		hands.get(hand).getCard(number-1).setVisibleSize(model.getSize());
	}

	public void makePile(int pile) {
		switch (pile) {
		case 0:
			piles.get(pile).setPosition(new Vector2(
					size.x/2-7/4f*model.getSize().x,
					size.y/2-1/2f*model.getSize().y));
			break;
		case 1:
			piles.get(pile).setPosition(new Vector2(
					size.x/2-1/2f*model.getSize().x,
					size.y/2-3/2f*model.getSize().y-1/4f*model.getSize().x));
			break;
		case 2:
			piles.get(pile).setPosition(new Vector2(
					size.x/2+3/4f*model.getSize().x,
					size.y/2-1/2f*model.getSize().y));
			break;
		case 3:
			piles.get(pile).setPosition(new Vector2(
					size.x/2-1/2f*model.getSize().x,
					size.y/2+1/2f*model.getSize().y+1/4f*model.getSize().x));
			break;
		}
		piles.get(pile).addCard(deck.getCards().remove(deck.getSize()-1));
		piles.get(pile).getCard(0).setVisible(true);
	}

	public void pressed(int mouseX, int mouseY) {
		for (int i = 0; i < hands.get(0).getSize(); i ++) {
			if ( mouseX >= hands.get(0).getCard(i).getPosition().x &&
					mouseX <= hands.get(0).getCard(i).getPosition().x + hands.get(0).getCard(i).getVisibleSize().x &&
					mouseY >= hands.get(0).getCard(i).getPosition().y &&
					mouseY <= hands.get(0).getCard(i).getPosition().y + hands.get(0).getCard(i).getVisibleSize().y) {
				hands.get(0).getCard(i).setDragged(true);
				hands.get(0).getCard(i).setTempPosition(hands.get(0).getCard(i).getPosition());
				hands.get(0).getCard(i).setSpace(new Vector2(
						mouseX - hands.get(0).getCard(i).getTempPosition().x,
						mouseY - hands.get(0).getCard(i).getTempPosition().y));
			}
		}
		if ( mouseX >= deck.getPosition().x && mouseX <= deck.getPosition().x + model.getSize().x &&
				mouseY >= deck.getPosition().y && mouseY <= deck.getPosition().y + model.getSize().y )
			drawing = true;
	}
	
	public void dragging(int mouseX, int mouseY) {
		for (int i = 0; i < hands.get(0).getSize(); i++) {
			if(hands.get(0).getCard(i).getDragged()) {
				hands.get(0).getCard(i).setPosition(new Vector2(
						mouseX - hands.get(0).getCard(i).getSpace().x,
						mouseY - hands.get(0).getCard(i).getSpace().y));
			}
		}
		if (!(mouseX >= deck.getPosition().x && mouseX <= deck.getPosition().x + model.getSize().x &&
				mouseY >= deck.getPosition().y && mouseY <= deck.getPosition().y + model.getSize().y) )
			drawing = false;
	}

	public void released(int mouseX, int mouseY) {
		for (int i = 0; i < hands.get(0).getSize(); i++) {
			if (hands.get(0).getCard(i).getDragged()) {
				hands.get(0).getCard(i).setDragged(false);
				for (int ii = 0; ii < piles.size(); ii++) {
					if (hands.get(0).getCard(i).getPosition().x >= piles.get(ii).getPosition().x - model.getSize().x/2 &&
							hands.get(0).getCard(i).getPosition().x <= piles.get(ii).getPosition().x + model.getSize().x/2 &&
							hands.get(0).getCard(i).getPosition().y >= piles.get(ii).getPosition().y - model.getSize().y/2 &&
							hands.get(0).getCard(i).getPosition().y <= piles.get(ii).getPosition().y + model.getSize().y/2 ||
							mouseX >= piles.get(ii).getPosition().x && mouseX <= piles.get(ii).getPosition().x + model.getSize().x &&
							mouseY >= piles.get(ii).getPosition().y && mouseY <= piles.get(ii).getPosition().y + model.getSize().y ) {
						if (piles.get(ii).getMoveLegality(hands.get(0).getCard(i))) {
							piles.get(ii).addCard(hands.get(0).takeCard(i));
							break;
						}
					} else {
						hands.get(0).getCard(i).setPosition(hands.get(0).getCard(i).getTempPosition());
					}
				}
			}
		}
		if ( mouseX >= deck.getPosition().x && mouseX <= deck.getPosition().x + model.getSize().x &&
				mouseY >= deck.getPosition().y && mouseY <= deck.getPosition().y + model.getSize().y &&
				drawing == true)
			hands.get(0).addCard(deck.drawCard(1));
	}
}
