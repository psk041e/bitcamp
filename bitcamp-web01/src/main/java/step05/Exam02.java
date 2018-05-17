// 파일 업로드 - 멀티파트 파라미터 값 추출하기 
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

@WebServlet("/step05/exam02")
public class Exam02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        // 테스트 방법:
        // http://localhost:8888/bitcamp-web01/step05/exam02_test.html
        
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // 멀티 파트로 전송된 POST 요청 데이터를 추출하려면 일반적인 방법으로는 안된다.
        // apache.org 사이트의 라이브러리를 사용해 처리해 보자!
        // 1) 의존 라이브러리 정보 알아내기
        //    mvnrepository.com 에서 "apache fileupload" 검색
        // 2) build.gradle 에 의존 라이브러리 정보 추가
        // 3) "gradle eclipse" 실행하여 이클립스 설정 파일 갱신
        // 4) 이클립스 IDE에서 프로젝트 갱신
        
        // apache-fileupload 라이브러리를 사용하여 클라이언트가 보낸 멀티파트 데이터를 출력해보자!
        // > http://commons.apache.org/proper/commons-fileupload/using.html
        // 1) 클라이언트가 보낸 데이터가 멀티파트 형식인지 검사한다.
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            out.println("멀티파트 형식이 아닙니다!");
            return;
        }
        
        // 2) 멀티파트 데이터를 HDD에 저장할 공장 준비
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        //3) 멀티파트 데이터 분석기에 공장 객체를 장착한다.
        // => 멀티파트 데이터 분석기가 멀티파트 데이터를 추출하면,
        //    공장객체가 파일로 만들어 HDD에 저장한다.
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 4) 멀티파트로 전송된 요청 데이터 분석하기
        Map<String,String> paramMap = new HashMap<>();
        try {
            List<FileItem> items = upload.parseRequest(request);
            
            for (FileItem item : items) {// form 데이터 중에서도 file데이터는 FormField가 아니다.
                if (item.isFormField()) {// 일반적인 텍스트 항목일 경우, 순서에 보장을 못한다. -> Map사용
                    // 파라미터의 한글이 깨질 경우,
                    // => request.setCharacterEncoding("UTF-8") 은 소용없다.
                    //    이 코드는 멀티파트가 아닌 application/x-www-form-urlencoded로 전송된
                    //    데이터에 대해서만 동작한다.
                    // => 해결책? getString(문자표) 를 호출하라!
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명 
                            item.getString("UTF-8")); // 파라미터 값, FormField의 값
                } else { // 파일일 경우
                    out.printf("%s=%s\n", 
                            item.getFieldName(), // 파라미터 명
                            item.getName()); // 파일명, 업로드할 때 오리지날 파일 이름 -> "test.jpg"
                    // 클라이언트가 보낸 파일을 저장하자!
                    // - 임의의 폴더에 저장하면 웹 브라우저에서 업로드한 파일을 다시 다운로드 받기 어렵다!
                    //   임의의 폴더? 웹브라우저에서 접근할 수 없는 폴더를 말한다.
                    // - 임의의 폴더에 저장할 경우, 다운로드를 처리해주는 서블릿을 별도로 만들어야 한다.
                    // 좀 더 쉬운 방법은?
                    // - 웹브라우저가 접근할 수 있는 폴더에 저장하자!
                    // - 단 이 방법은 웹브라우저에서 너무 쉽게 특정 파일을 접근할 수 있기 때문에
                    //   보안에 취약하다.
                    // 실무는 어떤 방식을 취하나?
                    // - 웹브라우저가 접근할 수 없는 곳에 저장한다.
                    // - 오직 다운로드 서블릿을 통해서만 허가된 사용자가 다운로드 받을 수 있도록 한다.
                    //
                    // 여기서는 파일업로드 다운로드를 테스트하는데 집중하기 위해서
                    // 임의의 폴더가 아닌 웹르아우저에서 접근할 수 있는 폴더에 저장하겠다.
                    // 즉 배치 폴더에서 저장하겠다.
                    // 배치 폴더에 저장하기 위해서는 배치 폴더의 전체 경로를 알아야 한다.
                    //
                    // => 웹 애플리케이션 환경 정보를 다루는 객체를 얻는다.
                    ServletContext appEnvInfo = request.getServletContext(); // 앱 환경정보
                    // 이 메서드가 ServletContext객체를 리턴한다. -> 서블릿의 환경 정보를 다루는 객체, 웹 애플리케이션의 환경 정보를 다루는 객체
                    // => ServletContext 객체를 통해 웹 애플리케이션의 루트 디렉토리의
                    //    실제 경로를 알아낸다.
                    // 웹 어플리케이션의 루트폴더가 실제 파일시스템에서 (하드디스크에) 어디 저장되어있는지 -> 실제 파일시스템 경로가 어떻게 되는지를 알고있다.
                    String savedPath = appEnvInfo.getRealPath("/"); // root 밑에 저장하겠다.
                    out.println(savedPath);
                    
                    // => FileItem.write(저장할 경로) 호출하여 클라이언트가 보낸 파일을 저장한다.
                    // => 업로드한 파일은 임시 폴더에 저장되어 있다.
                    //    이 파일을 우리가 원하는 경로로 옮기는 것이다.(이 경로는 우리가 마음대로 조정할 수 있다.)
                    //
                    //      Configure a repository (to ensure a secure temp location is used)
                    //      ServletContext servletContext = this.getServletConfig().getServletContext();
                    //      File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                    //      factory.setRepository(repository);
                    //
                    // 문자열로 주면 안되고 파일 객체에 담아서 주어야 한다.
                    // 파일 저장할 경로를 우리가 root에 바로 저장하기로 했다.
                    // => root의 실제 경로를 알아야 한다.
                    item.write(new File(savedPath + "/" + item.getName())); 
                    // 저장하려면 파일 이름이 있어야 하기 때문에 item.getName()을 붙인다.
                    // write -> 파일 경로를 알려줄 테니까 임시폴더에 저장되어 있는것을 이곳으로 옮겨라!
                }
            }
        } catch (Exception e) {
            out.println("멀티파트 데이터 분석 중 오류 발생!");
        }
    }
}







