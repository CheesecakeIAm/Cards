package Helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class AssetLoader {
	
	public static Texture allCards;
	public static Texture back;
	
	public static void load () {
		allCards = new Texture(Gdx.files.internal("cards.png"));
//		for ( int i = 0; i < 4; i ++ ) {
//			cards.add(new ArrayList<TextureRegion>());
//			for ( int ii = 0; ii < 13; ii ++ ) {
//				cards.get(i).add(new TextureRegion(allCards, ii * 75, i * 115, 75, 115));
//				cards.get(i).get(ii).flip(true, false);
//			}
//		}
		
		back = new Texture(Gdx.files.internal("cardback.png"));
	}
	
	public static void dispose() {
		allCards.dispose();
		back.dispose();
	}
 }
