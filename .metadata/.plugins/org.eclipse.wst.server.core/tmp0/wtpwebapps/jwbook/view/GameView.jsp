<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>미니게임</title>
</head>
<body>
    <h1>★가위 바위 보★</h1>
    <form action="GameController" method="post">
        <label for="move">당신의선택은? :</label>
        <select name="move" id="move">
            <option value="ROCK">바위</option>
            <option value="PAPER">보</option>
            <option value="SCISSORS">가위</option>
        </select>
        <button type="submit">Play</button>
    </form>
</body>
</html>
