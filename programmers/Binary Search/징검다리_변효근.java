public static int solution(int distance, int[] rocks, int n) {
		int answer=0;
	    Arrays.sort(rocks);
	    int left=0;
	    int right=distance;
	    int mid=0;
	    while (left<=right){
	    	mid=(left+right)/2;
	    	int prv=0;
	    	int removeCnt=0;
	    	for(int i=0; i<rocks.length; i++){
	    		if(rocks[i]-prv < mid){ removeCnt++; if(removeCnt>n){break;}}
	    		else{ prv=rocks[i]; }
	    	}
	    	System.out.println("remove :"  +removeCnt);
	        if(removeCnt>n){right=mid-1;}
	    	else{answer=answer>mid? answer:mid; left=mid+1;}
	    }
	    return answer;
	}
