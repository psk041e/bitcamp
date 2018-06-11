// 요청 핸들러의 파라미터 - multipart/form-data 형식으로 넘어온 값 꺼내기
package bitcamp.mvc.web;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/exam05_10")
public class Exam05_10 {

    // 멀티파트 형식으로 넘어온 데이터를 꺼낼 때는 기존의 파라미터 변수를 선언하는 방식과 같다.
    // 주의!
    // => Spring WebMVC에 멀티파트 데이터를 처리하는 객체를 등록해야 한다.
    //    또한 그 객체가 의존하는 아파치의 commons-fileupload 라이브러리도 추가해야 한다.
    
    // => 클라이언트가 멀티파트 형식으로 보낸 데이터를 처리하려면
    //    반드시 Spring WebMVC에 멀티파트 처리 담당자(객체)를 등록해야 한다.
    
    @Autowired ServletContext sc; // 리얼패스를 가져와오기 위해
    
    // 테스트:
    // http://localhost:8888/bitcamp-spring-webmvc/exam05_10.html
    // http://localhost:8888/bitcamp-spring-webmvc/1.PNG
    @PostMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            String name, // <input type="text" ...>
            int age, // <input type="number" ...> 
            MultipartFile photo) throws Exception { // <input type="file" ...>
        
        String filePath = sc.getRealPath("/" + photo.getOriginalFilename());
        photo.transferTo(new File(filePath));
        return String.format("m1(): name=%s, age=%d, photo=%s", 
                name, 
                age, 
                photo.getOriginalFilename());
    }
    // 파일 업로드 방식은 일반적인 방식으로 보내면 안되고 멀티파트 방식으로 보내야 한다.
    // age값을 못받아 에러가 난다..
    // 멀티파트로 데이터를 보낼 때는 일반적인 방식으로 받을 수 없다. 
}
