package com.antoniosj.challanges;

import java.util.Stack;

public class BracketsChecker {

    public static boolean checkBrackets(String str)
    {
        if (str.isEmpty())
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
        {
            char current = str.charAt(i);
            if (current == '{' || current == '(' || current == '[')
            {
                stack.push(current);
            }


            if (current == '}' || current == ')' || current == ']')
            {
                if (stack.isEmpty())
                    return false;

                char last = stack.peek();
                if (    (current == '}' && last == '{') ||
                        (current == ')' && last == '(') ||
                        (current == ']' && last == '[') )
                    stack.pop();
                else
                    return false;
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
            BracketsChecker bracketsCheker = new BracketsChecker();
            System.out.println(bracketsCheker.checkBrackets("{(([]))()}"));
    }


}