class Solution {
  public int minPathSum(int[][] grid) {
    int[][] sol = new int[grid.length][grid[0].length];
    sol[0][0] = grid[0][0];
    for (int i = 1; i < sol.length; i++) {
      sol[i][0] = sol[i - 1][0] + grid[i][0];
    }
    for (int i = 1; i < sol[0].length; i++) {
      sol[0][i] = sol[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < sol.length; i++) {
      for (int j = 1; j < sol[0].length; j++) {
        if (sol[i - 1][j] < sol[i][j - 1]) {
          sol[i][j] = sol[i - 1][j] + grid[i][j];
        } else {
          sol[i][j] = sol[i][j - 1] + grid[i][j];
        }
      }
    }
    return sol[sol.length - 1][sol[0].length - 1];
  }
}