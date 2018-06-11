package bitcamp.java106.pms.web.advice;

import java.beans.PropertyEditorSupport;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import bitcamp.java106.pms.web.ClassroomController;
import bitcamp.java106.pms.web.TaskController;
import bitcamp.java106.pms.web.TeamController;

@ControllerAdvice(assignableTypes= {
        TeamController.class, ClassroomController.class, TaskController.class})
public class GlobalBindingInitializer {
    // 컨트롤러 어드바이스 @InitBinder 메서드를 등록하면 
    // 각 페이지 컨트롤러 마다 따로 등록할 필요가 없다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("GlobalBindingInitializer.initBinder()");
        binder.registerCustomEditor(
                java.sql.Date.class, 
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String text) throws IllegalArgumentException {
                        this.setValue(java.sql.Date.valueOf(text));
                    }
                });
    }
}
