package org.example.sec07.chap03.ex05;

public class Main {
    public static void main(String[] args) {
        //  아무 유닛이나 태우는 말
        Horse<Unit> avante = new Horse<>(); // ⭐️ Horse<Unit>에서 Unit 생략
        avante.setRider(new Unit());
        avante.setRider(new Knight());
        avante.setRider(new MagicKnight());

        //  기사 계급 이상을 태우는 말
        Horse<Knight> sonata = new Horse<>(); // Knight 생략
//        sonata.setRider(new Unit()); // ⚠️ 불가
        sonata.setRider(new Knight());
        sonata.setRider(new MagicKnight());

        //  마법기사만 태우는 말
        Horse<MagicKnight> grandeur = new Horse<>();
//        grandeur.setRider(new Unit()); // ⚠️ 불가
//        grandeur.setRider(new Knight()); // ⚠️ 불가
        grandeur.setRider(new MagicKnight());



        //  ⚠️ 자료형과 제네릭 타입이 일치하지 않으면 대입 불가
        //  - 제네릭 타입이 상속관계에 있어도 마찬가지
//        Horse<Unit> wrongHorse1 = new Horse<Knight>();
//        Horse<Knight> wrongHorse2 = new Horse<Unit>();
//        avante = sonata;
//        sonata = grandeur;



        //  ⭐️ 와일드카드 - 제네릭 타입의 다형성을 위함

        //  💡 Knight과 그 자식 클래스만 받을 수 있음
        //  기사 계급 이상을 태우는 말 이상만 대입할 받을 수 있는 변수
        Horse<? extends Knight> knightHorse;
//        knightHorse = new Horse<Unit>(); // ⚠️ 불가
        knightHorse = new Horse<Knight>();
        knightHorse = new Horse<MagicKnight>();
//        knightHorse = avante; // ⚠️ 불가
        knightHorse = sonata;
        knightHorse = grandeur;



        //  💡 Knight과 그 조상 클래스만 받을 수 있음
        //  마법기사만 태우는 말은 받지 않는 변수
        Horse <? super Knight> nonLuxuryHorse;
        nonLuxuryHorse = avante;
        nonLuxuryHorse = sonata;
//        nonLuxuryHorse = grandeur; // 불가



        //  💡 제한 없음 - <? extends Object>와 동일
        //  어떤 말이든 받는 변수
        Horse<?> anyHorse;
        anyHorse = avante;
        anyHorse = sonata;
        anyHorse = grandeur;



        HorseShop.intoBestSellers(avante);
        HorseShop.intoBestSellers(sonata);
        HorseShop.intoBestSellers(grandeur);

//        HorseShop.intoPremiums(avante); // ⚠️ 불가
        HorseShop.intoPremiums(sonata);
        HorseShop.intoPremiums(grandeur);

        HorseShop.intoEntryLevels(avante);
        HorseShop.intoEntryLevels(sonata);
//        HorseShop.intoEntryLevels(grandeur); // ⚠️ 불가



        //  ⭐️ 제네릭은 변수에 들어올 값에 대한 제한
        //  - 데이터 그 자체에 대함이 아님

        /**
         * + 추가설명
         *
         * - Java에서 컴파일 시점에는 제네릭 타입이 적용되지만, 런타임에서는 제네릭 타입 정보가 소거됩니다.
         * - 즉, 컴파일된 바이트코드에서는 제네릭 정보를 사용할 수 없습니다.
         * - 따라서, 배열에 제네릭 타입을 사용하게 되면 컴파일 시에는 타입을 검사하지만, 런타임에서는 제네릭 타입 정보가 사라집니다.
         *
         * - 구체적으로 왜 에러가 발생하지 않는가?
         *     Horse[] horses = { avante, sonata, grandeur };
         *     for (Horse horse : horses) {
         *         horse.setRider(new Unit());
         *     }
         *     - 위 코드에서 Horse[]는 제네릭 배열이지만, 컴파일 시점에 제네릭 타입이 소거되어 단순한 Horse[] 배열로 취급됩니다
         *     - 즉, 배열 내부의 각각의 Horse 객체가 어떤 타입의 유닛을 탈 수 있는지에 대한 정보는 런타임에 알 수 없게 됩니다.
         *         - avante는 Horse<Unit> 타입이지만, 런타임에서는 그냥 Horse로 간주됩니다.
         *         - sonata는 Horse<Knight>, grandeur는 Horse<MagicKnight> 타입이지만, 역시 런타임에서는 Horse로 간주됩니다.
         *
         * 따라서, 배열의 각 원소가 구체적으로 어떤 타입의 제네릭을 사용하는지 알 수 없으므로, 컴파일러는 제약을 적용하지 않습니다. 런타임에서는 단순히 Horse 객체에 대해 setRider(new Unit())을 호출할 수 있게 됩니다.
         *
         * <이로 인해 발생할 수 있는 문제>
         * 이러한 경우는 타입 안정성이 무너질 수 있는 상황입니다. 예를 들어, Horse<Knight> 또는 Horse<MagicKnight> 객체에 Unit 객체가 잘못 설정되더라도, 컴파일러는 이를 잡아낼 수 없습니다. 이는 잠재적인 런타임 오류를 유발할 수 있습니다.
         * 제네릭 배열 사용 시 타입 안전성을 보장할 수 없기 때문에, Java에서는 제네릭 배열 생성을 원칙적으로 금지하고 있습니다.
         */
        Horse[] horses = { avante, sonata, grandeur };
        for (Horse horse : horses) {
            horse.setRider(new Unit());
        } // ⁉️ 에러 발생하지 않음
    }
}
