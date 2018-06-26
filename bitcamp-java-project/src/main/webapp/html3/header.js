// div#header 태그에 /html/header.html 내용을 삽입한다.
$.get("/bitcamp-java-project/html3/header.html", (data) => {
	$("#header").html(data);
	loadLoginUser();
});

function loadLoginUser() {
	$.getJSON("/bitcamp-java-project/json/auth/loginUser", (data) => {
		$("#username").text(data.id);
		$("#logoutBtn").click((e) => {
			e.preventDefault(); // 클릭했을 때 원래 하던 일이 있는데 그것을 하지 말라!
			$.get("/java106-java-project/json/auth/logout", () => {
				location.href = "/bitcamp-java-project/html3/auth/login.html";
			});
		});
	});
	jqxhr.fail() => {
		location.href = "/bitcamp-java-project/html3/auth/login.html";
	}
}




