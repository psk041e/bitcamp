// div#header 태그에 /html/header.html 내용을 삽입한다.
var xhr = new XMLHttpRequest();
// false -> 서버에서 header.html을 가져오기 전까지는 다음 라인으로 넘어가지 못한다.
xhr.open("GET", "/bitcamp-java-project/html/header.html", false); // 동기 방식으로 요청한다.
xhr.send();
header.innerHTML = xhr.responseText; // 서버로부터 받은 header를 페이지에 삽입한다.

// 로그인 정보를 가져와서 span#username 태그에 사용자 아이디를 삽입한다.
var xhr = new XMLHttpRequest();
//비동기로 출력하면 빈테이블이라도 화면에 나오기 때문에 동기로 한다.
xhr.open("GET", "/bitcamp-java-project/json/auth/loginUser", false);  
xhr.send();
if (xhr.responseText == "") {
	// 이 header가 어디에 들어갈지 모르기 때문에 상대경로를 잡으면 안된다.
	// 절대경로를 사용한다.
	location.href = "/bitcamp-java-project/html/auth/login.html";
} else {
	var data = JSON.parse(xhr.responseText);
	username.textContent = data.id;
}

