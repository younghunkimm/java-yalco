package org.example.sec06.chap08;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {
        //  ⚠️ 불가. 생성자 확인해 볼 것
        // 싱글턴 패턴
//        Math mathInst = new Math();

        // === ⭐️ 정적 필드들 ===

        //  자연로그의 밑
        double e = Math.E;
        double pi = Math.PI;

        // === ⭐️ 정적 메소드들 ===

        //  절대값. 숫자 자료형마다 오버로드
        int absInt = Math.abs(-5);
        double absDbl = Math.abs(-3.14);

        //  올림, 내림, 반올림
        double ceil = Math.ceil(2.34);
        double floor = Math.floor(4.56);
        double round1 = Math.round(2.34);
        double round2 = Math.round(4.56);

        //  큰 수 또는 작은 수 반환. 자료형마다 오버로드
        int largerInt = Math.max(2, 3);
        float smallerFlt = Math.min(1.2f, 3.4f);

        //  제곱
        double pow1 = Math.pow(4, 3); // double을 받지만 묵시 형변환
        double pow2 = Math.pow(4, 0.5);

        //  0.0 이상 1.0 미만 무작위 수
        double rand1 = Math.random();
        double rand2 = Math.random();
        double rand3 = Math.random();

        //  1에서 10 사이의 무작위 정수
        int _1to10_1 = (int) Math.ceil(Math.random() * 10);
        int _1to10_2 = (int) Math.floor(Math.random() * 10) + 1;



        // === 💡 `Random` 클래스 ===
        Random random = new Random();

        /**
         * 시드 (Seed)
         *
         * - 특정 값을 지정하면 이후 랜덤 값들이 일관적으로 나옴
         *     - 디버깅, 테스트 등에 유용
         * - 직접 지정하지 않을 시 현재 시각에 따라 자동으로 지정됨
         *     - 즉 매 회 다른 값이 나옴
         */
        //  random.setSeed(1234);

        int randInt1 = random.nextInt();
        int randInt2 = random.nextInt();
        int randInt3 = random.nextInt();
        // 범위 지정 (이상, 미만)
        int randInt4 = random.nextInt(0, 10);
        int randInt5 = random.nextInt(0, 10);
        int randInt6 = random.nextInt(0, 10);

        double randDbl1 = random.nextDouble();
        double randDbl2 = random.nextDouble();
        // 범위 지정 (이상, 미만)
        double randDbl3 = random.nextDouble(3.14, 5.67);
        double randDbl4 = random.nextDouble(3.14, 5.67);

        boolean randBln1 = random.nextBoolean();
        boolean randBln2 = random.nextBoolean();



        // === `BigInteger` 클래스 ===
        long maxLong = Long.MAX_VALUE;

        // - Long에서 다룰 수 있는 최대 정수 이상의 수를 다룰 수 있음
        // - 숫자가 들어있는 문자열을 파라미터로 받는다.
        BigInteger bigInt1 = new BigInteger("123456789012345678901234567890");
        BigInteger bigInt2 = new BigInteger("987654321098765432109876543210");

        // 기본적으로 원시자료형이 아니기 때문에 +, -, * 등의 연산자는 사용할 수 없기 때문에 인스턴스 메소드를 써야한다.
        BigInteger bigInt3 = bigInt1.add(bigInt2); // 더하기
        BigInteger bigInt4 = bigInt2.subtract(bigInt1); // 빼기
        BigInteger bigInt5 = bigInt1.multiply(bigInt2); // 곱하기
        BigInteger bigInt6 = bigInt2.divide(bigInt1); // 나누기

        // 인스턴스와 파라미터를 비교해서
        // 인스턴스가 크다면 1 반환
        // 파라미터가 크다면 -1 반환
        int bigIntCompare1 = bigInt1.compareTo(bigInt2);
        int bigIntCompare2 = bigInt2.compareTo(bigInt1);



        // === 💡 `BigDecimal` 클래스 ===

        //  부동소수점 오차
        double num1 = 0.2 + 0.3f;
        double num2 = 0.3f * 0.7f;
        double num3 = 0.4 - 0.3;
        double num4 = 0.9f / 0.3;
        double num5 = 0.9 % 0.6;

        //  - 부동소수점 오차를 해결
        float num6 = new BigDecimal("0.2")
                .add(new BigDecimal("0.3"))
                .floatValue();

        float num7 = new BigDecimal("0.3")
                .multiply(new BigDecimal("0.7"))
                .floatValue();

        float num8 = new BigDecimal("0.4")
                .subtract(new BigDecimal("0.3"))
                .floatValue();

        double num9 = new BigDecimal("0.9")
                .divide(new BigDecimal("0.3"))
                .doubleValue();

        double num10 = new BigDecimal("0.9")
                .remainder(new BigDecimal("0.6"))
                .doubleValue();




        //  ~Exact 메소드들 : 자료형의 범위를 넘기면 오류 발생
        int add1 = Math.addExact(2_147_483_645, 2);
        int add2 = 2_147_483_645 + 3;
        //  int add3 = Math.addExact(2_147_483_645, 3);
    }
}
