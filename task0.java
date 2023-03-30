// Посчитайте сколько драгоценных камней в куче обычных камней
// Пример:
// jewels = “aB”, stones = “aaaAbbbB”
// Результат в консоль ”a3B1”

public class task0 {
    public static int CounterChatInString(String data_string, char data_char){
        String str_char = "" + data_char;
        data_string = data_string.trim();
        int count = data_string.length() - data_string.replaceAll(str_char, "").length();
        return count;
    }

    public static String findJewelsInStones(String jewels, String stones) {
        int temp = 0;
        String res = "";

        for (int i = 0; i < jewels.length(); i++) {
            temp = CounterChatInString(stones, jewels.charAt(i));
            res += jewels.charAt(i) + Integer.toString(temp);
        }
        return res;
    }
    public static void main(String[] args){
        String jewels = "aB";
        String stones = "aaaAbbbB";

        String res = findJewelsInStones(jewels, stones);
        System.out.println(res);
    }
}