package org.example.sec07.chap01.ex04;

public class NotCloneable {
    //  원시타입 필드들
    String title;
    int no;

    //  참조타입 필드들
    int[] numbers;
    Click click;
    Click[] clicks;

    public NotCloneable(String title, int no, int[] numbers, Click click, Click[] clicks) {
        this.title = title;
        this.no = no;
        this.numbers = numbers;
        this.click = click;
        this.clicks = clicks;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //  💡 아래 super의 clone : 필드들을 얕은복사 해주는 Object 메소드
        //  - 원시타입 필드는 확실히 복사해줌. 참조타입은 참조복사만

        //  ⭐️ Cloneable을 구현하지 않은 클래스에서 호출하면 오류 발생!
        //  - 아래의 코드를 호출 안 하면 오류가 나지 않지만
        //  - 원시값 복사까지 일일이 구현해주어야 함
        //      - 즉 clone을 오버라이드해서 쓰는 의미 없음
        return super.clone();

        // 수동으로 구현
        // 참조 주소값이 다른 객체가 반환이 됨
        // 하지만 이렇게 직접 반환을 할거면 굳이 `clone()` 오버라이드 할 필요가 없다.
        // 다른 메소드로도 반환할 수 있으니...
//        return new NotCloneable(title, no, numbers, click, clicks);
    }
}
