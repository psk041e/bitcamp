// 게시판 관리 - 삭제 + PrepredStatement 적용
package step25.ex03;

import java.util.Scanner;

import step25.ex03.BoardDao;

public class Exam01_delete {

    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 게시물 번호? ");
        String no = keyScan.nextLine();

        try {
            BoardDao boardDao = new BoardDao();
            int count = boardDao.delete(Integer.parseInt(no));
            System.out.printf("%d 개 삭제 성공!", count); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        keyScan.close();
    }
}







