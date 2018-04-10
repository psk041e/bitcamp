// 예외 처리 - 예외에 대해 의미를 부여하기  - 사용자 정의 예외 만들고 사용하기
package step21.ex05;

import java.sql.Date;
import java.util.Scanner;

public class Exam03 {
    // 실무에서는 개발자에게 예외의 의미를 직관적으로 알 수 있도록 
    // RuntimeException 같은 평범한, 의미가 모호한 이름의 클래스를 사용하지 않고
    // 대신에 기존 예외를 상속받아 의미있는 이름으로 서브 클래스를 정의한 다음에 
    // 그 예외 클래스를 사용한다.
    // 예외 이름만으로 어떤 예외를 던지는 지 짐작할 수 있도록 
    // 기존 예외를 상속 받아 만든 예외를 사용한다.
    static Board read() throws BoardException {
        
        try (Scanner keyScan = new Scanner(System.in)) {
            Board board = new Board();
            
            System.out.print("번호> ");
            board.setNo(Integer.parseInt(keyScan.nextLine()));
            
            System.out.print("제목> ");
            board.setTitle(keyScan.nextLine());
            
            System.out.print("내용> ");
            board.setContent(keyScan.nextLine());
            
            System.out.print("등록일> ");
            board.setCreatedDate(Date.valueOf(keyScan.nextLine()));
            
            return board;
        } catch (Exception 원본오류) {
            throw new BoardException("게시물 입력 도중 오류 발생!", 원본오류);
        }
    }
    public static void main(String[] args) {
        try {
            Board board = read();
            System.out.println("------------------------");
            System.out.printf("번호: %d\n", board.getNo());
            System.out.printf("제목: %s\n", board.getTitle());
            System.out.printf("내용: %s\n", board.getContent());
            System.out.printf("등록일: %s\n", board.getCreatedDate());
            
        } catch (BoardException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        // 실행 결과
        // step21.ex05.BoardException: 게시물 입력 도중 오류 발생! -> 어디서 오류가 났는지 알 수 있다.(게시판오류)
        //게시물 입력 도중 오류 발생!
        //at step21.ex05.Exam03.read(Exam03.java:33)
        //at step21.ex05.Exam03.main(Exam03.java:38)
        //Caused by: java.lang.IllegalArgumentException
        //at java.sql.Date.valueOf(Date.java:143)
        //at step21.ex05.Exam03.read(Exam03.java:29)
        //... 1 more
        
    }
}
