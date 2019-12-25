package collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    /*private*/ double[] stack_;
    /*private*/ int top_;

    public Stack(){
        stack_ = null;
        top_ = -1;
    }
    public Stack(int num){
        stack_ = new double[num];
        top_ = -1;
    }

    public void add(double d){
        if(stack_ == null){
            stack_ = new double[1];
        }

        if(top_ + 2 >= stack_.length){
            //System.out.println("top == length");
            double [] stackCopy = Arrays.copyOf(stack_, stack_.length * 2);
            stack_ = stackCopy;
        }

        stack_[++ top_] = d;
        //System.out.println("add, Top is " + top_);
    }

    public double pop(){
        if(empty()){
            throw new EmptyStackException();
            //System.err.println("POP ERROR, STACK IS EMPTY");
            //return 0;
        }
        else {
            //System.out.println("pop, Top is " + top_);
            return stack_[top_--];
        }
    }

    public double peek(){
        if(empty()){
            throw new EmptyStackException();
            //System.err.println("PEEK ERROR, STACK IS EMPTY");
            //return 0;
        }
        else {
            //System.out.println("peek, Top is " + top_);
            return stack_[top_];
        }
    }

    public boolean empty(){
        return (top_ == -1);
    }

    public String toString(){
        return String.valueOf(top_ + 1);
    }
}
