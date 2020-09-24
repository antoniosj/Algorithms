package com.company;

import java.util.Stack;
/*
 * O algoritmo de 2 stack de dijkstra serve para expressões aritméticas. Cada expressão precisa ser cercado por
 * parênteses pela simplicidade.
 * Ex: ( ( 2 + 1 ) * ( 1 + 2 ) ) => lembrar dos espaços pra facilitar o split. 
 *
 */

public class DijkstraTwoStack {
    Stack<String> operationStack;
    Stack<Double> valueStack;

    public DijkstraTwoStack() {
        operationStack = new Stack<>();
        valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        String[] arr = expression.split(" ");

        for (String s : arr) {

            switch (s) {
                case "(":
                    break;
                case "+":
                case "*":
                    operationStack.push(s);
                    break;
                case ")":
                    String operation = operationStack.pop();

                    if ("+".equals(operation)) {
                        valueStack.push(valueStack.pop()+valueStack.pop());
                    } else if ("*".equals(operation)) {
                        valueStack.push(valueStack.pop()*valueStack.pop());
                    }
                    break;
                default:
                    valueStack.push(Double.parseDouble(s));
            }

        }
        System.out.println(valueStack.pop());
    }
}
