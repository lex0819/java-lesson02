// Вам дается строка S и целочисленный массив индексов int index[s.length].
// Напишите программу, которая перетасует символы в S таким образом,
// что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
//
// Пример: s = “cba”, index = [3,2,1] result “abc”

public class task1 {
    public static String shuffle(final String s, final int[] index){
        String res = "";

        for (int i = 0; i < index.length; i++) {
            res += s.charAt(index[i]-1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cba";
        int[] index = {3,2,1};

        System.out.println(shuffle(s, index));
    }
}