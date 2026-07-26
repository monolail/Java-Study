import java.util.*;

public class Ex11_02 {
    public static void main(String[] args)  {
        Stack st = new Stack();
        Queue qe =  new LinkedList();

        st.push("0");
        st.push("1");
        st.push("2");
    
        
        qe.offer("0");
        qe.offer("1");
        qe.offer("2");
    
        System.out.println("Stack");
        while(!st.empty()){
            System.out.println(st.pop());
        }
    
        
        System.out.println("Queue");
        while(!qe.isEmpty()){
            System.out.println(qe.poll());
        }
    }
}
