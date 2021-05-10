package com.github.biyanwen.stackandqueue;

import java.util.Stack;

/**
 * 【题目】实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 【要求】1.pop、push、getMin操作的时间复杂度都是O（1）。
 * 2.设计的栈类型可以使用现成的栈结构。
 *
 * @Author byw
 * @Date 2021/5/10 22:40
 */
public class Demo1 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(1);
    }


    static class MyStack {
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();

        public void push(Integer integer) {
            stackData.push(integer);
            stackMinPushData(integer);
        }

        public Integer pop() {
            if (stackData.empty()) {
                throw new RuntimeException("stack is empty");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public Integer getMin() {
            if (stackMin.empty()) {
                throw new RuntimeException("stack is empty");
            }
            return stackMin.peek();
        }

        private void stackMinPushData(Integer integer) {
            if (stackMin.empty()) {
                stackMin.push(integer);
                return;
            }
            Integer currentMin = stackMin.peek();
            if (currentMin < integer) {
                stackMin.push(currentMin);
            } else {
                stackMin.push(integer);
            }
        }

    }
}
