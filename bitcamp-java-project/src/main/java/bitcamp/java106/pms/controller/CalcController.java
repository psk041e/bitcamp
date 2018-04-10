// Controller 규칙에 따라 메서드 작성
package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.Scanner;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.controller.Controller;
import bitcamp.java106.pms.dao.BoardDao;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

@Component("calc")
public class CalcController implements Controller {
    Scanner keyScan;
    
    public CalcController(Scanner scanner) {
        this.keyScan = scanner;
    }
    
    public void service(String menu, String option) {
        System.out.print("식을 입력하세요? ");
        String[] arr = keyScan.nextLine().split(" ");
        if (arr.length != 3) {
            System.out.println("입력 형식 예) 2 + 3");
            return;
        }
        
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[2]);
        String op = arr[1];
        int result = 0;
        
        switch (op) {
        case "+": result = a + b; break;
        case "-": result = a - b; break;
        case "*": result = a * b; break;
        case "/": result = a / b; break;
        default:
            System.out.printf("%s 연산은 지원하지 않습니다.", op);
            return;
        }
        System.out.printf("%d %s %d = %d", a, op, b, result);
        
    }
}

//ver 23 - @Component 애노테이션을 붙인다. BoardDao를 받도록 생성자 변경.
//ver 22 - BoardDao 변경 사항에 맞춰 이 클래스를 변경한다.
// ver 18 - BoardDao 변경 사항에 맞춰 이 클래스를 변경한다.
// ver 16 - 인스턴스 변수를 직접 사용하는 대신 겟터, 셋터 사용.
// ver 14 - BoardDao를 사용하여 게시물 데이터를 관리한다.
// ver 13 - 게시물 등록할 때 등록일의 문자열을 Date 객체로 만들어 저장.