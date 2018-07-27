class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = 0;
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(': stack[top++] = ')';break;
                case '[': stack[top++] = ']';break;
                case '{': stack[top++] = '}';break;
                default: if (top == 0 || c != stack[--top]) return false;
            }
        }
        return top == 0;
    }
}