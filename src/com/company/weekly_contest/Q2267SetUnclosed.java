package com.company.weekly_contest;

public class Q2267SetUnclosed {
    public static char[][] globalGrid;
    public static Boolean[][][] cache;
    public boolean hasValidPath(char[][] grid) {
        globalGrid = grid;
        cache = new Boolean[101][101][201];
        return dfs(new int[]{0,0}, 0);
    }

    public boolean dfs (int[] position, int unclosed) {
        int x = position[0];
        int y = position[1];

        //System.out.println("x: "+x + " y: " + y);
        if (x >= globalGrid.length || y >= globalGrid[0].length) {
            return false;
        }

        char currentChar = globalGrid[x][y];
        if (currentChar == '('){
            unclosed++;
        }
        if (currentChar == ')'){
            unclosed--;
        }
        if (unclosed < 0){
            return false;
        }
        if (cache[x][y][unclosed] != null){
            return cache[x][y][unclosed];
        }

        if (x == globalGrid.length-1 && y == globalGrid[0].length-1) {
            cache[x][y][unclosed] = unclosed == 0;
            return cache[x][y][unclosed];
        }
        var right = dfs(new int[]{x+1, y}, unclosed);
        var down = dfs(new int[]{x, y+1}, unclosed);
        cache[x][y][unclosed] = right || down;
        return cache[x][y][unclosed];


    }

}
