// 자바스크립트 함수를 모아 놓은 라이브러리
//var jQuery = new Object();

// jquery는 함수이면서 객체일수 있다. 이렇게 바꿔도 똑같이 실행된다.
var jQuery = function(param) {
	var tags;
	if (param instanceof HTMLElement) { // 문자열이 아니라 HTMLElement로 초기화된 객체라면
		// 파라미터 값이 일반 태그라면 배열에 담고 도우미 함수를 붙여서 리턴한다. 
		tags = [param];
		
	} else if (param.startsWith("<")) {
		var tagName = param.substr(1, param.length - 2); // <pre> ==> 0, (5-2)
		tags = [document.createElement(tagName)]; // 태그가 한개 들어가 있는 배열
		// createElement는 태그를 하나만 리턴하고, querySelectorAll은 여러개를 리턴하기 때문에
		// 다루기가 힘들다 그래서 처음부터 배열로 받도록 한다.
		// [] => 빈 배열을 만들고 거기에 태그를 하나 생성해서 집어넣는다.
		
	} else if (param.startsWith(".")) {
		tags = document.querySelectorAll(param); 
		// html collection을 리턴한다. Node list, 일종의배열이다.
		// NodeList에는 innerHTML이 없다. 다루기가 까다롭다.
		
	} else if (param.startWith("#")) {
		tags = [document.querySelector(param)];
	}
	
	tags.html = function(value) {
		for (var tag of tags) { // tags가 이제 배열이기 때문에 무조건 반복문을 돌려야 한다.
			tag.innerHTML = value;
		}
		return tags; // 현업에서는 항상 작업을 한 다음 그 태그객체를 리턴하게 되어있다.
	};
	
	tags.appendTo = function(parent) {
		for (var tag of tags) {
			parent.appendChild(tag);
		}
		return tags;
	};
	
	tags.css = function(styleName, value) {
		for (var tag of tags) {
			tag.style[styleName] = value;
		}
		return tags;
	};
	
	tags.val = function(value) {
		if (arguments.length == 0) {
			return tags[0].value; // jquery는 찾은 태그가 여러개 있을 때는 첫번째 값만 리턴한다.
								  // jquery에서는 함수를 두가지 용도로 쓴다. -> 겟터, 셋터 
		}
		for (var tag of tags) {
			tag.value = value;
		}
		return tags;
	};
	
	tags.click = function(lietener) {
		for (var tag of tags) {
			tag.addEventListener("click", listener);
		}
		return tags;
	};
	
	
	return tags;
};

jQuery.ajax = function(url, settings) {
	// AJAX 정보를 초기화 시킨다.
	if (settings == undefined || settings == null) { // 안주거나 null이면 
		settings = {};
	}
	
	if (settings.method == undefined) settings.method = "GET";
	
	if (settings.dataType == undefined) settings.dataType = "text";
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
	    if (xhr.readyState == 4) {
	        if (xhr.status == 200) {
	        	if (settings.success == undefined) 
	        		return;

	        	// 서버에서 받은 데이터를 호출자가 원하는 대로 변환해서 
	        	// success()를 호출할 때 파라미터로 넘겨준다.
	        	if (settings.dataType == "text")
	        		settings.success(xhr.responseText); // 데이터 타입이 text라면 그대로 넣어주고
	        	else if (settings.dataType == "json")
	        		settings.success(JSON.parse(xhr.responseText)); // json이라면 json으로 바꿔서 넣어준다.
	        }else {
	        	if (settings.error)
	        		settings.error();
	        }
	    }
	};
	
	
	// POST 요청일 때는 데이터가 있으면 send로 넘겨주어야 하기 때문에 이와 같은 작업을 해야 한다.
	if (settings.method == "POST") {
		xhr.open(settings.method, url, true);
		// post 요청이라면, 데이터 타입을 알려주어야 한다.
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(jQuery.toQueryString(settings.data));

	} else { // GET 요청일 경우 url 뒤에 붙여주어야 한다.
		if (url.indexOf("?") != -1) {
			url += "&" + toQueryString(settings.data);
		} else {
			url += "?" + toQueryString(settings.data);
		}
		xhr.open(settings.method, url, true);
		xhr.send();
	}
};


