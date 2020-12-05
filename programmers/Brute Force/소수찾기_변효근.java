import java.util.HashSet;
class Solution {
    public static void permutation(String prefix, String str, HashSet<Object> set) {
        int n = str.length();
        if(!prefix.equals("")) { // prefix가 빈문자가 아닐 경우 set에 추가시킴.
           set.add(Integer.valueOf(prefix)); //스트링을 Interger로 변환
        }

        for (int i = 0; i < n; i++){
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
          // 재귀를 통해 숫자로 만들 수 있는 모든 경우의 수를 구함.
        }

    }
    public int solution(String numbers) {
    int answer = 0;
    int num = 10000000;
		int cnt = 0;
		int cnt2 = 0;
		var prime = new HashSet<>();
    // 소수를 넣을 HashSet
    var set = new HashSet<>();
    // 숫자로 만들 수 있는 모든 경우의 수를 담는 HashSet
		boolean check[] = new boolean[10000000];
		check[0]= check[1]= true;
    // 에라토스테네스의 체
    // 10000000에서 소수를 구한다 가정하였을 경우
    // 소수로 모든 수를 체크하는 것이다.
    // 2로 1000000에 있는 모든 수를 나누어보고 체크를 하는것
    // 그 이후에는 3으로 그 다음엔 5로....

    for(int i=2; i<num; i++) {
      if(check[i]==true) continue;
			prime.add(i);
			for(int j=2; j*i<=num; j++) {
					if(j*i<num) check[j*i] = true;
				}
			}
     	permutation("", numbers, set);
      //순열을 통하여 모든 경우의 수를 계산
        while(set.iterator().hasNext()){
            // set에서 하나의 값을 가져오고 prime넘버인지를
            // HashSet의 contains 함수를 이용하여
            // 비교
            int a = (int) set.iterator().next();
            set.remove(a);
            if(prime.contains(a)){
                answer++;
            }
        }
        return answer;
    }
}
