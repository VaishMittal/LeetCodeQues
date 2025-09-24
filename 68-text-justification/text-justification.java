class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        int n = words.length;
        List<String> list = new ArrayList<>();
        int left, word, last;
        while (i < n) {
            int curlen = 0;
            String ans = "";
            word = 1;
            last = 0;
            ans += words[i];
            curlen += words[i].length();
            i++;
            while (i < n && (curlen + words[i].length() + 1) <= maxWidth) {
                ans += " ";
                ans += words[i];
                curlen += words[i].length() + 1;
                word++;
                i++;
            }
            if (i == n) last = 1;
            left = maxWidth - curlen;
            ans = addSpace(ans, left, word, last);
            list.add(ans);
        }
        return list;
    }

    public static String addSpace(String ans, int left, int word, int last) {
        if (last == 1 || word == 1) {
            while (left > 0) {
                ans += " ";
                left--;
            }
        } else {
            String[] arr = ans.split(" ");
            int gaps = word - 1;
            int totalSpaces = left + gaps; 
            int minSpace = totalSpaces / gaps;
            int extra = totalSpaces % gaps;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j]);
                if (j < gaps) {
                    for (int s = 0; s < minSpace; s++) sb.append(" ");
                    if (j < extra) sb.append(" ");
                }
            }
            ans = sb.toString();
        }
        return ans;
    }
}