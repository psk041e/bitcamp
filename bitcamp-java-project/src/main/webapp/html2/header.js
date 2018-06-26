// div#header 태그에 /html/header.html 내용을 삽입한다.
$.get("/bitcamp-java-project/html2/header.html", (data) => {
	$("#header").html(data);
	loadLoginUser();
});

function loadLoginUser() {
	$.getJSON("/bitcamp-java-project/json/auth/loginUser", (data) => {
		if (data == "") 
			location.href = "/bitcamp-java-project/html2/auth/login.html";
		else {
			$("#username").text(data.id);
			$("#logoutBtn").click((e) => { // 
				window.alert("okok");
				e.preventDefualt(); // 클릭했을 때 원래 하던 일이 있는데 그것을 하지 말라!
				// a태그는 주어진 링크를 서버에 보내게 되어있다. 이것을 하지 말라.
				e.get("/bitcamp-java-project/html2/auth/logout", () => {
					location.href = "bitcamp-java-project/html2/auth/login/html";
				});
			});
		}
	});
}