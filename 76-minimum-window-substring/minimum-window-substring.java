class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (s.equals(t)) return s;
        if (n > m) return "";

        int[] m1 = new int[128];
        for (char ch : t.toCharArray()) m1[ch]++;

        int[] m2 = new int[128];
        int start = 0, end = 0, flag = 0, mini = Integer.MAX_VALUE;
        String ans = "";

        while (end < m) {
            char ch = s.charAt(end);
            if (m1[ch] > 0) {
                m2[ch]++;
                if (m2[ch] == m1[ch]) flag++;
            }

            while (flag == countNonZero(m1)) {
                if (end - start + 1 < mini) {
                    mini = end - start + 1;
                    ans = s.substring(start, end + 1);
                }
                char chStart = s.charAt(start);
                if (m1[chStart] > 0) {
                    m2[chStart]--;
                    if (m2[chStart] < m1[chStart]) flag--;
                }
                start++;
            }
            end++;
        }

        return ans;
    }

    private int countNonZero(int[] arr) {
        int cnt = 0;
        for (int i : arr) if (i > 0) cnt++;
        return cnt;
    }
}


// class Solution {
//     public String minWindow(String s, String t) {
//         int m=s.length();
//         int n = t.length();
//       if (s.equals(t)) return s;
//         if(n>m)return "";
//         HashMap<Character,Integer> m1=new HashMap<>();
//         for(Character ch : t.toCharArray()){
//             m1.put(ch,m1.getOrDefault(ch,0)+1);
//         }
//         int end=0;
//         int start=0;
//         HashMap<Character,Integer> m2=new HashMap<>();
//         int flag=0;
//         int mini=Integer.MAX_VALUE;
//         String ans="";
//         while(end<m){
//             Character ch = s.charAt(end);
//             if(m1.containsKey(ch)){
//                 m2.put(ch,m2.getOrDefault(ch,0)+1);
//                 if(m1.get(ch)==m2.get(ch)){
//                     flag++;
//                 }
                
//             }
            
//             while(start<=end && flag==m1.size()){
         
//                 if(end-start+1<mini){
//                     mini=end-start+1;
//                     ans=s.substring(start,end+1);
//                 }
//                 char chStart = s.charAt(start);
//                 if (m1.containsKey(chStart)) {
//                     m2.put(chStart, m2.get(chStart) - 1);
//                     if (m2.get(chStart) < m1.get(chStart)) {
//                         flag--;
//                     }
//                 }
//                 start++;
//             }
//             end++;
//         }
//         return ans;


//     }
// }