class Solution {
    public String reverseWords(String s) {
        s=s+' ';
        ArrayList<String> list = new ArrayList<>();
        int n=s.length();
        int i=0;
        while(i<n && s.charAt(i)==' ')i++;
        String word="";
        while(i<n){
            if(s.charAt(i)==' '){
                System.out.println(word);
                if(word.length()>0)list.add(word);
                word="";
            }else word+=s.charAt(i);
            i++;
        }
        String ans="";
        int len = list.size();
        System.out.print(len);
        for(int j=len-1;j>=0;j--){
            ans+=list.get(j);
            if(j!=0)ans+=' ';
        }
        return ans;

    }
}