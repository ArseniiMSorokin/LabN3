import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Создание класса Subscriber (Абонент)
class Subscriber {
    // Имя абонента
    private final String firstName;
    // Фамилия абонента
    private final String lastName;
    // Возраст абонента
    private final int age;
    // Номер телефона абонента
    private String phoneNumber;

    // Конструктор с параметрами класса Subscriber
    public Subscriber(String firstName, String lastName, int age, String phoneNumber) {
        // Инициализация имени
        this.firstName = firstName;
        // Инициализация фамилии
        this.lastName = lastName;
        // Инициализация возраста
        this.age = age;
        // Инициализация номера телефона
        this.phoneNumber = phoneNumber;
    }

    // Геттер возраста
    public int getAge() {
        return age;
    }

    // Геттер имени
    public String getFirstName() {
        return firstName;
    }

    // Геттер фамилии
    public String getLastName() {
        return lastName;
    }

    // Геттер номера телефона
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Сеттер номера телефона (8) номер
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Метод для удобного отображения информации об объекте класса Subscriber
    @Override
    public String toString() {
        return "Имя: " + firstName + " Фамилия: " + lastName + " Возраст: " + age + ". Номер телефона: " + phoneNumber;
    }
}

// Создание класса Телефонного справочника
class TelephoneBook {
    // Список абонентов хранящий объекты класса Subscriber
    private final List<Subscriber> subscribers;

    // Конструктор класса TelephoneBook
    public TelephoneBook() {
        subscribers = new ArrayList<>();
    }

    // Метод добавление абонента (объекта класса Subscriber)
    public void addSubscriber(Subscriber subscriber) {
        // Перебираем список subscribers на существование абонента с таким же номером телефона как и у subAlready и добавлять/не добавлять объект в список
        for (Subscriber subAlready : subscribers) {
            // Если найден такой объект subAlready, что при использовании геттера getPhoneNumber его значение совпадёт со значением геттера у передаваемого
            // в метод объекта, то выводится ошибка, так как номер телефона единственен в списке
            if (subAlready.getPhoneNumber().equals(subscriber.getPhoneNumber())) {
                System.out.println("Ошибка добавления: Номер телефона уже существует");
                // Завершение метода пустым return'ом
                return;
            }
            // Если найден такой объект subAlready, что значения возвращаемые геттерами имени, фамилии и возраста равны значениям для передаваемого объекта,
            // то выводится ошибка, так как может быть только один объект с Именем && Фамилией && Возрастом
            if (subAlready.getFirstName().equals(subscriber.getFirstName()) && subAlready.getLastName().equals(subscriber.getLastName()) && subAlready.getAge() == subscriber.getAge()) {
                System.out.println("Ошибка: абонент с таким именем, фамилией и возрастом уже существует");
                // Завершение метода пустым return'ом
                return;
            }
        }
        // Если условия выше не выполнились, то объект добавляется в список
        subscribers.add(subscriber);
    }

    // Метод отображения списка абонентов
    public void showSubscribers() {
        // Сортировка абонентов по возрастанию статическим методом Comparator.comparing по значению извлекаемого у объекта Subscriber при вызове метода getFirstName
        subscribers.sort(Comparator.comparing(Subscriber::getFirstName));
        System.out.println("Список абонентов: ");
        // Перебор всех объектов класса Subscriber в списке subscribers и вывод их на экран
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }

