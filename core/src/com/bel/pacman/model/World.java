package com.bel.pacman.model;

import com.bel.pacman.MyPacmanGame;

public class World {
    private Pacman pacman;
    private MyPacmanGame myPacmanGame;
    private Maze maze;


    public World(MyPacmanGame myPacmanGame) {
        maze = new Maze();
        this.myPacmanGame = myPacmanGame;
        pacman = new Pacman(60, 60, maze);
    }

    public Pacman getPacman() {
        return pacman;
    }

    public Maze getMaze() {
        return maze;
    }

}
