// 파일 업로드
package bitcamp.mvc.web;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller 
@RequestMapping("/exam11_1") 
public class Exam11_1 {
    
    @Autowired ServletContext sc;
    
    @PostMapping("upload01")
    public void upload01(
            String name, 
            int age,
            MultipartFile[] files, // 여러개 파일을 업로드 할 경우 그러나 이렇게 하지 않아도 된다.
            Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
        String filesDir = sc.getRealPath("/files"); // "/"는 webapp 폴더까지를 의미한다. 저장 폴더명을 지정해준다.
        
        int i = 0;
        for (MultipartFile file : files) {
            String filename = UUID.randomUUID().toString(); // Universally Unique IDentifier
            model.addAttribute("file" + i + "Original", file.getOriginalFilename());
            model.addAttribute("file" + i + "New", filename);
            i++;
            try {
                File path = new File(filesDir + "/" + filename);
                System.out.println(path);
                file.transferTo(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}







