class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] mytriangle = new int[triangle.length][triangle.length];
        for(int i = triangle.length-1 ; i >0 ; i--){
            for(int j = 0 ; j < triangle[i].length-1 ; j++){
                triangle[i-1][j] = triangle[i][j]>=triangle[i][j+1] ? triangle[i-1][j]+triangle[i][j] :  triangle[i-1][j]+triangle[i][j+1];
            }
        }
        return triangle[0][0];

    }
}
