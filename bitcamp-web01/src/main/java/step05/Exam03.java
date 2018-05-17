// 파일 업로드 - 멀티파트 파라미터 값 추출하기 II  
package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/step05/exam03")
public class Exam03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법:
        // http://localhost:8888/bitcamp-web01/step05/exam03_test.html
        
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        try {
            Map<String,List<FileItem>> paramMap = upload.parseParameterMap(request);
            
            // name으로 된 List객체는 하나밖에 없으므로 0번째 값을 꺼낸다.
            // 만약 파라미터 이름이 같은 이름으로 서버에 여러개를 보낼 때는 파일의 값이 배열이어야 한다.
            // 그것과 같다. 같은 이름으로 여러개 값을 보낼 것을 대비해서 List에 보관을 한다.
            // List에서 0번째것은 FileItem이다.
            out.printf("name=%s\n", paramMap.get("name").get(0).getString("UTF-8"));
            out.printf("age=%s\n", paramMap.get("age").get(0).getString()); // 숫자이기 때문에 UTF-8할 필요가 없다.
            
            FileItem photo = paramMap.get("photo").get(0);
            out.printf("photo=%s\n", photo.getName()); // photo의 원래 파일명 출력
            
            // 업로드 파일을 저장한다.
            ServletContext appEnvInfo = request.getServletContext(); 
            String savedPath = appEnvInfo.getRealPath("/"); 
            out.println(savedPath + photo.getName());
            photo.write(new File(savedPath + "/" + photo.getName())); 
            // 이미 파라미터 값을 알고있을때, 값을 쏙쏙 뽑을 때 사용하기 좋다.
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
    }
}







