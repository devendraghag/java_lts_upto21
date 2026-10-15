package com.example.comparator;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Comparator39LocaleCollatorComparator {
    public static void main(String[] args) {
        List<String> words = List.of("�clair", "Eclair", "Zebra", "Apple");
        Collator collator = Collator.getInstance(Locale.forLanguageTag("fr-FR"));
        Comparator<String> localeOrder = collator::compare;
        // Collator applies locale-specific rules; output can vary with JDK locale data/provider.
        System.out.println(words.stream().sorted(localeOrder).toList());
    }
}
