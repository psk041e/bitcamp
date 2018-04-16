package step23.ex01;

public class Exam01 {
    public String watermelon(int su) {
        String[] suback = {"수", "박"};
        int no;
        String s = null;
        
        if (su % 2 == 0) {
            no = su / 2;
            for (int i = 0; i < no; i++) {
                s = suback[0] + suback[1];
            }
        } else {
            no = su / 2;
            for (int i = 0; i < no; i++) {
                s = suback[0] + suback[1] + suback[0];
            }
        }
        
        return s;
    }
    
public static void main(String[] args) {
    Exam01 obj = new Exam01();
    System.out.println(obj.watermelon(3));
    System.out.println(obj.watermelon(4));
    
}
}
