class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> m1 = new HashMap<>();
         HashMap<Character,Character> m2 = new HashMap<>();
   

        if(s==t)return true;
        if(s.length()!=t.length())return false;

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2=t.charAt(i);
            if(m1.containsKey(ch1)){
                if(m1.get(ch1)!=ch2){
                    return false;
                }
            }else m1.put(ch1,ch2);
        }
        for(int i=0;i<s.length();i++){
            char ch1 = t.charAt(i);
            char ch2=s.charAt(i);
            if(m2.containsKey(ch1)){
                if(m2.get(ch1)!=ch2){
                    return false;
                }
            }else m2.put(ch1,ch2);
        }
        return true;

    }
}
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         HashMap<Character,Integer> m1 = new HashMap<>();
//         HashMap<Character,Integer> m2 = new HashMap<>();
//         if(s==t)return true;
//         if(s.length()!=t.length())return false;
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             m1.put(ch,m1.getOrDefault(ch,0)+1);
//         }
//         int n1=m1.size();

//         for(int i=0;i<t.length();i++){
//             char ch = t.charAt(i);
//             m2.put(ch,m2.getOrDefault(ch,0)+1);
//         }
//         int n2=m2.size();
//         if(n1!=n2)return false;
//         for(int i=0;i<s.length();i++){
//             char ch1 = s.charAt(i);
//             char ch2 = t.charAt(i);
//             if(m1.get(ch1)!=m2.get(ch2)){
//                 return false;
//             }
//         }
//         return true;

//     }
// }