package com.bel.pacman.model;

import com.bel.pacman.util.MapLoader;

public class Maze {
    private String[] MAP = MapLoader.mapReader("assets/maps/My game field.txt");

    private int height;
    private int width;
    private boolean [][] hasDots;

    public Maze() {
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
}
