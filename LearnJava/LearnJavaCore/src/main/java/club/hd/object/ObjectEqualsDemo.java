package com.lujiahao.object;


import java.util.HashMap;
import java.util.Map;

public class ObjectEqualsDemo {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan");
        Person p2 = new Person("lisi");

        Map<Person, Integer> map = new HashMap<Person, Integer>();
        map.put(p1, 1);
        map.put(p2, 2);
        Person p3 = new Person("zhangsan");

        System.out.println(map.get(p3));

        System.out.println(map.get(new Person("zhangsan")));
    }
}


class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name.equals(((Person)obj).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
