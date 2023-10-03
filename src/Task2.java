import java.util.Arrays;
import java.util.Comparator;

class SortByUpperCaseLetters {
    public static void main(String[] args) {
        String[] strings = {"Shin", "ENTER", "YouTube", "Warden", "R6"};

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int count1 = countUpperCaseLetters(str1);
                int count2 = countUpperCaseLetters(str2);

                return Integer.compare(count1, count2);
            }

            private int countUpperCaseLetters(String str) {
                int count = 0;
                for (char c : str.toCharArray()) {
                    if (Character.isUpperCase(c)) {
                        count++;
                    }
                }
                return count;
            }
        });
        for (String str : strings) {
            System.out.println(str);
        }
    }
}