// Stack : LIFO.(나중에 들어간것이 먼저 나온다.) push()/pop() -> 값을 넣고 꺼낸다.
package step12.ex03;

import step12.ex02.LinkedList;

// 스택 사용의 예: 
// - 웹 브라우저의 history 다룰 때
// - 웹 사이트에서 breadcrumb navigation 구현할 때 (헨젤과 그레텔에서 빵부스러기를 따라 간길을 표시한 것에서 따왔다.)
// - 웹 페이지 UI의 이벤트를 처리할 때
public class Stack extends LinkedList {
    public void push(Object value) { // 집어넣는다.
        this.add(value); 
        // 맨 끝에 추가하게 된다.
        // 추가적으로 하는것은 없다.
        // add를 포장했다고 보면 된다.
    }
    
    public Object pop() { // 꺼낸다.
        if (this.head == this.tail)
            return null;
            // size()를 사용하면 꺼낼따마다 사이즈를 호출한다는것은 매번 for문을 돌며 카운트해야 한다는 것이다.
            // head와 tail이 같으면 입력된 값이 없다. size를 호출하는것보다 낫다.
        Bucket removeBucket = this.tail.prev; // 이전 버킷 주소를 담아놓는다.
        if (this.tail.prev.prev != null) { // 리스트에서 중간 버킷 제거할 때
            this.tail.prev.prev.next = tail;
            this.tail.prev = this.tail.prev.prev; 
        } else { // 리스트에서 맨 처음 버킷을 제거할 때-> 값이 들어있는 버킷이 하나뿐인 경우
            head = tail;
            head.prev = null;
        }
        
        return removeBucket.value;
        // 맨마지막것을 지운다.
        // head부터 맨 끝에 도달할 때까지 반복문을 돌아 도달하면 처리한다. 
    }
}




