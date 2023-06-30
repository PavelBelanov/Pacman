package com.bel.pacman.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.bel.pacman.MyPacmanGame;

public class WorldRenderer {
    private MyPacmanGame myPacmanGame;
    private Texture pacmanImg;
    private MazeRenderer mazeRenderer;
    private World world;
    private OrthographicCamera camera;
    public static final int BLOCK_SIZE = 40;


    public WorldRenderer(MyPacmanGame myPacmanGame, World world) {
        this.myPacmanGame = myPacmanGame;
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, world.getMaze().getWidth()*BLOCK_SIZE, world.getMaze().getHeight()*BLOCK_SIZE);
        mazeRenderer = new MazeRenderer(myPacmanGame.batch, world.getMaze());
        pacmanImg = new Texture("pacmanAnimation/pacRound.png");

    }


    public void update(float delta) {
        Pacman pacman = world.getPacman();
        pacman.update();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            pacmanImg = new Texture("pacmanAnimation/pmUO.png");
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pacmanImg = new Texture("pacmanAnimation/pmDO.png");
            pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pacmanImg = new Texture("pacmanAnimation/pmLO.png");
            pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pacmanImg = new Texture("pacmanAnimation/pmRO.png");
            pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }

    }

    public void render(float delta) {
        mazeRenderer.render();
        SpriteBatch batch = myPacmanGame.batch;
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        Vector2 pos = world.getPacman().getPosition();
        batch.draw(pacmanImg, pos.x - WorldRenderer.BLOCK_SIZE / 2, world.getMaze().getHeight()*WorldRenderer.BLOCK_SIZE - pos.y - WorldRenderer.BLOCK_SIZE / 2);
        batch.end();
    }
}
