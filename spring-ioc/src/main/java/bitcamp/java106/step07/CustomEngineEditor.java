// 프로퍼티 에디터 만들기
package bitcamp.java106.step07;

import java.beans.PropertyEditorSupport;
import java.sql.Date;

public class CustomEngineEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("CustomEngineEditor.setAsText()"); 
        // value의 문자열을 받아서 ,단위로 쪼개 배열에 집어넣은 후 engine객체에 그 값을 담는다.
        // ex) <property name="engine" value="비트자동차,16,4"/>
        String[] values = text.split(",");
        Engine engine = new Engine();
        engine.setMaker(values[0]);
        engine.setValve(Integer.parseInt(values[1]));
        engine.setCylinder(Integer.parseInt(values[2]));
        
        this.setValue(engine); // 이 engine객체를 보관한다.
    }
    // 세터메서드에 들어갈 값을 준비한다.
    // 세터메서드에 들어갈 값을 준비하지 못하면 그 전에 에러를 띄운다.
}
