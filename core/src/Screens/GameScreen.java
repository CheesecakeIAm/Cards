package Screens;

import Table.Renderer;
import Table.Table;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen{
	
	private Table table;
    private Renderer renderer;

    public GameScreen() {
        table = new Table();
        renderer = new Renderer(table);
        Gdx.input.setInputProcessor(new Helpers.Input(table));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        table.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
