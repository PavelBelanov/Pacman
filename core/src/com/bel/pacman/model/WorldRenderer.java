package com.bel.pacman.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.bel.pacman.MyPacmanGame;
import com.bel.pacman.util.PacmanAnimation;

public class WorldRenderer {
    private MyPacmanGame myPacmanGame;
    private MazeRenderer mazeRenderer;
    private World world;
    private OrthographicCamera camera;
    private PacmanAnimation pacmanAnimation;
    private Animation<TextureRegion> pacmanFootage;
    private float stateTime;
    private int width, height;
    public static final int BLOCK_SIZE = 40;


    public WorldRenderer(MyPacmanGame myPacmanGame, World world) {
        this.myPacmanGame = myPacmanGame;
        this.world = world;
        width = world.getMaze().getWidth();
        height = world.getMaze().getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width * BLOCK_SIZE, height * BLOCK_SIZE);
        mazeRenderer = new MazeRenderer(myPacmanGame.batch, world.getMaze());
        stateTime = 0f;
        pacmanAnimation = new PacmanAnimation();
        pacmanFootage = pacmanAnimation.getPacRight();
    }


    public void update(float delta) {
        Pacman pacman = world.getPacman();
        pacman.update();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
        pacmanFootage = pacmanAnimation.getPacUp();
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            pacmanFootage = pacmanAnimation.getPacDown();
            pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            pacmanFootage = pacmanAnimation.getPacLeft();
            pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            pacmanFootage = pacmanAnimation.getPacRight();
            pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }

    }

    public void render(float delta) {
        mazeRenderer.render();
        SpriteBatch batch = myPacmanGame.batch;
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = pacmanFootage.getKeyFrame(stateTime,true);
        batch.begin();
        Vector2 pos = world.getPacman().getPosition();
        batch.draw(currentFrame, pos.x - WorldRenderer.BLOCK_SIZE / 2, world.getMaze().getHeight() * WorldRenderer.BLOCK_SIZE - pos.y - WorldRenderer.BLOCK_SIZE / 2);
        batch.end();
    }
}
