package GameClasses;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import Helpers.AssetLoader;

public class Card {
	
	private int suit;
	private int number;
	private Vector2 position;
	private Vector2 tempPosition;
	private Vector2 size;
	private Vector2 visibleSize;
	private TextureRegion cardTexture;
	private TextureRegion cardBack;
	private boolean visible;
	private boolean dragged;
	
	public Card ( int suit, int number ) {
		this.suit = suit;
		this.number = number;
		cardTexture = new TextureRegion(AssetLoader.allCards, 
										number * 75, suit * 115, 75, 115);
		cardTexture.flip(false, true);

		cardBack = new TextureRegion(AssetLoader.back);
		visible = true;

		dragged = false;
	}
	
	public Card ( Card card ) {
		suit = card.suit;
		number = card.number;
		position = card.position;
		tempPosition = card.tempPosition;
		size = card.size;
		visibleSize = card.visibleSize;
		cardTexture = card.cardTexture;
		cardBack = card.cardBack;
		visible = card.visible;
		dragged = card.dragged;
	}
	
	public Vector2 getSize() {
		return size;
	}
	public void setSize(Vector2 size) {
		this.size = size;
	}
	public Vector2 getVisibleSize() {
		return visibleSize;
	}
	public void setVisibleSize( Vector2 visibleSize ) {
		this.visibleSize = visibleSize;
	}

	public int getSuit() {
		return suit;
	}
	public int getNumber() {
		return number;
	}

	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 pos) {
		position = pos;
	}
	public Vector2 getTempPosition() {
		return tempPosition;
	}
	public void setTempPosition(Vector2 pos) {
		tempPosition = pos;
	}

	public TextureRegion getTexture() {
		if (visible)
			return cardTexture;
		else
			return cardBack;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean getVisible() {
		return visible;
	}

	public void setDragged(boolean dragged) {
		this.dragged = dragged;
		if(dragged == true) {
			tempPosition = position;

		}
		if(dragged == false) {


		}
	}
	public boolean getDragged() {
		return dragged;
	}
}