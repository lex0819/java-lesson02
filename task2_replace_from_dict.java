/* Task_2
На первой строке записывается натуральное число n - количество строчек в книге. Затем вводится n строк - строки книги. потом вводится натуральное число m - количество продуктов, на которые у человека аллергия. Потом вводится m строк - вида "продукт1 - продукт2", где продукт1 - продукт, на который у человека аллергия и продукт2 - продукт, на который следует заменить продукт1. Гарантируется что любой продукт состоит из 1 слова. название продуктов написаны строчными буквами. Гарантируется, что продукты, на которые нужно выполнить замену, не встречаются изначально в тексте.
Выходные данные
Замените все продукты в поваренной книге Васи и выведите их построчно на экран. На окончания не обращайте внимание. ВАЖНО!!! Если продукт, который следует заменить написан с большой буквы, то и замена тоже должна начинаться с большой буквы!
Sample Input:
2
Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.
Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.
3
арахис - колбаса
клубника - вишня
сгущенка - молоко
Sample Output:
Рецепт 1. Колбаса 100гр, мороженое 200гр. Возьмите колбаса и измелчите его. Посыпьте измельчённый колбаса на мороженое.
Рецепт 2. Вишня 100гр, молоко 3кг. Смешать, есть) Радоваться жизни.
* */

public class task2_replace_from_dict {
    public static String ReplacingWords(String str, String[] dict_key, String[] dict_value){
        String res = str;

        for (int i=0; i < dict_key.length; i++){
            res = res.replaceAll(dict_key[i], dict_value[i]);
        }
        return res;
    }
    public static void main(String[] args){
        String data_str01 = "Рецепт 1. Арахис 100гр, мороженое 200гр. Возьмите арахис и измелчите его. Посыпьте измельчённый арахис на мороженое.";
        String data_str02 = "Рецепт 2. Клубника 100гр, сгущенка 3кг. Смешать, есть) Радоваться жизни.";

        String[] dict_key = {"арахис", "Арахис", "клубника", "Клубника", "сгущенка", "Сгущенка"};
        String[] dict_value = {"колбаса", "Колбаса", "вишня", "Вишня", "молоко", "Молоко"};

        System.out.println(data_str01);
        System.out.println(ReplacingWords(data_str01, dict_key, dict_value));
        System.out.println();
        System.out.println(data_str02);
        System.out.println(ReplacingWords(data_str02, dict_key, dict_value));
    }
}