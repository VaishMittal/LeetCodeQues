class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> mailToNode = new HashMap<>();
        // ex in map (abc@gmail.com,0) // we represent names as node 0,1,2...
        int n =accounts.size();

        DisjointSet ds = new DisjointSet(n);

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(mailToNode.containsKey(mail)==false){
                    mailToNode.put(mail,i);
                }else{
                    ds.unionByRank(i,mailToNode.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();
        for(int i=0;i<n;i++){
            mergedMail.add(new ArrayList<>());
        }

        for(Map.Entry<String,Integer> e : mailToNode.entrySet()){
            String mail=e.getKey();
            int node=ds.findUPar(e.getValue());
            mergedMail.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0) continue;

            Collections.sort(mergedMail.get(i));

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0)); // name
            temp.addAll(mergedMail.get(i));

            ans.add(temp);
        }

        return ans;


    }
}


class DisjointSet{
    int[] rank,parent;
    
    DisjointSet(int n){
        rank=new int[n];
        parent=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    
    int findUPar(int node){
        if(node==parent[node])return node;
        return parent[node]=findUPar(parent[node]);
    }
    
    void unionByRank(int u, int v){
        int uUPar=findUPar(u);
        int vUPar=findUPar(v);
        if(uUPar==vUPar)return;
        
        if(rank[uUPar]>rank[vUPar]){
            parent[vUPar]=uUPar;
        }
        else if(rank[uUPar]<rank[vUPar]){
            parent[uUPar]=vUPar;
        }else{
            parent[uUPar]=vUPar;
            rank[vUPar]++;
        }
    }
}