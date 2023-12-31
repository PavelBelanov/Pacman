package com.bel.pacman;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {


    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("PacmanGame");
        config.setWindowIcon("D:\\git\\PacTest\\test\\assets\\pac-man (1).png");
        new Lwjgl3Application(new MyPacmanGame(), config);
    }
}
