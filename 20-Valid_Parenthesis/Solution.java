class Solution {
    public boolean isValid(String s) {
        int curlyCount = 0;
        int openCount = 0;
        int squareCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (curlyCount == -1 || openCount == -1 || squareCount == -1) {
                return false;
            }

            char c = s.charAt(i);
            switch (c) {
                case '{':
                    curlyCount += 1;
                    break;
                case '}':
                    curlyCount -= 1;
                    break;
                case '[':
                    squareCount += 1;
                    break;
                case ']':
                    squareCount -= 1;
                    break;
                case '(':
                    openCount += 1;
                    break;
                case ')':
                    openCount -= 1;
                    break;
                default:
                    return false;
            }

            if (i == s.length() - 1) {
                if (openCount != 0 || curlyCount != 0 || squareCount != 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
