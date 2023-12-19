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

        System.out.println("dd");
    }

    // 객체를 직렬화하여 파일에 저장하는 메서드
    private static void serializeObject(Object obj, String filename) {
//        try (
//                FileOutputStream fos = new FileOutputStream(filename);
        // 데이터를 파일에 바이트 스트림으로 저장하기 위해 사용
        // 반대로 FileInputStream 은 파일 내용을 읽는 클래스
//                ObjectOutputStream out = new ObjectOutputStream(fos)
//        ) {
//            // 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
//            out.writeObject(obj);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        객체가 직렬화될때 오직 객체의 인스턴스 필드값 만을 저장한다. static 필드나 메서드는 직렬화하여 저장하지 않는다.

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
