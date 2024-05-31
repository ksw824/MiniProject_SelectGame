<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>숫자 맞추기 게임</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #E6E6FA; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
            width: 300px;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        input[type="number"] {
            padding: 10px;
            width: calc(100% - 22px);
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .message {
            margin-top: 20px;
            padding: 10px;
            border-radius: 5px;
        }
        .high {
            background-color: #ffeb3b;
            color: #000;
        }
        .low {
            background-color: #03a9f4;
            color: #fff;
        }
        .correct {
            background-color: #4CAF50;
            color: white;
        }
        .error {
            background-color: #e74c3c;
            color: white;
        }
        .hint {
            margin-top: 10px;
            font-size: 14px;
            color: #888;
        }
        .score {
            margin-top: 10px;
            font-size: 16px;
            color: #333;
        }
        .footer {
            margin-top: 20px;
            font-size: 12px;
            color: #888;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>숫자 맞추기 게임</h1>
        <form method="post" action="/jwbook/numberGuess">
            <input type="number" name="guess" placeholder="1에서 100까지" required>
            <input type="submit" value="추측">
        </form>
        <div class="message <%= request.getAttribute("messageClass") %>">
            <%= request.getAttribute("message") %>
        </div>
        <div class="hint">
            <%= request.getAttribute("hint") %>
        </div>
        <div class="score">점수: <%= session.getAttribute("score") %></div>
        <div class="footer">당신은 과연 숫자를 맞출 수 있을까?</div>
    </div>
</body>
</html>
