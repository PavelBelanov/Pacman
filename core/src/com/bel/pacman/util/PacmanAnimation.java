package com.bel.pacman.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bel.pacman.model.WorldRenderer;


public class PacmanAnimation {
    private Texture pacDown;
    private Texture pacLeft;
    private Texture pacRight;
    private Texture pacUp;
    private final float ANIMATION_SPEED = 0.1f;


    public PacmanAnimation() {
        pacDown = new Texture("assets/pacmanAnimation/pacDown.png");
        pacLeft = new Texture("assets/pacmanAnimation/pacLeft.png");
        pacRight = new Texture("assets/pacmanAnimation/pacRight.png");
        pacUp = new Texture("assets/pacmanAnimation/pacUp.png");
    }


    public Animation<TextureRegion> getPacDown() {
        TextureRegion[] animation = filling(pacDown);
        return new Animation<>(ANIMATION_SPEED, animation);
    }


    public Animation<TextureRegion> getPacLeft() {
        TextureRegion[] animation = filling(pacLeft);
        return new Animation<>(ANIMATION_SPEED, animation);
    }


    public Animation<TextureRegion> getPacRight() {
        TextureRegion[] animation = filling(pacRight);
        return new Animation<>(ANIMATION_SPEED, animation);
    }


    public Animation<TextureRegion> getPacUp() {
        TextureRegion[] animation = filling(pacUp);
        return new Animation<>(ANIMATION_SPEED, animation);
    }

    private TextureRegion[] filling(Texture texture){
        TextureRegion[][] region = TextureRegion.split(texture, WorldRenderer.BLOCK_SIZE, WorldRenderer.BLOCK_SIZE);
        TextureRegion[] animationArray = new TextureRegion[5];
        int index = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < animationArray.length; j++) {
                animationArray[index++] = region[i][j];
            }
        }
        return animationArray;
    }


}
