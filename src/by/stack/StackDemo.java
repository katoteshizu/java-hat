package by.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Administrator on 12.01.2016.
 */
public class StackDemo {

    static void showpush(Stack st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    static void showempty(Stack st){
        System.out.println("empty stack?");
        if (st.empty())
            System.out.println("stack is empty");
        else System.out.println("stack is non-empty");

    }

    static void showpeek(Stack st){
        System.out.println("peek an element");
        Integer a = (Integer) st.peek();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    static void showsearch(Stack st, int a){
        System.out.println("search an element " + a);
        System.out.println("offset: " + st.search(a));
    }

    public static void main(String args[]) {
        Stack st = new Stack();
        System.out.println("stack: " + st);

        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);

        showempty(st);

        showpeek(st);

        showsearch(st, 42);

        showpop(st);
        showpop(st);
        showpop(st);

        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }
}
