class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree=new int[numCourses];
        ArrayList<Integer>[] map=new ArrayList[numCourses];
        int len=prerequisites.length;
        
        for(int i=0;i<numCourses;i++)
            map[i]=new ArrayList();
        
        for(int i=0;i<len;i++){
            degree[prerequisites[i][1]]++;
            map[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        Queue<Integer> que=new LinkedList();
        int cnt=0;
        
        for(int i=0;i<numCourses;i++)
            if(degree[i]==0) {que.add(i);cnt++;}
        if(que.isEmpty()) return false;
        
        while(!que.isEmpty()){
            int tmp=que.poll();
            int tmplen=map[tmp].size();
            for(int i=0;i<tmplen;i++){
                int pointer=map[tmp].get(i);
                degree[pointer]--;
                if(degree[pointer]==0){
                    cnt++;
                    que.add(pointer);
                }
            }
        }
        return cnt==numCourses;
    }
}