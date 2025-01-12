package org.vikram.prototypepattern;

interface Prototype{
    Prototype cloneObj();
}

class Student implements Prototype{
    private final String name;
    private final int rollNo;

    private final int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                '}';
    }

    @Override
    public Prototype cloneObj() {
        return new Student(name, rollNo, age);
    }
}
public class Main {
    public static void main(String[] args) {
        Student originalObj = new Student("Vikram", 12, 26);

        Student cloneObj = (Student) originalObj.cloneObj();

        System.out.println(cloneObj);
    }
}
