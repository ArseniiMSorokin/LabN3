import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Subscriber {
    private final String firstName;
    private final String lastName;
    private final int age;
    private String phoneNumber;

    public Subscriber(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Имя: " + firstName + " Фамилия: " + lastName + " Возраст: " + age + ". Номер телефона: " + phoneNumber;
    }
}

class TelephoneBook {
    private final List<Subscriber> subscribers;

    public TelephoneBook() {
        subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        for (Subscriber subAlready : subscribers) {
            if (subAlready.getPhoneNumber().equals(subscriber.getPhoneNumber())) {
                System.out.println("Ошибка добавления: Номер телефона уже существует");
                return;
            }
            if (subAlready.getFirstName().equals(subscriber.getFirstName()) && subAlready.getLastName().equals(subscriber.getLastName()) && subAlready.getAge() == subscriber.getAge()) {
                System.out.println("Ошибка: абонент с таким именем, фамилией и возрастом уже существует");
                return;
            }
        }
        subscribers.add(subscriber);
    }

    public void showSubscribers() {
        subscribers.sort(Comparator.comparing(Subscriber::getFirstName));
        System.out.println("Список абонентов: ");
        for (Subscriber subscriber : subscribers) {
            System.out.println(subscriber);
        }
    }

    public void findPhoneNumNameAndLastname(String firstName, String lastName) {
        List<Subscriber> foundsubs = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                foundsubs.add(subscriber);
            }
        }
        subscribers.sort(Comparator.comparing(Subscriber::getAge));
        if (foundsubs.isEmpty()) {
            System.out.println("Абонент с именем " + firstName + " и фамилией " + lastName + " не найден");
        } else {
            System.out.println("Номера телефонов для " + firstName + " " + lastName);
            for (Subscriber subscriber : foundsubs) {
                System.out.println(subscriber.getPhoneNumber());
            }
        }
    }

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

    public void removeByName(String firstName, String lastName) {
        List<Subscriber> foundsubs = new ArrayList<>();

        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                foundsubs.add(subscriber);
            }
        }
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

    public void removeByPhone(String phoneNumber) {
        Subscriber needsub = null;
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getPhoneNumber().equals(phoneNumber)) {
                needsub = subscriber;
                break;
            }
        }
        if (needsub != null) {
            subscribers.remove(needsub);
            System.out.println("Абонент с номером " + phoneNumber + " удалён");
        } else {
            System.out.println("Абонент с номером " + phoneNumber + " не найден");
        }
    }

    public void removeUndAge(int age) {
        List<Subscriber> subsToRemove = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getAge() < age) {
                subsToRemove.add(subscriber);
            }
        }
        if (!subsToRemove.isEmpty()) {
            subscribers.removeAll(subsToRemove);
            System.out.println("Удалено " + subsToRemove.size() + " абонент(ов) младше " + age + " года(лет)");
        } else {
            System.out.println("Абоненты младше " + age + " лет не найдены");
        }
    }

    public void replacePhoneNum(String firstName, String lastName, String phoneNumber) {
        List<Subscriber> foundsubs = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFirstName().equals(firstName) && subscriber.getLastName().equals(lastName)) {
                foundsubs.add(subscriber);
            }
        }
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

    public void isAnyCommon() {
        List<String> lastNames = new ArrayList<>();
        boolean isFound = false;
        for (Subscriber subscriber : subscribers) {
            String lastName = subscriber.getLastName();
            if (lastNames.contains(lastName)) {
                System.out.println("Однофамильцы найдены");
                isFound = true;
                break;
            }
            lastNames.add(lastName);
        }
        if (!isFound) {
            System.out.println("Однофамильцы не найдены");
        }
    }

    public void averageEvenDigits() {
        int totalAge = 0;
        int count = 0;
        for (Subscriber subscriber : subscribers) {
            String phoneNumber = subscriber.getPhoneNumber();
            int evenCount = 0;
            int oddCount = 0;
            for (char digit : phoneNumber.toCharArray()) {
                if (Character.isDigit(digit)) {
                    int num = Character.getNumericValue(digit);
                    if (num % 2 == 0) {
                        evenCount += 1;
                    } else {
                        oddCount += 1;
                    }
                }
            }
            if (evenCount > oddCount) {
                totalAge += subscriber.getAge();
                count += 1;
            }
        }
        if (count > 0) {
            System.out.println("Средний возраст: " + (double) totalAge / count);
        } else {
            System.out.println("Подходящих людей в телефонном справочнике нет");
        }
    }

    public int summaryAgeByName(String name) {
        int totalAge = 0;
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getFirstName().equals(name)) {
                totalAge += subscriber.getAge();
            }
        }
        return Math.max(totalAge, 0);
    }

    public int getMaxAgeByFirstLetter() {
        int[] totalAgeByLetter = new int[34];
        for (Subscriber subscriber : subscribers) {
            String lastName = subscriber.getLastName();
            if (!lastName.isEmpty()) {
                char letter = Character.toLowerCase(lastName.charAt(0));
                int age = subscriber.getAge();
                if (letter >= 'а' && letter <= 'я') {
                    int index = letter - 'а';
                    totalAgeByLetter[index] += age;
                }
            }
        }
        int maxAge = 0;
        for (int sum : totalAgeByLetter) {
            if (sum > maxAge) {
                maxAge = sum;
            }
        }
        return maxAge;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}