jQuery2.toQueryString = function(obj) {
	var qs = ""; 
	if (obj) { 
		for (var key in obj) {
			if (qs.length > 0) qs += "&";
			qs += key + "=" + encodeURIComponent(settings.data(obj[key]);
		}
	}
}



jQuery.getJSON = function(url, p1, p2) { // p1: data, p2: success
	// 가장 많이 쓰는 세개를 받는다.
	// 개발자가 쓰기 좋게 한번 더 포장한다.
	
	// AJAX를 요청할 때 데이터를 요청할때와 그렇지 않을 때를 구분한다.
	// url은 무조건 필수이다. url과 p1이 넘어올수 있고, url과 p2가 넘어올수 있고, 모두 넘어올수 있다.
	// 함수와 데이터를 줄 때는 반드시 데이터 다음에 함수를 주어야 한다.
	//
	// 호출 예:
	if (p1 == undefined || typeof p1 != "function") {  
		// => getJSON("board/list");
		// => getJSON("board/list", {pageNo:1,pageSize:5});
		// => getJSON("board/list", {pageNo:1,pageSize:5}, function(data) {...});
		jQuery.ajax(url, {
			"data": p1,
			"dataType": "json", // 데이터 타입은 무조건 json이다.
			"success": p2
		});
	} else if (typeof p1 == "function") { // 데이터는 넘어오지 않고 함수만 넘어왔을 때
		// => getJSON("board/list", function(data) {...});
		jQuery.ajax(url, {
			"dataType": "json", // 데이터 타입은 무조건 json이다.
			"success": p1
		});
	}
};

jQuery.post = function(url, p1, p2, p3) { 
	var setting = {
			method: "POST"
	};
	if (arguments.length == 2) { // 파라미터가 두개 넘어왔을 때
		// url과 p1, url과 p2, url과 p3
		// 타입으로 구분해준다.
		if (typeof p1 == "function") settings.success = p1; // 함수인 경우
		else if (typeof p1 == "string") settings.dataType=p1; // 문자열인 경우
		else settings.data = p1; // 일반 객체인 경우
	} else if (arguments.length == 3) { // 파라미터를 세 개 넘겼을 때
		// url과 p1과 p2, url과 p1과 p3, url과 p2와 p3
		// p2를 기준으로 구분해본다.
		if (typeof p2 == "function") { // p1타입은 자동으로 일반 객체가 된다.
			// .post(url, data, function)
			settings.data = p1;
			settings.success = p2;
		} else if (typeof p2 == "string") {
			settings.dataType = p2;
			if (typeof p1 == "function") settings.success = p1; // .post(url, function, dataType)
			else settings.data = p1; // .post(url, data, dataType)
		}
	} else if (arguments.length == 4) {
		// .post(url, data, function, dataType)
		settings.data = p1;
		settings.success = p2;
		settings.dataType = p3;
	}
	
	uQyery.ajax(url, settings);
};

jQuery.get = function(url, p1, p2, p3) { 
	var setting = {
			method: "GET"
	};
	if (arguments.length == 2) {
		if (typeof p1 == "function") settings.success = p1; 
		else if (typeof p1 == "string") settings.dataType=p1;
		else settings.data = p1; 
	} else if (arguments.length == 3) { 
		if (typeof p2 == "function") { 
			// .get(url, data, function)
			settings.data = p1;
			settings.success = p2;
		} else if (typeof p2 == "string") {
			settings.dataType = p2;
			if (typeof p1 == "function") settings.success = p1; // .get(url, function, dataType)
			else settings.data = p1; // .get(url, data, dataType)
		}
	} else if (arguments.length == 4) {
		// .get(url, data, function, dataType)
		settings.data = p1;
		settings.success = p2;
		settings.dataType = p3;
	}
	
	uQyery.ajax(url, settings);
};


// 자바는 $ 를 특수기호로 치기 때문에 변수명, 함수명 등으로 사용하지 못하지만
// 자바스크립트에서는 가능하다.

// $가 독특하기 때문에 $로 변수를 사용하였다.
var $ = jQuery;  














