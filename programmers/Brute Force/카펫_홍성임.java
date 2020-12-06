class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 3;
        int height = 3;
        int total = brown + yellow;
        while(true) {
            if(total % width == 0) {
                height = total / width;
                if(width >= height && (width - 2) * (height -2) == yellow) {
                    break;
                } else {
                    width++;
                }
            } else {
                width++;
            }
        }
        int[] answer = {width, height};
        return answer;
    }
}
