<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
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

        <h2>공공 api 해썹 인증기관 정보를 이용한 음식조회<h2>
        <h3>음식 이름 입력(검색버튼 누른후 잠시 대기하세요)</h3>
            <form action="/api/foodserch" method="POST">
                <label for="food">음식명:</label>
                <input type="text" id="food" name="food" placeholder="음식명을 입력하세요" required>

                <br>

                <button type="submit">전송</button>
            </form>
</body>
</html>