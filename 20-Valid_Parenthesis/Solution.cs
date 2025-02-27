public class Solution {
    public bool IsValid(string s) {
        int curlyCount = 0;
        int openCount = 0;
        int squareCount = 0;

        for (int i = 0; i < s.Length; i++){
            if (curlyCount == -1 || openCount == -1 || squareCount == -1){
                return false;
            }
       
            char c = s[i];
            switch (c) {
                case '[': ++squareCount; break;
                case ']': --squareCount; break; 
                case '(': ++openCount; break; 
                case ')': --openCount; break; 
                case '{': ++curlyCount; break; 
                case '}': --curlyCount; break; 
                default: return false;
            }

            if (i == s.Length - 1){
                if (squareCount != 0 || openCount != 0 || curlyCount != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
