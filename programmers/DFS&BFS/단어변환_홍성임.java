import java.util.*;
import java.util.stream.*;

class Word {
    String name;
    int count;

    public Word(String name, int count) {
        this.name = name;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(Arrays.stream(words).filter(s -> s.equals(target)).count() == 0) return 0;

        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();

        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()) {
            Word word = queue.poll();

            if(word.name.equals(target)) return word.count;

            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && isConvert(word.name, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], word.count + 1));
                }
            }
        }
        return 0;
    }

    public boolean isConvert(String word, String convertWord) {
        int count = 0;
        for(int i = 0; i < convertWord.length(); i++) {
            if(word.charAt(i) != convertWord.charAt(i)) count++;
            if(count > 1) return false;
        }
        return true;
    }
}
