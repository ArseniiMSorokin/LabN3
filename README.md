# LabN3
## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

#### Выполнил: `Сорокин Арсений`

#### Вариант: `23`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Алгоритм](#2-алгоритм)
- [Программа](#3-программа)
- [Анализ правильности решения](#4-анализ-правильности-решения)

### 1. Постановка задачи

- Условия задачи
- Телефонный справочник
- Краткое описание
- Разработать программу для реализации телефонного справочника, содержащего дан-
ные о номерах телефонов, именах, фамилиях и возрастах пользователей. Реализовать
функции добавления, удаления записей, поиска информации и анализа данных.
Описание функционала
1. Вывод телефонного списка
Выводит телефонный список, отсортированный:
• По фамилиям в алфавитном порядке;
• При совпадении фамилий — по именам;
• При совпадении фамилий и имён — по возрасту от младшего к старшему.
2. Добавление номера
Добавляет нового человека в справочник. Все номера должны быть уникальны.
Если номер уже существует или если уже есть запись с одинаковыми именем,
фамилией и возрастом, добавление не выполняется.
3. Поиск номера по имени и фамилии
Возвращает номер человека с указанными именем и фамилией. Если несколько
людей имеют одинаковые имя и фамилию, номера выводятся в порядке возраста-
ния возраста.
4. Поиск по имени или фамилии
Выводит все номера людей, у которых имя или фамилия совпадают с переданным
словом, в порядке их появления в списке.
5. Удаление по фамилии и имени
Удаляет человека с указанными фамилией и именем. Если таких записей несколько, удаление не выполняется.
6. Удаление по номеру телефона
Удаляет запись с указанным номером телефона.
7. Удаление людей младше заданного возраста
Удаляет всех людей, чей возраст меньше переданного значения.
8. Замена номера телефона
Заменяет номер телефона человека с указанными именем и фамилией. Если таких
записей несколько, замена не выполняется.
9. Проверка наличия однофамильцев
Определяет, есть ли в списке хотя бы два человека с одинаковой фамилией.
10. Средний возраст по номеру с чётными цифрами
Вычисляет средний возраст людей, в номерах телефонов которых больше чётных
цифр, чем нечётных.
11. Суммарный возраст по имени
Возвращает суммарный возраст всех людей с указанным именем.
12. Максимальный суммарный возраст по первой букве фамилии
Находит максимальный суммарный возраст среди людей, фамилии которых на-
чинаются с одной и той же буквы.

### 2. Алгоритм

#### Анализ алгоритма:
  Класс Subscriber (Абонент):
      Атрибуты:
          firstName: Имя абонента (строка).
          lastName: Фамилия абонента (строка).
          age: Возраст абонента (целое число).
          phoneNumber: Номер телефона абонента (строка).
      Методы:
          Геттеры для всех атрибутов.
          Сеттер для phoneNumber.
          Метод toString() для отображения информации об абоненте.

  Класс TelephoneBook (Телефонный справочник):
      Атрибуты:
        subscribers: Список абонентов, хранящий объекты класса Subscriber (список).
      Методы:
          addSubscriber(Subscriber subscriber): Добавляет абонента в список, проверяя уникальность номера телефона и комбинации имени, фамилии и возраста.
          showSubscribers(): Отображает всех абонентов, отсортированных по имени.
          findPhoneNumNameAndLastname(String firstName, String lastName): Находит номера телефонов по имени и фамилии.
          findPhoneNumNameOrLastname(String name): Находит номера телефонов по имени или фамилии.
          removeByName(String firstName, String lastName): Удаляет абонента по имени и фамилии.
          removeByPhone(String phoneNumber): Удаляет абонента по номеру телефона.
          removeUndAge(int age): Удаляет абонентов младше определенного возраста.
          replacePhoneNum(String firstName, String lastName, String phoneNumber): Заменяет номер телефона абонента по имени и фамилии.
          isAnyCommon(): Проверяет наличие однофамильцев.
          averageEvenDigits(): Вычисляет средний возраст абонентов с номером телефона, в котором больше четных цифр, чем нечетных.
          summaryAgeByName(String name): Возвращает суммарный возраст абонентов с заданным именем.
          getMaxAgeByFirstLetter(): Возвращает максимальный суммарный возраст по первой букве фамилии.

     

#### Математическая модель:

  (1) addSubscriber(Subscriber subscriber):
        Этот метод предназначен для добавления нового абонента в телефонный справочник. Он принимает объект Subscriber, который содержит информацию об абоненте, такую как имя, фамилия, номер телефона и, возможно, возраст. Перед добавлением метод проверяет, существует ли уже номер телефона в справочнике. Если номер отсутствует, абонент добавляется, если же номер уже есть, метод не выполняет никаких действий и может вернуть сообщение о том, что абонент с таким номером уже существует.

  (2)showSubscribers():
        Метод отображает всех абонентов, находящихся в телефонном справочнике. Он перебирает список абонентов и выводит их полные данные (имя, фамилия и номер телефона) в удобном для чтения формате. Это позволяет пользователю быстро просмотреть всю информацию о всех абонентах без необходимости выполнять поиск.

  (3) findPhoneNumNameAndLastname(String firstName, String lastName):
        Этот метод ищет номера телефонов абонентов по заданным имени и фамилии. Он принимает два параметра: имя и фамилию. Метод проходит по списку абонентов и собирает номера телефонов тех, у кого совпадают указанные имя и фамилия. Результаты собираются в список, который затем возвращается пользователю. Если абоненты с такими данными не найдены, метод может вернуть пустой список или соответствующее сообщение.

  (4) findPhoneNumNameOrLastname(String name):
        Метод ищет номера телефонов по имени или фамилии. Он принимает один параметр — строку, которая может быть как именем, так и фамилией. Метод проверяет всех абонентов в справочнике и собирает номера телефонов, если совпадает хотя бы одно из указанных значений (имя или фамилия). Это позволяет пользователю находить абонентов более гибко.

  (5) removeByName(String firstName, String lastName):
        Этот метод удаляет абонента из справочника по указанному имени и фамилии. Он проходит по списку абонентов и ищет совпадение с заданными данными. Если находит соответствующего абонента, он удаляет его из справочника. Если абонент не найден, метод может вернуть сообщение о том, что удаление не произошло, так как абонент с такими данными отсутствует.

  (6) removeByPhone(String phoneNumber):
        Метод предназначен для удаления абонента по номеру телефона. Пользователь передает номер, и метод проверяет наличие абонента с таким номером в справочнике. Если абонент найден, он удаляется; если нет, метод может вернуть уведомление о том, что абонент с указанным номером отсутствует.

  (7) removeUndAge(int age):
        Этот метод удаляет всех абонентов, чей возраст меньше заданного значения. Метод проходит по списку абонентов и проверяет возраст каждого из них. Если возраст абонента ниже указанного, он удаляется из справочника. Это позволяет поддерживать справочник в актуальном состоянии, исключая абонентов, которые не соответствуют заданным критериям по возрасту.

  (8) replacePhoneNum(String firstName, String lastName, String phoneNumber):
        Метод заменяет номер телефона у конкретного абонента, указанного по имени и фамилии. Он ищет абонента с заданными данными и, если находит его, обновляет номер телефона на новый, предоставленный пользователем. Если абонент не найден, метод может вернуть сообщение о том, что замена не была выполнена.

  (9) isAnyCommon():
        Этот метод проверяет наличие однофамильцев в справочнике. Он проходит по всем абонентам и собирает фамилии в отдельный список. Если в этом списке обнаруживаются дубликаты, это означает, что есть абоненты с одинаковыми фамилиями. Метод возвращает true, если однофамильцы найдены, и false в противном случае.

  (10) averageEvenDigits():
         Метод вычисляет средний возраст абонентов, у которых в номере телефона больше четных цифр, чем нечетных. Он анализирует номера телефонов каждого абонента, подсчитывая количество четных и нечетных цифр. Если количество четных цифр превышает нечетные, возраст абонента добавляется в список. В конце метод вычисляет и возвращает средний возраст всех абонентов, соответствующих этому критерию.
         
  (11) summaryAgeByName(String name):
        Этот метод возвращает суммарный возраст всех абонентов с указанным именем. Он проходит по справочнику, проверяя имя каждого абонента. Если имя совпадает с указанным, возраст абонента добавляется к общему итогу. Метод возвращает общую сумму возрастов всех найденных абонентов с данным именем.

  (12) getMaxAgeByFirstLetter():
      Этот метод находит максимальный суммарный возраст абонентов, сгруппированных по первой букве их фамилии. Он создает коллекцию, где ключами являются первые буквы фамилий, а значениями — суммарный возраст абонентов с фамилиями, начинающимися на эту букву. Метод проходит по всем абонентам, обновляя суммарный возраст. В конце он возвращает максимальное значение из всех собранных сумм.


### 3. Программа 
```java
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
        // Создание телефонного справочника
        TelephoneBook telephoneBook = new TelephoneBook();

        // Создание нескольких абонентов
        Subscriber subscriber1 = new Subscriber("Иван", "Иванов", 25, "1234567890");
        Subscriber subscriber2 = new Subscriber("Петр", "Петров", 30, "0987654321");
        Subscriber subscriber3 = new Subscriber("Светлана", "Сидорова", 22, "1112223334");
        Subscriber subscriber4 = new Subscriber("Анна", "Сидорова", 28, "2223334445");
        Subscriber subscriber5 = new Subscriber("Иван", "Иванов", 25, "1234567890"); // Дубликат

        // Добавление абонентов в телефонный справочник
        telephoneBook.addSubscriber(subscriber1);
        telephoneBook.addSubscriber(subscriber2);
        telephoneBook.addSubscriber(subscriber3);
        telephoneBook.addSubscriber(subscriber4);
        telephoneBook.addSubscriber(subscriber5); // Попытка добавить дубликат

        // Отображение списка абонентов
        telephoneBook.showSubscribers();

        // Поиск номера телефона по имени и фамилии
        telephoneBook.findPhoneNumNameAndLastname("Иван", "Иванов");
        telephoneBook.findPhoneNumNameAndLastname("Петр", "Петров");
        telephoneBook.findPhoneNumNameAndLastname("Светлана", "Сидорова");

        // Поиск номера телефона по имени или фамилии
        telephoneBook.findPhoneNumNameOrLastname("Сидорова");

        // Удаление абонента по имени и фамилии
        telephoneBook.removeByName("Петр", "Петров");
        telephoneBook.showSubscribers();

        // Удаление по номеру телефона
        telephoneBook.removeByPhone("1234567890");
        telephoneBook.showSubscribers();

        // Удаление абонентов младше определённого возраста
        telephoneBook.removeUndAge(26);
        telephoneBook.showSubscribers();

        // Замена номера телефона
        telephoneBook.replacePhoneNum("Светлана", "Сидорова", "5556667778");
        telephoneBook.showSubscribers();

        // Проверка наличия однофамильцев
        telephoneBook.isAnyCommon();

        // Вычисление среднего возраста
        telephoneBook.averageEvenDigits();

        // Получение суммарного возраста по имени
        int totalAge = telephoneBook.summaryAgeByName("Иван");
        System.out.println("Суммарный возраст абонентов с именем Иван: " + totalAge);

        // Получение максимального суммарного возраста по первой букве фамилии
        int maxAge = telephoneBook.getMaxAgeByFirstLetter();
        System.out.println("Максимальный суммарный возраст по первой букве фамилии: " + maxAge);
    }
}
```

### 4. Анализ правильности решения
  Тесты на работу всех методов класса TelephoneBook
```
Создание телефонного справочника
        TelephoneBook telephoneBook = new TelephoneBook();

Создание нескольких абонентов
        Subscriber subscriber1 = new Subscriber("Иван", "Иванов", 25, "1234567890");
        Subscriber subscriber2 = new Subscriber("Петр", "Петров", 30, "0987654321");
        Subscriber subscriber3 = new Subscriber("Светлана", "Сидорова", 22, "1112223334");
        Subscriber subscriber4 = new Subscriber("Анна", "Сидорова", 28, "2223334445");
        Subscriber subscriber5 = new Subscriber("Иван", "Иванов", 25, "1234567890"); // Дубликат

Добавление абонентов в телефонный справочник
        telephoneBook.addSubscriber(subscriber1);
        telephoneBook.addSubscriber(subscriber2);
        telephoneBook.addSubscriber(subscriber3);
        telephoneBook.addSubscriber(subscriber4);
        telephoneBook.addSubscriber(subscriber5); // Попытка добавить дубликат

Отображение списка абонентов
        telephoneBook.showSubscribers();

Поиск номера телефона по имени и фамилии
        telephoneBook.findPhoneNumNameAndLastname("Иван", "Иванов");
        telephoneBook.findPhoneNumNameAndLastname("Петр", "Петров");
        telephoneBook.findPhoneNumNameAndLastname("Светлана", "Сидорова");

Поиск номера телефона по имени или фамилии
        telephoneBook.findPhoneNumNameOrLastname("Сидорова");

Удаление абонента по имени и фамилии
        telephoneBook.removeByName("Петр", "Петров");
        telephoneBook.showSubscribers();

Удаление по номеру телефона
        telephoneBook.removeByPhone("1234567890");
        telephoneBook.showSubscribers();

Удаление абонентов младше определённого возраста
        telephoneBook.removeUndAge(26);
        telephoneBook.showSubscribers();

Замена номера телефона
        telephoneBook.replacePhoneNum("Светлана", "Сидорова", "5556667778");
        telephoneBook.showSubscribers();

Проверка наличия однофамильцев
        telephoneBook.isAnyCommon();

Вычисление среднего возраста
        telephoneBook.averageEvenDigits();

Получение суммарного возраста по имени
        int totalAge = telephoneBook.summaryAgeByName("Иван");
        System.out.println("Суммарный возраст абонентов с именем Иван: " + totalAge);

Получение максимального суммарного возраста по первой букве фамилии
        int maxAge = telephoneBook.getMaxAgeByFirstLetter();
        System.out.println("Максимальный суммарный возраст по первой букве фамилии: " + maxAge);



Вывод:
Ошибка добавления: Номер телефона уже существует
Список абонентов: 
Имя: Анна Фамилия: Сидорова Возраст: 28. Номер телефона: 2223334445
Имя: Иван Фамилия: Иванов Возраст: 25. Номер телефона: 1234567890
Имя: Петр Фамилия: Петров Возраст: 30. Номер телефона: 0987654321
Имя: Светлана Фамилия: Сидорова Возраст: 22. Номер телефона: 1112223334
Номера телефонов для Иван Иванов
1234567890
Номера телефонов для Петр Петров
0987654321
Номера телефонов для Светлана Сидорова
1112223334
Номера телефонов для Сидорова
1112223334
2223334445
Абонент Петр Петров успешно удалён
Список абонентов: 
Имя: Анна Фамилия: Сидорова Возраст: 28. Номер телефона: 2223334445
Имя: Иван Фамилия: Иванов Возраст: 25. Номер телефона: 1234567890
Имя: Светлана Фамилия: Сидорова Возраст: 22. Номер телефона: 1112223334
Абонент с номером 1234567890 удалён
Список абонентов: 
Имя: Анна Фамилия: Сидорова Возраст: 28. Номер телефона: 2223334445
Имя: Светлана Фамилия: Сидорова Возраст: 22. Номер телефона: 1112223334
Удалено 1 абонент(ов) младше 26 года(лет)
Список абонентов: 
Имя: Анна Фамилия: Сидорова Возраст: 28. Номер телефона: 2223334445
Абонент не найден
Список абонентов: 
Имя: Анна Фамилия: Сидорова Возраст: 28. Номер телефона: 2223334445
Однофамильцы не найдены
Средний возраст: 28.0
Суммарный возраст абонентов с именем Иван: 0
Максимальный суммарный возраст по первой букве фамилии: 28
```   
