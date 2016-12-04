package com.cds.interview.stackandqueue;

import java.util.Stack;

/**
 * Created by cds on 12/3/16 09:13.
 */
public class MinStack {

    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= getMin()) {
            stackMin.push(newNum);
        }

        stackData.push(newNum);
    }

    public int pop() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }

        int value = this.stackData.pop();

        if (value == getMin()) {
            stackMin.pop();
        }

        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty!");
        }

        return this.stackMin.peek();
    }


    @Override
    public String toString() {
        return "MinStack{" +
                "stackData=" + stackData +
                ", stackMin=" + stackMin +
                '}';
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(1);

        minStack.push(1);

        minStack.push(2);

        System.out.println(minStack);
    }
}
