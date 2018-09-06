package com.lge.lib;

import java.util.Scanner;
/*
0, 0 exception
장애물 위치 exception
mLoc 이름
R,D,L,U 이름
blockSize 이름
mCount 예외상황 불필요
10 magic number
입력을 x, y 잘 못 받음
재귀 불필요*/

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
        for (int i = 0; i < mapSizeX; i++) {
            for (int j = 0; j < mapSizeY; j++) {
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

        for (int j = 0; j < mapSizeY; j++) {
            for (int i = 0; i < mapSizeX; i++) {
                try {
                    System.out.print(map[i][j] + "\t");
                } catch (NumberFormatException e) {
                    System.out.print(map[i][j] + "  ");
                }
            }
            System.out.print("\n");
        }
    }
}
