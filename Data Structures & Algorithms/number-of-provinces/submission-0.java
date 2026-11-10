class Solution {
    private void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        visited[node] = true;

        for(int it:graph.get(node)){
            if(!visited[it]){
                dfs(it,graph,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] == 1 && i != j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[V];
        int count = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(i,graph,visited);
            }
        }
        return count;
    }
}