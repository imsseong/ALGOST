import java.util.ArrayList;
class Solution {
    ArrayList<String> list = new ArrayList<String>();
	String route = "";
	public boolean check(String begin,String target) {
		int num = 0;
		for(int i=0;i<begin.length();i++) {
			if(begin.charAt(i)!=target.charAt(i)) num++;
		}
		if(num==1) return true;
		else return false;
	}

	public void dfs(String begin, String target, String[] words,boolean[] visit,int idx) {
        System.out.println("idx:"+idx);
		if(idx==words.length+1) {
            System.out.println("no");
            return;
        }
		if(begin.equals(target)) {
            System.out.println("yes");
			list.add(route);
			return;
		}

		for(int i=0;i<words.length;i++) {
			if(!visit[i] && check(begin,words[i])) {
				visit[i] = true;
				String r = route;
				route+= " " + words[i];
				dfs(words[i],target,words,visit,idx+1);
				visit[i] = false;
				route = r;
			}
		}
		return;
	}
	public int solution(String begin, String target, String[] words) {
		boolean visit[] = new boolean [words.length];
		for(int i=0;i<words.length;i++) {
			if(check(begin,words[i])) {
                System.out.println("i:"+i);
				route = words[i];
				visit[i]= true;
				dfs(words[i],target,words,visit,0);
				visit[i]= false;
			}
		}
		int min = 100;
        if(list.size()==0) return 0;
		for(String arr: list) {
			int num = 0;
			while(true) {
				if(arr.indexOf(' ')!=-1) {
					num++;
					arr = arr.substring(arr.indexOf(' ')+1);
				}
				else break;
			}
			if(num<min) min = num+1;
		}

        return min;
        }
}
