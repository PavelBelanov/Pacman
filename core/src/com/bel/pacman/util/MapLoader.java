package com.bel.pacman.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapLoader {
    public static String[] mapReader(String filePath) {
        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.ready()) {
                list.add(br.readLine());
            }
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        return list.toArray(new String[0]);
    }
}
