// Wrapper ?´?˜?Š¤ - wrapper ê°ì²´?˜ ê°? ë¹„êµ
package step10;

public class Exam02_3 {
    public static void main(String[] args) {
        Integer obj1 = new Integer(100); // Heap ?— ?¸?Š¤?„´?Š¤ ?ƒ?„±
        Integer obj2 = new Integer(100); // Heap ?— ?¸?Š¤?„´?Š¤ ?ƒ?„±
        if (obj1 == obj2) // ?¸?Š¤?„´?Š¤?˜ ì£¼ì†Œ ë¹„êµ
            System.out.println("obj1 == obj2");
        else
            System.out.println("obj1 != obj2");
        
        Integer obj3 = 100; // constant pool ?— ?ƒ?„±
        Integer obj4 = 100; // constant pool ?— ?ƒ?„±?œ ê¸°ì¡´ ì£¼ì†Œ ë¦¬í„´
        if (obj3 == obj4) // ?¸?Š¤?„´?Š¤?˜ ì£¼ì†Œê°? ê°™ë‹¤.
            System.out.println("obj3 == obj4");
        else
            System.out.println("obj3 != obj4");
        
        int i = 100;
        Integer obj5 = new Integer(100);
        if (i == obj5) // obj5ê°? auto-unboxing ?„ ?ˆ˜?–‰?•˜?—¬ int?? intë¥? ë¹„êµ?•œ?‹¤.
                       // ?—°?‚°??Š” ?‘ê°œê? ê°™ì? ì¢…ë¥˜ê°? ?•„?‹ˆë©? ?ˆ˜?–‰?•  ?ˆ˜ ?—†?‹¤.
            System.out.println("i == obj5");
        else
            System.out.println("i != obj5");
        
        
        
        
    }
}
