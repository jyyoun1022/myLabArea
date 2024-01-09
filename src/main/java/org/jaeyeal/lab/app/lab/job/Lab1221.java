package org.jaeyeal.lab.app.lab.job;


import java.util.ArrayList;
import java.util.List;

public class Lab1221 {
    public static void main(String[] args) {
        /**
         * 1-3 월 => 1분기
         * 4-6 월 => 2분기
         * 6-9 월 => 3분기
         * 9-12 월 => 4분기
         */
        int currentMonth = 4;
        if (currentMonth >= 1 && currentMonth <= 3) {
            System.out.println("1분기");
        } else if (currentMonth >= 4 && currentMonth <= 6) {
            System.out.println("2분기");
        }

        switch (currentMonth) {
            case 1,2,3 :
                System.out.println("1분기");
                break;
            case 4,5,6 :
                System.out.println("2분기");
                break;
        }
    }

    class LoopLab {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
            list.add(6);

//            //1 : 일반 for문
//            for (int i = 0; i < list.size(); i++) {
//                Integer integer = list.get(i);
//                System.out.println(i);
//            }
//
//            //2 : 향상된 for문
//            for (Integer integer : list) {
//                System.out.println(integer);
//            }

            for (int i = 0; i <list.size(); i++) {
                for (int j = 0; j < list.size()+1; j++) {

                }
            }
            /**
             * 1단 9단까지
             * 1 * 1 = 1;
             * 1 * 2 = 2;
             */

        }
    }
}
