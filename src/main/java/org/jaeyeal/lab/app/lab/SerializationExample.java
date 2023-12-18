package org.jaeyeal.lab.app.lab;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // 객체 생성
        Person person = new Person("John Doe", 25);

        // 객체를 직렬화하여 파일에 저장
        serializeObject(person, "serialized_person.ser");

        // 파일에서 객체를 역직렬화
        Person deserializedPerson = deserializeObject("serialized_person.ser");

        // 역직렬화된 객체 출력
        System.out.println("Deserialized Person: " + deserializedPerson);

        System.out.println("");
    }

    // 객체를 직렬화하여 파일에 저장하는 메서드
    private static void serializeObject(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            System.out.println("Object has been serialized and saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일에서 객체를 역직렬화하는 메서드
    private static Person deserializeObject(String filename) {
        Person person = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            person = (Person) ois.readObject();
            System.out.println("Object has been deserialized from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
