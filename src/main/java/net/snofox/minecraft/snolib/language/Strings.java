package net.snofox.minecraft.snolib.language;

/**
 * Created by Josh on 2020-01-04
 */
public class Strings {
    public static String toTitleCase(final String input) {
        return toTitleCase(input, true);
    }
    /**
     * Takes the input and capitalizes each letter after a space
     * @param input
     * @param underscoreSpaces do underscores get replaced as spaces?
     * @return
     */
    public static String toTitleCase(String input, final boolean underscoreSpaces) {
        final StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        if(underscoreSpaces) input = input.replace('_', ' ');

        for (char c : input.toLowerCase().toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }
}
