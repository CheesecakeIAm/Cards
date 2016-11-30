package Table;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import GameClasses.Card;
import Helpers.AssetLoader;

public class Renderer {
	
	private Table myTable;
	private OrthographicCamera cam;
	private SpriteBatch batcher;
	private float gameWidth;
	private float gameHeight;
	private float cardWidth;
	private float cardHeight;

	public Renderer(Table table) {
		myTable = table;
		gameWidth = myTable.getSize().x;
		gameHeight = myTable.getSize().y;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, gameWidth, gameHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        
        cardWidth = myTable.getDeck().getCard(0).getSize().x;
        cardHeight = myTable.getDeck().getCard(0).getSize().y;
	}
	
	public void render() {
		
		Gdx.gl.glClearColor(51 / 255.0f, 102 / 255.0f, 255 / 255.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
		batcher.begin();
		
		//Color c = batcher.getColor();
		
		batcher.enableBlending();
		
		//batcher.draw(AssetLoader.back, gameWidth/2-cardWidth/2, gameHeight/2-cardHeight/2, cardWidth, cardHeight ); //center deck
		
		for ( int i = 0; i < myTable.getDeck().getCards().size(); i ++ ) //the deck
			batcher.draw(myTable.getDeck().getCards().get(i).getTexture(), //gets card texture
					myTable.getDeck().getCard(i).getPosition().x, //gets the x position of card
					myTable.getDeck().getCard(i).getPosition().y, //gets the y position of card
					myTable.getDeck().getCard(i).getSize().x,
					myTable.getDeck().getCard(i).getSize().y);
		
		for ( int i = 0; i < 4; i ++ )  //4 piles adjacent to deck
			for ( int ii = 0; ii < myTable.getPile(i).getSize(); ii ++ ) 
				batcher.draw(myTable.getPile(i).getCard(ii).getTexture(), 
						myTable.getPile(i).getCard(ii).getPosition().x, 
						myTable.getPile(i).getCard(ii).getPosition().y, 
						myTable.getPile(i).getCard(ii).getSize().x, 
						myTable.getPile(i).getCard(ii).getSize().y);
						   
		for ( int i = 0; i < myTable.getHands().size(); i ++ ) { //cycles through each hand
			for ( int ii = 0; ii < myTable.getHand(i).getSize(); ii++ ) { //cycles through each card per hand
					batcher.draw(myTable.getHand(i).getCard(ii).getTexture(),
							myTable.getHand(i).getCard(ii).getPosition().x,
							myTable.getHand(i).getCard(ii).getPosition().y,
							myTable.getHand(i).getCard(ii).getSize().x,
							myTable.getHand(i).getCard(ii).getSize().y);
			}
		}

		batcher.end();
	}
}
