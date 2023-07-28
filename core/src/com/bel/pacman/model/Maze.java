package com.bel.pacman.model;

import com.bel.pacman.util.MapLoader;

import java.util.Arrays;

public class Maze {
    private String[] MAP;
    private int height;
    private int width;
    private boolean [][] hasDots;

    public Maze() {
        MAP = MapLoader.mapReader("D:\\git\\PacTest\\test\\assets\\maps\\test pacman field.txt");
        height = MAP.length;
        width = MAP[0].length();
        initDotData();
    }


    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String[] getMAP() {
        return MAP;
    }

    public void setMAP(String[] MAP) {
        this.MAP = MAP;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean[][] getHasDots() {
        return hasDots;
    }

    public void setHasDots(boolean[][] hasDots) {
        this.hasDots = hasDots;
    }

    public boolean hasWallAt(int i, int j) {
        return MAP[i].charAt(j) == '#';
    }

    public boolean hasDotAt(int i, int j) {
        return hasDots[i][j];
    }

    private void initDotData() {
        hasDots = new boolean[height][width];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                hasDots[i][j] = MAP[i].charAt(j) == '.';
            }
        }
    }

    public void removeDotAt(int i, int j) {
        hasDots[i][j] = false;
    }

    @Override
    public String toString() {
        return "Maze{" +
                "MAP=" + Arrays.toString(MAP) +
                ", height=" + height +
                ", width=" + width +
                ", hasDots=" + Arrays.toString(hasDots) +
                '}';
    }
}
