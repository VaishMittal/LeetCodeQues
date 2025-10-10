class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> m = new HashMap<>();
        for (String s : strs) {
            if (s != null) {
                String sortedString = sortString(s);
                if (!m.containsKey(sortedString)) {
                    m.put(sortedString, new ArrayList<>());
                }
                m.get(sortedString).add(s);
            }
        }
        return new ArrayList<>(m.values());
    }

    private String sortString(String input) {
        char[] arr = input.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

// class Solution {
//     public List<List<String>> groupAnagrams(String[] arr) {
//         List<List<String>> ans = new ArrayList<>();
//         int n=arr.length;
//         if(n==0 )return ans;
        
//         // if (n==1){
//         //     ans.add(arr[0]);
//         //     return ans;
//         // } 

//         Map<String ,Integer> m1=new HashMap<>();
//         Map<String ,Integer> m2=new HashMap<>();
//         int c=1;
//         for(int i=0;i<n;i++){
//             char[] arr2=arr[i].toCharArray();
//             Arrays.sort(arr2);
//             String str =new String(arr2);
//             if(!m2.containsKey(str)){
//                 m2.put(str,c);
//                 c++;
//             }
//             m1.put(arr[i],m2.get(str));
//         }
//         c--;
//         while(c>0){
//             List<String> inner = new ArrayList<>();
//             for(int i=0;i<n;i++){
//                 if(m1.get(arr[i])==c){
//                     inner.add(arr[i]);
//                 }
//             }
//             ans.add(inner);
//             c--;
//         }
//         return ans;
//     }
// }
