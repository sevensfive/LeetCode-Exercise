class Solution {
    int k=0;
     int[] res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i]=new ArrayList();
        for(int i=0;i<prerequisites.length;i++)
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        boolean[] v=new boolean[numCourses];
        boolean[] f=new boolean[numCourses];
        res=new int[numCourses];
      
        for(int i=0;i<numCourses;i++){
            if(!dfs(f,v,graph,i)) return new int[0];
        }
        return res;
    }
    
    private boolean dfs(boolean[] f,boolean[] v,ArrayList<Integer>[] graph,int i){
        if(f[i]) return true;
        if(v[i]) return false;
        
        v[i]=true;
        for(int j=0;j<graph[i].size();j++){
            int pointer=graph[i].get(j);
            if(!dfs(f,v,graph,pointer)) return false;
        }
        v[i]=false;
        f[i]=true;
        res[k++]=i;
        return true;
        
    } 
    
    
}