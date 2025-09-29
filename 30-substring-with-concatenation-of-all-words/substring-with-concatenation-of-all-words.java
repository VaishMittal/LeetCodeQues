class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int len = words[0].length();
        int slen = s.length();
        int tlen = n * len;
        List<Integer> ans = new ArrayList<>();
        if (tlen > slen) return ans;

        HashMap<String, Integer> m1 = new HashMap<>();
        for (String str : words) {
            m1.put(str, m1.getOrDefault(str, 0) + 1);
        }

        for (int offset = 0; offset < len; offset++) {
            int start = offset;
            int i = offset;
            HashMap<String, Integer> m2 = new HashMap<>();

            while (i + len <= slen) {
                String temp = s.substring(i, i + len);
                i += len;

                if (!m1.containsKey(temp)) {
                    m2.clear();
                    start = i;
                    continue;
                }

                m2.put(temp, m2.getOrDefault(temp, 0) + 1);

                while (m2.get(temp) > m1.get(temp)) {
                    String t1 = s.substring(start, start + len);
                    m2.put(t1, m2.get(t1) - 1);
                    start += len;
                }

                if (i - start == tlen) {
                    ans.add(start);
                    String t2 = s.substring(start, start + len);
                    m2.put(t2, m2.get(t2) - 1);
                    start += len;
                }
            }
        }
        return ans;
    }
}


// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         int n=words.length;
//         int len=words[0].length();
//         int slen=s.length();
//         int tlen=n*len;
//         List<Integer> ans = new ArrayList<>();
//         if(tlen>slen)return ans;

//         HashMap<String,Integer> m1= new HashMap<>();
//         for(String str: words){
//             m1.put(str,m1.getOrDefault(str,0)+1);
//         }

//         int start=0;
//         int end=tlen;
//         int i=0;

//         while(end<slen){
//             HashMap<String,Integer> m2= new HashMap<>();
//             while(i<tlen+start){
//                 String temp=s.substring(i,i+len);
//                 i+=len;
//                 m2.put(temp,m1.getOrDefault(temp,0)+1);
//                 if(!m1.containsKey(temp)){
//                     start=i;
//                     end=start+tlen;
//                     m2.remove(temp);
//                 }
//                 while(m1.containsKey(temp) &&  m1.get(temp)<m2.get(temp)){
//                     String t1 = s.substring(start,start+len);
//                     m2.put(t1,m2.get(t1)-1);
//                     start+=len;
//                     end+=len;
//                 }
//             }
//             ans.add(start);
//             String t2=s.substring(start,start+len);
//             m2.put(t2,m2.get(t2)-1);
//             start+=len;
//             end+=len;
//         }
//         return ans;

//     }
// }