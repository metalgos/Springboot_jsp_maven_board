<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
    <h2>jsp 게시판 프로젝트 입니다.</h2>
    <a href="/member/save">회원가입</a>
    <a href="/member/login">로그인</a>
    <a href="/member/">회원목록 조회</a>
    <br>
     <a href="/board/save">글작성</a>
        <a href="/board/">글목록</a>
        <a href="/board/paging">페이징 목록</a>
<br>
        <br>
        <hr>

        <h2>공공 api 해썹 인증기관 정보를 이용한 음식조회</h2>
        <h3>음식 이름 입력(검색버튼 누른후 잠시 대기하세요)</h3>
            <form action="/api/foodserch" method="POST">
                <label for="food">음식명:</label>
                <input type="text" id="food" name="food" placeholder="음식명을 입력하세요" required>

                <br>

                <button type="submit">전송</button>
            </form>

            <br>
                    <hr>

                    <h2>json 데이터를 서버에 전송하고 받아보기</h2>

                    <input type="date" id="startDate" />
                        <input type="date" id="endDate" />
                        <button onclick="processDates()">Submit</button>
<div id="result"></div>

                    <script>
                       function processDates() {
                                   const startDate = document.getElementById("startDate").value;
                                   const endDate = document.getElementById("endDate").value;

                                   // JSON 데이터 생성
                                   const requestData = {
                                       startDate: startDate,
                                       endDate: endDate
                                   };


                                   // 서버에 POST 요청 보내기
                                   $.ajax({
                                       type: "POST",
                                       url: "/json/date",  // 서버의 엔드포인트 URL
                                       data: JSON.stringify(requestData),
                                       contentType: "application/json",// Content-Type을 JSON으로 설정
                                       success: function (response) {
                                           // 서버 응답 처리
                                           // response 객체에 서버에서 보낸 JSON 데이터가 들어 있음

                                           document.getElementById("result").textContent = JSON.stringify(response);
                                       }
                                   });
                               }
                    </script>
</body>
</html>