package com.bel.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MazeRenderer {
    private Maze maze;
    private SpriteBatch batch;
    private Texture wallImg;
    private Texture dotImg;

    public MazeRenderer(SpriteBatch batch, Maze maze) {
        this.maze = maze;
        this.batch = batch;
        wallImg = new Texture("D:\\git\\PacTest\\test\\assets\\blocImg.png");
        dotImg = new Texture("D:\\git\\PacTest\\test\\assets\\pillet.png");
    }

    public void render() {
        batch.begin();
        for(int i = 0; i < maze.getHeight(); i++) {
            for(int j = 0; j < maze.getWidth(); j++) {
                int x = j * WorldRenderer.BLOCK_SIZE;
                int y = maze.getHeight()*WorldRenderer.BLOCK_SIZE - (i * WorldRenderer.BLOCK_SIZE) - WorldRenderer.BLOCK_SIZE;

                if(maze.hasWallAt(i, j)) {
                    batch.draw(wallImg, x, y);
                } else if(maze.hasDotAt(i, j)) {
                    batch.draw(dotImg, x, y);
                }
            }
        }
        batch.end();
    }
}
