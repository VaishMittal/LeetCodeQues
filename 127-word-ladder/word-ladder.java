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
        for(String word : wordList){
            set.add(word);
        }
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String word=p.word;
            int step=p.steps;
            if(word.equals(endWord))return step;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch <= 'z' ;ch++){
                    char[] wordar= word.toCharArray();
                    wordar[i]=ch;
                    String newword=new String(wordar);
                    if(set.contains(newword)){
                        set.remove(newword);
                        q.add(new Pair(newword,step+1));
                    }
                }
            }
        }
        return 0;
    }
}