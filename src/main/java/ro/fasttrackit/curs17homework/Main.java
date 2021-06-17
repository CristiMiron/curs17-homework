package ro.fasttrackit.curs17homework;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Cristi", "Miron", 36, "Cluj"),
                new Person("Dumitru", "Somlea", 66, "Cluj"),
                new Person("Ionut", "Dumitrescu", 15, "Oradea"),
                new Person("Ana", "Girbea", 45, "Zalau"),
                new Person("Lia", "Apostol", 39, "Oradea"),
                new Person("Luca", "Sabau", 17, "Cluj"),
                new Person("Robert", "Kovacs", 30, "Cluj")
        );
        System.out.println("list all the persons names: firstName lastName");
        List<String> names = persons.stream()
                .map(person -> person.getFirstName().concat(" " + person.getLastName()))
                .collect(Collectors.toList());
        System.out.println(names);
        System.out.println("---------------------------------------");

        System.out.println("list all persons that are major");
        List<Person> major = persons.stream()
                .filter(person -> person.getAge() > 17)
                .collect(Collectors.toList());
        System.out.println(major);
        System.out.println("---------------------------------------");

        System.out.println("list all persons from Oradea");
        List<Person> oradea = persons.stream()
                .filter(person -> person.getCity().equals("Oradea"))
                .collect(Collectors.toList());
        System.out.println(oradea);
        System.out.println("---------------------------------------");

        System.out.println("list all persons from Oradea OR Cluj");
        List<Person> oradeaOrCluj = persons.stream()
                .filter(person -> person.getCity().equals("Oradea") || person.getCity().equals("Cluj"))
                .collect(Collectors.toList());
        System.out.println(oradeaOrCluj);
        System.out.println("---------------------------------------");

        System.out.println("list all firstNames CAPITALIZED");
        List<String> capitalized = persons.stream()
                .map(person -> person.getFirstName())
                .map(personToUpper -> personToUpper.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(capitalized);
        System.out.println("---------------------------------------");

        System.out.println("list all person names: firstName firstletter from last name: Stefan B.");
        List<String> firstLetter = persons.stream()
                .map(person -> person.getFirstName().
                        concat(" " + person.getLastName().charAt(0)).concat("."))
                .collect(Collectors.toList());
        System.out.println(firstLetter);
        System.out.println("---------------------------------------");

        System.out.println("list all persons with 18 < age < 60 ");
        List<Person> ageBetween = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60)
                .collect(Collectors.toList());
        System.out.println(ageBetween);
        System.out.println("---------------------------------------");

        System.out.println(" list all persons having first name starting with A");
        List<Person> startWithA = persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(startWithA);
        System.out.println("---------------------------------------");

        System.out.println("sort the persons by first name");
        System.out.println(persons.stream()
                .map(Person::getFirstName)
                .sorted()
                .collect(Collectors.toList()));
        System.out.println("---------------------------------------");

        System.out.println("sort the persons by last name");
        System.out.println(persons.stream()
                .map(Person::getLastName)
                .sorted()
                .collect(Collectors.toList()));
        System.out.println("---------------------------------------");

        System.out.println("sort the persons by first name, last name and then age");
        System.out.println(persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparingInt(Person::getAge))
                .collect(Collectors.toList()));


    }


}
