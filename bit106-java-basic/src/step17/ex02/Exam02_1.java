// 상수 코드를 별도의 클래스로 분리하여 다루기
package step17.ex02;

public class Exam02_1 {
    public static void main(String[] args) {
        Product p = new Product();
        p.category = Category.APPLIANCE_TV;
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
