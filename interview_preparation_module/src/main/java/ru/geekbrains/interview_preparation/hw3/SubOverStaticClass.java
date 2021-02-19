package ru.geekbrains.interview_preparation.hw3;


//обычный нестатический класс наследуется от статического внутреннего
public class SubOverStaticClass extends TestClass.StaticClass {

    //переопределили конструктор через super
    @Override
    public void print() {
        super.print();
    }
}
