package com.bel.pacman.model;


public class World {
    private Maze maze;
    private Pacman pacman;


    public World() {
        maze = new Maze();
        pacman = new Pacman(60, 60, maze);
    }

    public Pacman getPacman() {
        return pacman;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }
}
