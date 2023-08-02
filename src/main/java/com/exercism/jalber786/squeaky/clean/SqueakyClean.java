package com.exercism.jalber786.squeaky.clean;

class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < identifier.length(); i++) {
            char currChar = identifier.charAt(i);
            if (currChar == ' ') {
                stringBuilder.append('_');
            } else if (Character.isISOControl(currChar)) {
                stringBuilder.append("CTRL");
            } else if ((currChar == '-')) {
                char nextChar = identifier.charAt(i + 1);
                if (!isntLetter(nextChar)) {
                    stringBuilder.append(Character.toUpperCase(identifier.charAt(i + 1)));
                    i++;
                }
            } else if ((isntLetter(currChar)) || ((Character.toString(currChar)).matches("[α-ω]"))) {
                /*
                 * An empty if used to be a code smell as it add complexity to do nothing.
                 * Some options that you have here could be or rethink the condition to make it the last else
                 * or, if you consider this is condition is pretty clear, use the `continue` sentence to follow to the
                 * next for iteration
                 */
            } else {
                stringBuilder.append(currChar);
            }
        }

        return stringBuilder.toString();
    }

    /*
    I like this method as you are extracting a complex validation to a specific method and the name of the method
    is helping to know what we are doing.
    Just a comment, the convention used to be naming the methods starting with is or isNot, so in this case could be
    `isNotALetter`
     */
    private static boolean isntLetter(char c) {

        /*
            You are using matches method, which returns a boolean. If mathes return true, you leave the value variable
            to true. If returns false, you change the value variable to false, so, basically, you are storing the return
            of the matches method.

            This practice could end in unnecessary code, making necessary more lines, more variables, more processing...
            Something you could do is
            boolean value = (Character.toString(c)).matches("[^\\p{L}\\p{P}\\p{Z}]");
            return value;

            Or, even cleaner, return just the matches result
            return (Character.toString(c)).matches("[^\\p{L}\\p{P}\\p{Z}]");
         */

        boolean value = false;
        if ((Character.toString(c)).matches("[^\\p{L}\\p{P}\\p{Z}]")) {
            value = true;
        }

        return value;
    }
}
