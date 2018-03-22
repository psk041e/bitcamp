// 컨트롤러가 작업하는데 필요한 객체를 반드시 준비하도록 생성자를 추가한다.
// => 생성자를 통해 필수 입력 값을 반드시 설정하도록 강제시킬 수 있다.
// => 즉, 생성자란 객체를 사용하기 전에 유효한 값으로 설정하게 만드는 문법이다.
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.util.Console;

public class BoardController {
    Scanner keyScan;

    Board[] boards = new Board[1000]; 
    int boardIndex = 0;
    
    public BoardController(Scanner scanner) {
        // BaordController의 메서드를 이용하려면 반드시 설정해야 하는 값이 있다.
        // Board[] 배열이나 boardIndex처럼 내부에서 생성하는 값이 있고,
        // Scanner 처럼 외부에서 받아야 하는 값이 있다.
        // 외부에서 "반드시 받아야 하는 값"은 생성자를 통해 입력 받도록 하면 된다.
        // 이것이 생성자가 필요한 이유이다.
        // 즉, 객체가 작업하는데 필수적으로 요구되는 값을 준비시키는 역할을 수행하는게
        // 바로 "생성자"이다!
        
        // BoardController 객체를 생성할 때
        // 필수 값을 반드시 입력 받도록 선언한다.
        // 필수 값이 설정되어 있어야만 작업을 수행할 수 있기 때문이다.
        this.keyScan = scanner;
    }
    
    

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
        board.createdDate = Date.valueOf(this.keyScan.nextLine());
    
        this.boards[this.boardIndex++] = board;
    }
    
    void onBoardList() {
        System.out.println("[게시글 목록]");
        for (int i = 0; i < this.boardIndex; i++) {
            if (this.boards[i] == null) continue; 
            System.out.printf("%d, %s, %s\n", 
            i, this.boards[i].title, this.boards[i].createdDate);
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
            System.out.printf("등록일 : %s\n", board.createdDate);
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

// ver13 - 게시물 등록할 때 등록일의 문자열을 Date객체로 만들어 저장한다.