package ua.hillel.lesson11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class MyClass {
    public static void main(String[] args) throws IOException {

        //set();
        //map();
        //stack();
        //properties();
        List<Integer>integers=new ArrayList<>(List.of(1,2,3));
        for (Iterator<Integer>iterator=integers.iterator();iterator.hasNext();){
            Integer integer = iterator.next();
            if (integer==2){
                iterator.remove();
            }
        }

    }

    private static void properties() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("settings.properties"));
        String password = properties.getProperty("password");
        System.out.println(password);
    }

    private static void stack() {
        Stack<A> stack=new Stack<>();
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                stack.push(new A(i,j));

            }

        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }

    private static void map() {
        Map<A,Integer> map=new HashMap<>();
        A a=new A(3,1);
        A a1=new A(1,3);
        A a2 =new A(1,2);
        A a3 =new A(1,2);
        map.put(a,0);
        map.put(a1,1);
        map.put(a2,2);
        map.put(a3,3);
        for (A a4:map.keySet()) {
            System.out.println(a4);

        }
        for (Integer value:map.values()) {
            System.out.println(value);

        }
        for (Map.Entry<A,Integer>entry:map.entrySet()) {
            System.out.println(entry+ "    "+entry.getValue());

        }
    }

    private static void set() {
        Set<A> set = new TreeSet<>((o1, o2)-> {

                long a =( o1.getI())*Integer.MAX_VALUE + o1.getJ();
                int b = (o2.getJ())*Integer .MAX_VALUE+ o2.getJ();
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;

                }
                return 0;

        });


        set.add(new A(1,2));
        set.add(new A(1,3));
        set.add(new A(3,1));
        for (A a :set) {
            System.out.println(a);

        }
        System.out.println(set.size());
    }
}


    class A {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return i == a.i &&
                    j == a.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 17 * result + j;
            return result;

        }

        @Override
        public String toString() {
            return "A{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }







