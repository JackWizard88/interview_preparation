package ru.geekbrains.interveiw_preparation.hw3;

public class TestClass {
    //просто класс не может быть статическим
    public int number;

    public TestClass(int number) {
        this.number = number;
    }
    //статический внутренний класс
    public static class StaticClass {
        public long longNumber;
        //через this обращается сам к себе
        public void print() {
            System.out.println(this.longNumber);
        }
    }
    //Потомок наследуется от статического внутреннего класса и обращается к родителю через super
    public static class StaticClass1 extends StaticClass {
        @Override
        public void print() {
            super.print();
        }
    }
}
