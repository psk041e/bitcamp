# 페이스북 메신저 챗봇 만들기

## 예제 프로젝트 다운로드
- 페이스북 예제 파일ㅇ르 깃허브에서 가져온다.
  - 'git clone https://github.com/fbsamples/messenger-platform-samples.git'
- 예제 프로젝트를 개인 깃허브 저장소로 복사하고 이름을 바꾼다.
  -예) bitcamp-facebook-chatbot
- gradle로 이클립스 설정 파일을 만든 후 이클립스로 임포트한다.

## 토큰 값 설정
- 페이지에 접근할 때 사용할 토큰 값을 리눅스 서버에 설정한다.
  - 페이지를 생성한 후 페이스북 앱에 메신저를 설정하면 페이지에 대한 접근 코드를 얻을 수 있다.
  - '~/bash_prifile' 파일에 설정한다.
  - 보통 환경 변수 'PAGE_ACCESS_TOKEN'으로 지정한다.
- 페이스북 앱에 메신저 API를 추가할 때 검증할 코드를 설정한다.
  - '~/bash_prifile' 파일에 설정한다.
  - 보통 환경 변수 'VERIFY_TOKEN'으로 지정한다.
  
## node.js 설치
- nodejs.org 사이트에서 안내하는 대로 설치하라!

## linux 서버에서 페이지북 메신저 챗봇 실행
-nodejs를 사용하여 챗봇을 실행한다.
  - ~/git/bitcamp/bitcamp-faceboot-chatbot/ 로 이동한다.
  - 'npm install' 실행하여 노드 모듈을 설치한다.
  - 'nodejs.

## 페이스북 페이지를 생성한다.
가상의 대화 상대 역할을 할 페이지를 생성한다.

## 페이스북 앱에 메신저 API를 추가한다.
- 페이스북 앱이 없으면, 새로 만들라.

페이스북 페이지 토큰
EAADCrV09iEcBADynEYkOKnxV0QQ2Y9oipkLYJSBo34ZCtpZB2mWZCFOqvxNRkZBDMFGCbR5J3ZC3ZAyhvTGofPBBFGnt9hPZBrnzKNGU6ruWfwly2NT2nnvZARFCQZA3ZBZAFJUVt6t9U5ZBUnbGJ9CeFwjgVYdZCyiUcMihynIdYzE5MAgZDZD

