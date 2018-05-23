// ServletRequestAttributeListener: ServletRequest에 값을 저장하거나 제거할 때 발생하는 이벤트 처리 
package step09.ex02;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener3 implements ServletRequestAttributeListener{

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // ServletRequest 객체에 값을 저장할 때 호출된다.
        System.out.println("Listener3.attributeAdded()");
        System.out.printf("%s=%s 저장\n", 
                srae.getName(), 
                srae.getValue());
    }
    
    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // ServletRequest 객체의 값을 변경할 때 호출된다.
        System.out.println("Listener3.attributeReplaced()");
        System.out.printf("%s=%s(%s) 변경\n", 
                srae.getName(),
                srae.getServletRequest().getAttribute(srae.getName()),
                srae.getValue()); // 이전값을 리턴
        // 왜 겟벨류는 변경된값인가?
        // 겟벨류를 호출하면 그것이 변경되기 전 값이다.
        // 이벤트가 발생할 때마다 그 이벤트에 대해 등록해두면
        // 꼬박꼬박 그 이벤트가 발생할 것이다.
    }
}







