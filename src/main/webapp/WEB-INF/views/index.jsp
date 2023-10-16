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
        <h2>음식 정보 주소 입력</h2>
            <form action="/api/foodserch" method="POST"> <!-- 이 폼의 데이터를 /submit 경로로 전송합니다. -->
                <label for="food">음식명:</label>
                <input type="text" id="food" name="food" placeholder="음식명을 입력하세요" required> <!-- 사용자가 주소를 입력할 수 있는 입력 상자를 생성합니다. -->

                <br>

                <button type="submit">전송</button> <!-- 전송 버튼을 생성합니다. -->
            </form>
</body>
</html>