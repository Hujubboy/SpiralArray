package com.lge.lib;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        String[][] map;
        int mapSizeX;
        int mapSizeY;
        int blockSize;

        Scanner scan = new Scanner(System.in);
        System.out.println("array size X : ");
        mapSizeX = scan.nextInt();
        System.out.println("array size Y : ");
        mapSizeY = scan.nextInt();
        System.out.println("block size : ");
        blockSize = scan.nextInt();

        map = new String[mapSizeX][mapSizeY];
        for(int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j <mapSizeY; j++) {
                map[i][j] = "-";
            }
        }

        for (int i = 0; i < blockSize; i++) {
            int blockX;
            int blockY;
            System.out.println("block loc X : ");
            blockX = scan.nextInt();
            System.out.println("block loc Y : ");
            blockY = scan.nextInt();

            map[blockX][blockY] = "X";
        }

        map[0][0] = "0";
        Player player = new Player();
        player.play(map);

        for(int j = 0; j < mapSizeX; j++) {
            for (int i = 0; i <mapSizeY; i++) {
                try {
                    System.out.print(map[i][j] + (Integer.parseInt(map[i][j]) < 10 ? "  " : " "));
                }catch (NumberFormatException e) {
                    System.out.print(map[i][j] + "  ");
                }
            }
            System.out.print("\n");
        }
    }
}
