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
                if (!shouldIgnoreChar(nextChar)) {
                    stringBuilder.append(Character.toUpperCase(identifier.charAt(i + 1)));
                    i++;
                }
            } else if (!shouldIgnoreChar(currChar)) {
                stringBuilder.append(currChar);
            }
        }

        return stringBuilder.toString();
    }

    private static boolean shouldIgnoreChar(char c) {
        return !Character.isLetter(c) || ((Character.toString(c)).matches("[α-ω]"));
    }
}
