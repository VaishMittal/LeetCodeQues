class Pair{
    String word;
    int steps;
    Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i=0;i<n;i++){
            set.add(wordList.get(i));
        }
        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String word=p.word;
            int steps=p.steps;
            if(word.equals(endWord))return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] wordar = word.toCharArray();
                    wordar[i]=ch;
                    String replaceWord= new String(wordar);
                    if(set.contains(replaceWord)){
                        set.remove(replaceWord);
                        q.add(new Pair(replaceWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}