    // Метод поиска номера телефона по имени и фамилии
    public void findPhoneNumNameAndLastname(String firstName, String lastName) {
        // Создание списка для найденных абонентов
        List<Subscriber> foundsubs = new ArrayList<>();
        // Перебор объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Сравнение значений при вызове метода для subscriber с передаваемыми значениями, если совпадают, то добавляем в список
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                // Добавление subscriber в список
                foundsubs.add(subscriber);
            }
        }
        // Сортировка списка в порядке возрастания возраста
        subscribers.sort(Comparator.comparing(Subscriber::getAge));
        // Если пустой вывести ошибку, иначе вывести всех найденных людей
        if (foundsubs.isEmpty()) {
            System.out.println("Абонент с именем " + firstName + " и фамилией " + lastName + " не найден");
        } else {
            System.out.println("Номера телефонов для " + firstName + " " + lastName);
            for (Subscriber subscriber : foundsubs) {
                System.out.println(subscriber.getPhoneNumber());
            }
        }
    }

    // Метод поиска номера телефона по имени или фамилии
    // То же самое что и предыдущий метод, только условие с И заменяется на ИЛИ
    public void findPhoneNumNameOrLastname(String name) {
        List<Subscriber> foundsubs = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFirstName().equals(name) || subscriber.getLastName().equals(name)) {
                foundsubs.add(subscriber);
            }
        }
        subscribers.sort(Comparator.comparing(Subscriber::getAge));
        if (foundsubs.isEmpty()) {
            System.out.println("Абонент с именем/фамилией " + name + " не найден");
        } else {
            System.out.println("Номера телефонов для " + name);
            for (Subscriber subscriber : foundsubs) {
                System.out.println(subscriber.getPhoneNumber());
            }
        }
    }

    // Метод для удаления по имени и фамилии
    public void removeByName(String firstName, String lastName) {
        // Создания списка, который будет хранить абонентов подлежащих удалению
        List<Subscriber> foundsubs = new ArrayList<>();

        // Перебор списка на предмет совпадения возвращаемых значений геттеров и передаваемых переменных
        for (Subscriber subscriber : subscribers) {
            // Если равны, то добавляем в список
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                foundsubs.add(subscriber);
            }
        }
        // Если длина списка равна 1, то удаляем первый объект в списке (getFirst), иначе выводим ошибку: слишком много записей для удаления
        if (foundsubs.size() == 1) {
            subscribers.remove(foundsubs.getFirst());
            System.out.println("Абонент " + firstName + " " + lastName + " успешно удалён");
        } else {
            if (foundsubs.size() > 1) {
                System.out.println("Ошибка удаления. Найдено " + foundsubs.size() + " записи(ей)");
            } else {
                System.out.println("Абонент не найден");
            }
        }
    }

    // Метод удаления по номеру телефона
    public void removeByPhone(String phoneNumber) {
        // Объявление переменной и инициализация null
        Subscriber needsub = null;
        // Перебор объектов класса Subscriber из списка subscribers
        for (Subscriber subscriber : subscribers) {
            // Если телефонный номер subscriber совпадает с передаваемым в метод значением, присваиваем needsub найденный объект и завершаем цикл так как номер единственен
            if (subscriber.getPhoneNumber().equals(phoneNumber)) {
                needsub = subscriber;
                break;
            }
        }
        // Проверка на присваивание needsub значения другого объекта
        if (needsub != null) {
            // Если выполняется, то удалить из списка subscribers объект needsub
            subscribers.remove(needsub);
            System.out.println("Абонент с номером " + phoneNumber + " удалён");
        } else {
            System.out.println("Абонент с номером " + phoneNumber + " не найден");
        }
    }

    // Метод удаления абонентов младше определённого возраста
    public void removeUndAge(int age) {
        // Список абонентов, которых нужно будет удалить
        List<Subscriber> subsToRemove = new ArrayList<>();
        // Перебирание всех объектов в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Если значение от геттера меньше передаваемой переменной добавляем в список
            if (subscriber.getAge() < age) {
                subsToRemove.add(subscriber);
            }
        }
        // Если список не пустой, то удаляем все элементы из списка subsToRemove в списке subscribers
        if (!subsToRemove.isEmpty()) {
            subscribers.removeAll(subsToRemove);
            System.out.println("Удалено " + subsToRemove.size() + " абонент(ов) младше " + age + " года(лет)");
        } else {
            System.out.println("Абоненты младше " + age + " лет не найдены");
        }
    }

    // Метод для замены номера телефона по имени и фамилии
    public void replacePhoneNum(String firstName, String lastName, String phoneNumber) {
        // Список для абонентов подходящих под условия
        List<Subscriber> foundsubs = new ArrayList<>();
        // Перебор всех объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Если совпадают имя и фамилия добавляем в список
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                foundsubs.add(subscriber);
            }
        }
        // Если длина списка подходящих под условия абонентов равна 1, то первому элементу списка foundsubs(и единственному)
        // присваивается значение передаваемое в метод при помощи сеттера
        // Иначе выводится ошибка, что абонент не найден или человек с таким именем и фамилией не один в списке
        if (foundsubs.size() == 1) {
            foundsubs.getFirst().setPhoneNumber(phoneNumber);
            System.out.println("Номер телефона для " + firstName + " " + lastName + " успешно изменён");
        } else {
            if (foundsubs.size() > 1) {
                System.out.println("Ошибка изменения номера, найдено " + foundsubs.size() + " записей");
            } else {
                System.out.println("Абонент не найден");
            }
        }
    }

    // Метод для проверки наличия абонентов
    public void isAnyCommon() {
        // Список (String) для хранения фамилий
        List<String> lastNames = new ArrayList<>();
        // Переменная isFound с начальным значением false
        boolean isFound = false;
        // Перебор всех объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Переменная типа String для хранения фамилии текущего объекта
            String lastName = subscriber.getLastName();
            // Если в списке с фамилиями уже есть такой же объект, то выводится
            // сообщение о нахождении однофамильцев, isFound меняется на true и цикл завершается
            if (lastNames.contains(lastName)) {
                System.out.println("Однофамильцы найдены");
                isFound = true;
                break;
            }
            lastNames.add(lastName);
        }
        // Если isFound имеет значение false, то выводится сообщение о том, что однофамильцы не найдены
        if (!isFound) {
            System.out.println("Однофамильцы не найдены");
        }
    }

    // Метод для вычисления среднего возраста людей, у которых в номере телефона больше чётных цифр чем нечётных
    public void averageEvenDigits() {
        // Общий возраст
        int totalAge = 0;
        // Число абонентов
        int count = 0;
        // Перебор всех объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Присваивание переменной значения геттера
            String phoneNumber = subscriber.getPhoneNumber();
            // Счётчик чётных цифр
            int evenCount = 0;
            // Счётчик нечётных цифр
            int oddCount = 0;
            // Перебираем все char в списке из элементов phoneNumber
            for (char digit : phoneNumber.toCharArray()) {
                // Проверка с помощью метода Класса Character что переменная является цифрой
                if (Character.isDigit(digit)) {
                    // Присваивание переменной значение цифры
                    int num = Character.getNumericValue(digit);
                    // Если чётная/нечётная увеличиваем соответствующий счётчик
                    if (num % 2 == 0) {
                        evenCount += 1;
                    } else {
                        oddCount += 1;
                    }
                }
            }
            // Если чётных чисел больше, добавляем возраст к totalage и увеличиваем счётчик людей на 1
            if (evenCount > oddCount) {
                totalAge += subscriber.getAge();
                count += 1;
            }
        }
        // Если число людей подходящих под условие > 1, выводится значение типа double, обозначающие средний возраст
        // Иначе выводится ошибка, что подходящих людей в справочнике нет
        if (count > 0) {
            System.out.println("Средний возраст: " + (double) totalAge / count);
        } else {
            System.out.println("Подходящих людей в телефонном справочнике нет");
        }
    }

    // Метод для получения суммарного возраста людей с заданным именем
    public int summaryAgeByName(String name) {
        // Переменная для хранения суммарного возраста
        int totalAge = 0;
        // Перебор всех объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Если имена совпадают, то к суммарному возрасту прибавляем значение геттера возраста у subscriber
            if (subscriber.getFirstName().equals(name)) {
                totalAge += subscriber.getAge();
            }
        }
        // Возвращает totalage если он больше нуля
        return Math.max(totalAge, 0);
    }

    // Метод для получения максимального суммарного возраста по первой букве фамилии
    public int getMaxAgeByFirstLetter() {
        // Список, где каждому индексу будет принадлежать суммарный возраст людей на одну букву фамилии
        int[] totalAgeByLetter = new int[33];
        // Перебор всех объектов класса Subscriber в списке subscribers
        for (Subscriber subscriber : subscribers) {
            // Присваивание строковой переменной фамилии для текущего объекта subscriber
            String lastName = subscriber.getLastName();
            // Если фамилия не пустая
            if (!lastName.isEmpty()) {
                // Переменная для получения первой буквы фамилии при помощи метода toLowerCase класса Character
                char letter = Character.toLowerCase(lastName.charAt(0));
                // Переменная для получения возраста текущего объекта subscriber
                int age = subscriber.getAge();
                // Если буква принадлежит русскому алфавиту
                if (letter >= 'а' && letter <= 'я') {
                    // то создается переменная index, которая хранит номер ячейки, к которой надо прибавить возраст объекта
                    int index = letter - 'а';
                    // Добавление к элементу под номером index возраста текущего объекта
                    totalAgeByLetter[index] += age;
                }
            }
        }
        // Переменная для хранения максимального суммарного возраста
        int maxAge = 0;
        // Перебор всех int значений в списке
        for (int sum : totalAgeByLetter) {
            // Если сумма больше максимальной обновляем значение максимальной
            if (sum > maxAge) {
                maxAge = sum;
            }
        }
        // Возвращение максимального значения
        return maxAge;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}