package sdu.edu.leetcode.easy;

public class CountandSay {

    public String countAndSay(int n) {
        if(n == 1) return "1";
        String str = "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < n - 1;i++) {
            int count = 1;
            for (int j = 0; j < str.length() - 1; j++) {
                if(str.charAt(j) == str.charAt(j+1)){
                    count++;
                }else{
                    sb.append(count + "" + str.charAt(j));
                    count = 1;
                }
            }
            sb.append(count + "" + str.charAt(str.length() - 1));
            str = sb.toString();
            sb.setLength(0);
        }
        return str;
    }

    public String countAndSay2(int n){
        String str = "1";
        for(int i = 1;i < n;i++){
            str = count(str);
        }
        return str;
    }

    public String count(String str){
        int count = 1;
        char pre = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i < str.length();i++){
            if(str.charAt(i) == pre){
                count++;
            }else{
                sb.append(count + "" + pre);
                count = 1;
                pre = str.charAt(i);
            }
        }
        return sb.append(count).append(pre).toString();
    }


    public static void main(String[] args) {
        System.out.println(new CountandSay().countAndSay(4));
    }

}
