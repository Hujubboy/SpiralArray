package com.lge.lib;

public class Player {
    int mCurX = 0;
    int mCurY = 0;
    int mCount = 0;
    char mLoc = 'R';

    public boolean canMove(String[][] map) {
        try {
            switch (mLoc) {
                case 'R':
                    return map[mCurX + 1][mCurY].equals("-");
                case 'D':
                    return map[mCurX][mCurY + 1].equals("-");
                case 'L':
                    return map[mCurX - 1][mCurY].equals("-");
                case 'U':
                    return map[mCurX][mCurY - 1].equals("-");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public void move() {
        switch (mLoc) {
            case 'R':
                mCurX++;
                break;
            case 'D':
                mCurY++;
                break;
            case 'L':
                mCurX--;
                break;
            case 'U':
                mCurY--;
                break;
        }
        mCount++;
    }

    public void changeLoc() {
        switch (mLoc) {
            case 'R':
                mLoc = 'D';
                break;
            case 'D':
                mLoc = 'L';
                break;
            case 'L':
                mLoc = 'U';
                break;
            case 'U':
                mLoc = 'R';
                break;
        }
    }

    public void play(String[][] map) {
        if (canMove(map)) {
            move();
            map[mCurX][mCurY] = "" + mCount;
        } else {
            changeLoc();
            if (!canMove(map)) {
                return;
            }
        }
        if (mCount >= map.length * map[0].length) {
            return;
        }
        play(map);
    }
}
