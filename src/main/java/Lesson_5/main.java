package Lesson_5;
/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class main {

    public static void main(String[] args) {
        Staffer[] team = new Staffer[5];
        team[0] = new Staffer("Ветюгов Никита Сергеевич", "Программист", "@mail.ru", "8-888-888-88-88", 100_000, 23);
        team[1] = new Staffer("Иванов Иван Иванович", "Инженер-конструктор", "@mail.ru", "9-999-999-99-99", 50_000, 52);
        team[2] = new Staffer("Пупкин Михаил Владимирович", "Менеджер", "@mail.ru", "5-555-555-55-55", 45_000, 41);
        team[3] = new Staffer("Афанасьев Афанас Афанасьевич", "HR", "@mail.ru", "7-777-777-77-77", 70_000, 36);
        team[4] = new Staffer("Долгополов Низколоб Январович", "Стежёр", "@mail.ru", "6-666-666-66-66", 30_000, 43);
        for (int i = 0; i < team.length; i++) {
            if (team[i].getAge() > 40) {
                team[i].getInfo();
            }
        }
    }
}