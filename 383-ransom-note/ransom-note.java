class Solution {
    public boolean canConstruct(String str1, String str2) {
        HashMap<Character,Integer> m1 = new HashMap<>();
        HashMap<Character,Integer> m2 = new HashMap<>();
        int n1=str1.length();
        int n2=str2.length();
        if(n1>n2)return false;
        for(int i=0;i<n1;i++){
            m1.put(str1.charAt(i),m1.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0;i<n2;i++){
            m2.put(str2.charAt(i),m2.getOrDefault(str2.charAt(i),0)+1);
        }
        for(int i=0;i<n1;i++){
             char ch = str1.charAt(i);
            //  if(!m2.containsKey(ch))return false;
            if(!m2.containsKey(ch) ||  m1.get(ch) > m2.get(ch)){
                return false;
            }
        }
        return true;
    }
}