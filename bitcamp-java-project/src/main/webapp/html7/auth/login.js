$("#loginBtn").click(() => {
	var data = {
		id : $("#fId").val(),
		password: $("#fPassword").val()
	};
	if ($(document.body).is("#fSaveId:checked")) {
		data.saveId = "true";
	}
	$.post(serverRoot + "/json/auth/login", data, (result) => { 
		// 비동기 -> 스레드에게 일을 시켜놓고 다음 라인으로 간다.
		//        스레드가 일이 끝나면, 서버에서 응답을하면 그제서야 실행을 한다.
		//        따라서 1111이 먼저 출력되고 그 다음 xxxx가 출력된다.
		if (result.state == "success")
			location.href = "../board/list.html";
		else 
			window.alert("로그인 실패!");
	}, "json");
});