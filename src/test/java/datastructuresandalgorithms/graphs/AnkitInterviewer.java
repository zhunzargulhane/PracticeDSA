package datastructuresandalgorithms.graphs;

public class AnkitInterviewer {

    //O/P = "ym emn si rznuhz";
    public static void main(String[] args) {
        AnkitInterviewer an = new AnkitInterviewer();
        String s="my name is zhunzar";
        String[] array=s.split("\\s");
        StringBuffer sb = new StringBuffer();
        for(String word: array){
            sb.append(an.reverse(0,word.length()-1,word)+" ");
        }
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='a')
                sb1.append(sb.charAt(i));
        }
        System.out.println(sb1.deleteCharAt(sb1.length()-1));
    }

    public String reverse(int start,int end,String s){
        char[] charArray = s.toCharArray();
        while(start<end){
            char temp=charArray[end];
            charArray[end]=charArray[start];
            charArray[start]=temp;
            start++;
            end--;
        }
        return String.valueOf(charArray);
    }
}
