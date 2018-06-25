package com.koylubaevnt.csssr;

import java.util.*;
import java.util.stream.Collectors;

/*
Есть строка из нескольких слов. Все слова в ней разделены пробелом.
Нужно преобразовать строку в такую структуру данных, которая группирует слова по первой букве в слове.
Затем вывести группы, отсортированные в алфавитном порядке, содержащие более одного элемента.
Слова внутри группы нужно сортировать по убыванию количества символов; если число символов равное, то сортировать в алфавитном порядке.

Пример строки: String s = "сапог сарай арбуз болт бокс биржа"
Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]

Ждём ваш ответ в виде ссылки на опубликованный приватный Gist.
 */
public class Main {

    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа";
        int limitElement = 1;

        Map<Character, List<String>> result = convert(s, "\\s", limitElement);

        System.out.println(result);

    }

    /**
     * Функция преобразовывает строку {@code str} в структуру данных, которая группирует слова, полученные путем разбиения строки на подстроки с использованием регулярного выражения {@code separator}
     * по первой букве в слове и сортирует группы в алфавитном порядке, содержащие более {@code limitElement} элементов.
     * Слова внутри группы сортируются по убыванию количества символов; если число символов равное, то сортировать в алфавитном порядке.
     *
     * @param str           Cтрока из нескольких слов
     * @param separator     Регулярное выражение для разбивки строки на подстроки
     * @param limitElement  Количество элементов в группе, до которого группа не создается
     * @return              Струтура данных
     */
    public static Map<Character, List<String>> convert(String str, String separator, int limitElement) {
        Map<Character, List<String>> map = Arrays
                .stream(str.split(separator))
                .collect(Collectors.groupingBy(e -> e.charAt(0),
                        Collectors.collectingAndThen(
                                Collectors.toCollection(ArrayList::new), l->{ l.sort((String s1, String s2) -> {
                                    int res = s2.length() - s1.length();
                                    if (res == 0) {
                                        res = s1.compareTo(s2);
                                    }
                                    return res;
                                }); return l; } )
                ));


        final Map<Character, List<String>> result = map.entrySet().
                stream()
                .filter(e -> e.getValue().size() > limitElement)
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue(),
                        (oldValue, newValue) -> oldValue,
                        () -> new TreeMap<>(Character::compareTo)
                ));

        return result;
    }

}


