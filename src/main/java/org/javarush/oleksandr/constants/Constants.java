package org.javarush.oleksandr.constants;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {
    public static final ArrayList<Character> ALPHABET_RU = new ArrayList<>(
            Arrays.asList(
                    'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к',
                    'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
                    'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
            )
    );

    public static final ArrayList<Character> ALPHABET_EN = new ArrayList<>(
            Arrays.asList(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
            )
    );
}
