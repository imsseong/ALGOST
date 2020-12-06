class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 3;
        int height = 3;
        int total = brown + yellow;

        for(width = 3; width < brown; width++) {
          height = total / width;
          if(width * height == total && width >= height && (width - 2) * (height -2) == yellow) {
            return new int[] {width, height};
          }
        }
        return null;
    }
}
