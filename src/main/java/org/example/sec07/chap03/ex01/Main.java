package org.example.sec07.chap03.ex01;

import org.example.sec06.chap06.ex02.Button;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /**
         * 제네릭 메소드
         *
         * - 자료형을 필요에 따라 동적으로 정할 수 있도록 해 줌
         *     - 자료형을 변수로 갖는다고 이해
         * - 메소드 또는 클래스에 사용
         */

        // === pickRandom ===
        int randNum = pickRandom(123, 456);
        boolean randBool = pickRandom(true, false);
        String randStr = pickRandom("마루치", "아라치");

        //  import org.example.sec06.chap06.ex02.Button;
        Button button1 = new Button();
        Button button2 = new Button();
        Button randStore = pickRandom(button1, button2);

        //  ⚠️ 타입이 일관되지 않고 묵시적 변환 불가하면 오류
        //  double randFlt = pickRandom("hello", "world");
        double randDbl = pickRandom(12, 34);



        // === arraySwap ===
        //  원시값 배열(double[])을 쓰면 오류 - 배열로는 오토박싱이 안 되므로
        Double[] array1 = new Double[] {
                1.2, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8
        };
        Character[] array2 = new Character[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'
        };

        arraySwap(array1, 3, 5);
        arraySwap(array2, 2, 7);



        // 셔플
        for (int i = 0; i < 100; i++) {
            arraySwap(
                    array2,
                    (int) Math.floor(Math.random() * array2.length),
                    (int) Math.floor(Math.random() * array2.length)
            );
        }
    }

    //  제네릭 메소드
    //  T : 타입변수. 원하는 어떤 이름으로든 명명 가능
    public static <T> T pickRandom (T a, T b) {
        return new Random().nextBoolean() ? a : b;
    }

    public static <T> void arraySwap (T[] array, int a, int b) {
        if (array.length <= Math.max(a, b)) return;
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
