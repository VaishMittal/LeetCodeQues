class Solution {
    Map<String,Integer> map = new HashMap<>();
    String firstWord;
    List<List<String>> ans = new ArrayList<>();

    public void dfs(String word, List<String> seq){
        if(word.equals(firstWord)){
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] wordar=word.toCharArray();
                wordar[i]=ch;
                String replaceWord = new String(wordar);
                if(map.containsKey(replaceWord) && map.get(word)==map.get(replaceWord)+1 ){
                    seq.add(replaceWord);
                    dfs(replaceWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }

    }


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Map<String,Integer> map = new HashMap<>();
        firstWord=beginWord;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord,0);
        set.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.poll();
            if(word.equals(endWord))break;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] wordar=word.toCharArray();
                    wordar[i]=ch;
                    String replaceWord = new String(wordar);
                    if(set.contains(replaceWord)){
                        map.put(replaceWord,map.get(word)+1);
                        q.add(replaceWord);
                        set.remove(replaceWord);
                    }
                }
            }
        }
        //now we go from end to begin and do dfs call;
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;

    }
}












// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         Queue<List<String>> q = new LinkedList<>();
//         Set<String> set = new HashSet<>(wordList);
//         List<List<String>> ans = new ArrayList<>();
//         List<String> temp = new ArrayList<>();
//         temp.add(beginWord);
//         q.add(temp);
//         set.remove(beginWord);
//         int minpath=Integer.MAX_VALUE;

//         while(!q.isEmpty()){
//             int qsize=q.size();
//             List<String> levelLastword = new ArrayList<>();
//             for(int s=0;s<qsize;s++){
//                 List<String> temp1 = q.poll();
//                 if(temp1.size()>minpath)continue;
//                 String lastqWord = temp1.get(temp1.size()-1);//last word from queue arraylist
//                 if(lastqWord.equals(endWord)){
//                     minpath=temp1.size();
//                     ans.add(temp1);
//                     continue;
//                 }
//                 for(int i=0;i<lastqWord.length();i++){
//                     for(char ch ='a';ch<='z';ch++){
//                         char[] wordarr=lastqWord.toCharArray();
//                         wordarr[i]=ch;
//                         String replaceWord= new String(wordarr);

//                         if(set.contains(replaceWord)){
//                             List<String> temp2=new ArrayList<>(temp1);
//                             levelLastword.add(replaceWord);
//                             temp2.add(replaceWord);
//                             q.add(temp2);
//                         }
//                     }
//                 }
//             }    
//             for(int i=0;i<levelLastword.size();i++){
//                     set.remove(levelLastword.get(i));
//             }
//         }
//         return ans;
//     }
// }