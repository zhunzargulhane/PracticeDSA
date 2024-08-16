package datastructuresandalgorithms.practiceproblems;

public class PalindromeString {

    public static boolean isPalindrome(char[] data, int start, int endIndex, String originalData) {
        while (start < endIndex) { // 3 units
           /* char temp = data[endIndex];
            data[endIndex] = data[start];
            data[start] = temp;*/
            if (data[start] != data[endIndex])  // 3 units
                return false;  // 1 unit
            start++;  //3 unit
            endIndex--;  // 3 unit
        }
        return /*String.valueOf(data).equals(originalData)*/ true;
    }

    public static void main(String[] args) {
        String originalData = "taht";
        char[] ch = originalData.toCharArray();
        System.out.println(isPalindrome(ch, 0, ch.length - 1, originalData));
    }
}
