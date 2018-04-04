// 상수 코드를 별도의 스태틱 중첩 클래스로 다루기
package step17.ex02;

public class Exam03 {
    public static void main(String[] args) {
        Product p = new Product();
        p.category = Category2.appliance.TV;
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
