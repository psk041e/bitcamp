// 파일 업로드 - 다른 클라이언트가 올린 파일을 덮어쓰지 않게 하기  
package step05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/step05/exam04")
public class Exam04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법:
        // http://localhost:8888/bitcamp-web01/step05/exam04_test.html
        
        
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
            String filename = newFilename(photo.getName());
            out.printf("photo=%s\n", filename); // photo의 원래 파일명 출력
            
            // 업로드 파일을 저장한다.
            ServletContext appEnvInfo = request.getServletContext(); 
            String savedPath = appEnvInfo.getRealPath("/"); 
            out.println(savedPath + filename);
            photo.write(new File(savedPath + "/" + filename)); 
            // 예전 이름을 주면서 그것을 가지고 새 파일명을 만들어서 달라 -> 매번 업로드할 때마다 파일명이 달라진다. 
            // 이미 파라미터 값을 알고있을때, 값을 쏙쏙 뽑을 때 사용하기 좋다.
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
    }
    
    int count = 0; // 0부터 시작
    // 워낙 컴퓨터 속도가 빠르다보니까 파일이 동시에 올라왔을 때 1000분의 1초동안 수십개, 수백개를 처리할수가 있게 된다.
    // 우리는 파일 이름을 만들 때 현재업로드한시각의 밀리초.확장자를 하면 파일명이 같아지는 문제가 발생한다.
    // 1밀레세컨드동안 파일이 2개가 들어올 수도 있기 때문에 count를 증가시켜야 한다.
    private String newFilename(String originFilename) {
        // 파일 확장자 추출하기
        // 예) test.ok.png 마지막 .png가 필요하다.
        int lastIndex = originFilename.lastIndexOf("."); // .의 마지막 Index를 찾았으면,
        String extName = "";
        if(lastIndex >= 0) { // .을 찾았다.
            extName = originFilename.substring(lastIndex); // 마지막 인덱스부터 끝까지
        }
        // 확장자
        // 유닉스 쪽에서는 파일을 저장할 때 확장자가 없는 경우가 있다.
        // 그래서 if문을 넣어준다.
        
        // 파일명: [현재업로드한시각의 밀리초]-[카운트].[확장자]
        return String.format("%s-%d%s", 
                System.currentTimeMillis(),
                ++count,
                extName
                );
    }
}







