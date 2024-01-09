package org.jaeyeal.lab.app.lab.job;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInterface {
    /**
     * 이 예시에서는 먼저 ArrayList를 사용하여 리스트를 생성하고 출력합니다.
     * 그런 다음, 코드 한 줄만 변경하여 ArrayList 대신 LinkedList를 사용하여 동일한 코드를 실행합니다.
     * 이렇게 하면 코드의 유연성이 나타납니다. 인터페이스를 사용함으로써 ArrayList와 LinkedList 모두 List 인터페이스를 구현하므로 코드 변경 없이 다른 구현체로 쉽게 전환할 수 있습니다.
     * 이런 식으로 코드를 작성하면 추후에 새로운 리스트 구현체가 나오더라도 기존 코드를 변경하지 않고 새로운 구현체를 사용할 수 있습니다.
     */
    private static void printList(List<String> list) {
        for (String element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");
        printList(arrayList);

        // LinkedList로 변경
        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        printList(linkedList);


    }
}
