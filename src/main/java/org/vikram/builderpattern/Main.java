package org.vikram.builderpattern;

class Student{
    // Mandatory
    private final String name;
    private final Integer rollNo;


    // Optional
    private final Integer age;
    private final String fatherName;
    private final String motherName;


    public Student(StudentBuilder builder) {
        this.name = builder.name;
        this.rollNo = builder.rollNo;
        this.age = builder.age;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
    }

    public static class StudentBuilder{
        // Mandatory
        private final String name;
        private final Integer rollNo;


        // Optional
        private Integer age;
        private String fatherName;
        private String motherName;

        // Builder constructor with mandatory fields
        public StudentBuilder(String name, Integer rollNo){
            this.name=name;
            this.rollNo=rollNo;
        }

        public StudentBuilder setAge(Integer age){
            this.age=age;
            return this;
        }

        public StudentBuilder setFatherName(String name){
            this.fatherName=name;
            return this;
        }

        public StudentBuilder setMotherName(String name){
            this.motherName=name;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public Integer getAge() {
        return age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Student.StudentBuilder builder = new Student.StudentBuilder("Vikram", 10);

        Student student = builder.setAge(5).setMotherName("Mummy").build();

        System.out.println(student);
    }
}
