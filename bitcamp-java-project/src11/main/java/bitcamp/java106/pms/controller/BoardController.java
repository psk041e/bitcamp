// 스태틱 멤버(변수 및 메서드)를 인스턴스 멤버로 변경한다.
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    public Scanner keyScan;

    Board[] boards = new Board[1000]; 
    int boardIndex = 0;

    // * Low Couple
    public void service(String menu, String index) {
        if (menu.equals("board/add")) {
            this.onBoardAdd();
        } else if (menu.equals("board/list")) {
            this.onBoardList();
        } else if (menu.equals("board/view")) {
            this.onBoardView(index);
        } else if (menu.equals("board/update")) {
            this.onBoardUpdate(index);
        } else if (menu.equals("board/delete")) {
            this.onBoardDelete(index);
        } else {    // team/remove 처럼 잘못된 명령어를 쓸수도 있다.
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    void onBoardAdd() { 
        System.out.println("[게시물 입력]");
        Board board = new Board();
        
        System.out.print("제목? ");
        board.title = this.keyScan.nextLine(); // static메소드에 this라는 내장변수는 존재하지 않는다.
                                               // static멤버는 인스턴스 멤버에 접근할 수 없다.
                                               // 당분간은 this를 생략하지 말고 명시해주자
                                               // => 인스턴스 멤버라는것을 직관적으로 알기 위해서이다.
        System.out.print("내용? ");
        board.content = this.keyScan.nextLine();
    
        System.out.print("등록일? ");
        board.registration = this.keyScan.nextLine();
    
        this.boards[this.boardIndex++] = board;
    }
    
    void onBoardList() {
        System.out.println("[게시글 목록]");
        for (int i = 0; i < this.boardIndex; i++) {
            if (this.boards[i] == null) continue; 
            System.out.printf("%d, %s, %s\n", 
            i, this.boards[i].title, this.boards[i].registration );
        }
    }

    void onBoardView(String option) {
        System.out.println("[게시물 조회]");
        if (option == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }
        int i = Integer.parseInt(option);

        if (i < 0 || i >= boardIndex) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            Board board = this.boards[i];
            System.out.printf("제목 : %s\n", board.title);
            System.out.printf("내용 : %s\n", board.content);
            System.out.printf("등록일 : %s\n", board.registration);
        }
    }

    void onBoardUpdate(String option) {
        System.out.println("[게시글 변경]");
        if (option == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }

        int i = Integer.parseInt(option);

        if (i < 0 || i >= boardIndex) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            Board board = this.boards[i];
            Board updateBoard = new Board(); 
            System.out.printf("제목(%s)? ", board.title);
            updateBoard.title = this.keyScan.nextLine();
            System.out.printf("내용(%s)? ", board.content);
            updateBoard.content = this.keyScan.nextLine();
            this.boards[i] = updateBoard;

        }
    }
    void onBoardDelete(String option) {
        System.out.println("[게시글 삭제]");
        if (option == null) {
            System.out.println("인덱스 값을 입력하시기 바랍니다.");
            return; 
        }
       int i = Integer.parseInt(option);

        if (i < 0 || i >= boardIndex) {
            System.out.println("해당 인덱스 값의 게시글이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                this.boards[i] = null;
                System.out.println("삭제하였습니다.");
            }
        }
    }
}