package Lesson_5;

public class Staffer {
    private String name;
    private String post;
    private String mail;
    private String phone;
    private int wages;
    private int age;

    public Staffer(){
        this.name = "Empty";
        this.post = "Empty";
        this.mail = "Empty";
        this.phone = "0-000-000-00-00";
        this.wages = 0;
        this.age = 0;
    }

    public Staffer(String name, String post, String mail, String phone, int wages, int age){
        this.name = name;
        this.post = post;
        this.mail = mail;
        this.phone = phone;
        this.wages = wages;
        this.age = age;
    }

    public void getInfo(){
        System.out.println("*********************");
        System.out.printf("ФИО: %s \nДолжность: %s \nПочта: %s \nТелефон: %s \nЗП: %d \nВозраст: %d \n",
                name, post, mail, phone, wages, age);
    }
    public int getAge(){
        return this.age;
    }
}
