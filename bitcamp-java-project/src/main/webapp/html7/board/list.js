// 템플릿 엔진이 사용할 템플릿 데이터 가져오기
var trTemplateSrc = $("#tr-template").html();

// 위에서 준비한 템플릿 데이터를 가지고 HTML을 생성할 템플릿 엔진 준비
var templateFn = Handlebars.compile(trTemplateSrc);

$.getJSON(serverRoot + "/json/board/list", (data) => {
    //tableBody.innerHTML = templateFn({list:data});
	$(tableBody).html(templateFn({list:data}))
});
/*
$.ajax("../../json/board/list", {
    dataType: "json",
    success(data) {
        for (var item of data) {
            var tr = document.createElement("tr");
            tr.innerHTML = "<td>" + item.no + "</td>" + 
                "<td><a href='form.html?no=" + item.no + "'>" + item.title + "</a></td>" + 
                "<td>" + item.createdDate + "</td>";
            tableBody.appendChild(tr);
        }
    },
    error() {
        window.alert("실행 오류!");
    }
});
*/