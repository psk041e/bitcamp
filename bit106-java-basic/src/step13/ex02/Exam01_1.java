// 제네릭 적용 전 LinkedList
package step13.ex02;

public class Exam01_1 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Member("홍길동", 20));
        list.add(new Member("임꺽정", 30));
        list.add(new Member("유관순", 16));
        
        // 값을 거내 사용하려면 항상 형변환해야 한다.
        for (int i = 0; i < list.size(); i++) {
            Member member = (Member) list.get(i);
            System.out.printf("%s(%d)\n", member.name, member.age);
        }
        // 리스트에 멤버가 아닌 다른 것이 들어오는 것을 막을 수 없다.
        
    }
    
    static void print(LinkedList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println();
    }

}
