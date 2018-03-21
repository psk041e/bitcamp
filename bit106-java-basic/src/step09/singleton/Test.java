// Singleton ?Œ¨?„´
// => ê°ì²´ë¥? ?•œ ê°œë§Œ ?ƒ?„±?•  ?ˆ˜ ?ˆê²? ë§Œë“œ?Š” ?„¤ê³? ê¸°ë²• (Calenderê°? ?´??ê°™ì? ë°©ì‹?œ¼ë¡? ?˜?–´?ˆ?‹¤.)
package step09.singleton;

public class Test {

    public static void main(String[] args) {
        // Singleton?„ ? ?š©?•˜ì§? ?•Š?? ?´?˜?Š¤?˜ ?¸?Š¤?„´?Š¤ ë§Œë“¤ê¸?
        Car c1 = new Car();
        Car c2 = new Car();
        Car c3 = new Car();
        // ?´? ‡ê²? ?¸?Š¤?„´?Š¤ ?ƒ?„±?— ? œ?•œ?´ ?—†?‹¤.
        
        System.out.println("-----------------");
        
        // Car2 ?´?˜?Š¤?˜ ?ƒ?„±?ë¥? ? ‘ê·¼í•  ?ˆ˜ ?—†ê¸? ?•Œë¬¸ì— ?˜¸ì¶œí•  ?ˆ˜ ?—†?‹¤.
        // Car2 c1 = new Car2(); // ì»´íŒŒ?¼ ?˜¤ë¥?!
        
        
        Car2 x1 = Car2.getInstance();
        Car2 x2 = Car2.getInstance();
        Car2 x3 = Car2.getInstance();
        if (x1 == x2) System.out.println("x1 == x2");
        if (x2 == x3) System.out.println("x2 == x3");
        
        
        
    }
}
