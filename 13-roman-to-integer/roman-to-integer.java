class Solution {
    public int romanToInt(String s) {
        int n =s.length();
        int sum=0;
        int i=1;
        if(n==1)return romanVal(s.charAt(0));
        while(i<n){
            Character cur=s.charAt(i);
            Character prev = s.charAt(i-1);
            int curVal = romanVal(cur);
            int prevVal = romanVal(prev);
            if(i==n-1 && (curVal==prevVal || prevVal>curVal) ){
                sum+=(curVal+prevVal);break;
            }
            if(curVal>prevVal){
                sum+=(curVal-prevVal);
                if(i==n-2){
                    sum+=romanVal(s.charAt(n-1));
                }
                i++;
            }
            if(curVal<=prevVal){
                sum+=prevVal;
            }
            i++;
            
        }
        return sum;

    }
      public static  int romanVal(Character x){
            switch(x){
                case 'I':return 1;
                case 'V':return 5;
                case 'X':return 10;
                case 'L':return 50;
                case 'C':return 100;
                case 'D':return 500;
                case 'M':return 1000;
                default:return 0;
            }
        }
}