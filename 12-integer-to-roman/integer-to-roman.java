class Solution {
    public String intToRoman(int num) {
        int thous = num/1000;
        num=num%1000;
        int hund = num/100;
        num=num%100;
        int ten = num/10;
        int one = num%10;
        String ans = Thousands(thous)+Hundreds(hund)+Tens(ten)+Ones(one);
        return ans;
    }
    public static String Ones(int x){
        switch(x){
            case 0:return "";
            case 1 :return "I";
            case 2 :return "II";
            case 3 :return "III";
            case 4 :return "IV";
            case 5 :return "V"; 
            case 6 :return "VI"; 
            case 7 :return "VII";
            case 8 :return "VIII";
            case 9 :return "IX";
            default:return "";
        }
    }
     public static String Tens(int x){
        switch(x){
            case 0:return "";
            case 1 :return "X";
            case 2 :return "XX";
            case 3 :return "XXX";
            case 4 :return "XL";
            case 5 :return "L"; 
            case 6 :return "LX"; 
            case 7 :return "LXX";
            case 8 :return "LXXX";
            case 9 :return "XC";
            default:return "";
        }
    }    public static String Hundreds(int x){
        switch(x){
            case 0:return "";
            case 1 :return "C";
            case 2 :return "CC";
            case 3 :return "CCC";
            case 4 :return "CD";
            case 5 :return "D"; 
            case 6 :return "DC"; 
            case 7 :return "DCC";
            case 8 :return "DCCC";
            case 9 :return "CM";
            default:return "";
        }
    }
     public static String Thousands(int x){
        switch(x){
            case 0:return "";
            case 1 :return "M";
            case 2 :return "MM";
            case 3 :return "MMM";
            default:return "";
        }
    }   
}