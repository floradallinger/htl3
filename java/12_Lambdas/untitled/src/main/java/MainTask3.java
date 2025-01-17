import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainTask3 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hallo", "2", "abc", "beizenfarbstoffe", "   h   ", "   ");
        System.out.println(strings);

        System.out.println(transformStrings(strings, i -> i.toUpperCase())); // als Großbuchstaben ausgeben
        System.out.println(transformStrings(strings, i -> i.toLowerCase())); // als Kleinbuchstaben ausgeben
        System.out.println(transformStrings(strings, i -> i += "!")); // Rufzeichen anhängen
        System.out.println(transformStrings(strings, i -> { // rückwärts ausgeben
            StringBuilder backwardsString = new StringBuilder();
            for (int j = i.length() -1; j >= 0; j--) {
                backwardsString.append(i.charAt(j));
            }
            return backwardsString.toString();
        }));

        System.out.println(transformStrings(strings, i -> i.trim())); // Leerzeichen entfernen




    }

    public static List<String> transformStrings(List<String> strings, Function<String, String> transformer){
        List<String> transformedStrings = new ArrayList();
        for (int i = 0; i < strings.size(); i++) {
            transformedStrings.add(transformer.apply(strings.get(i)));
        }
        return transformedStrings;
    }


}



