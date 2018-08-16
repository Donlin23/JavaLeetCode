package ForOffer;

import java.util.Stack;

/**
 * @Author: Donlin
 * @Date: Created in 10:21 2018/8/15
 * @Version: 1.0
 * @Description: 面试题9: 用两个栈实现队列
 */
public class TwoStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.add(node);
    }

    public int pop() throws Exception {
        if (stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        if (stack2.empty())
            throw new Exception("queue is empty.");
        return stack2.pop();
    }
}
