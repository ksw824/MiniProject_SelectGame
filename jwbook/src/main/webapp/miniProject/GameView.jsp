<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>미니게임</title>
    <style>
        body {
            background-image: linear-gradient(to right, #11998e, #38ef7d);
            font-family: 'Arial', sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #fff;
            font-size: 3em;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        .game-options {
            display: flex;
            justify-content: center;
            gap: 20px;
        }

        .game-option {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 10px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease;
        }

        .game-option img {
            width: 100px;
            height: 100px;
            cursor: pointer;
        }

        .game-option:hover {
            transform: scale(1.1);
        }
    </style>
</head>
<body>
    <h1>★ 가위 바위 보 게임 ★</h1>
    <div class="game-options">
        <form action="/jwbook/userControl" method="post" class="game-option">
            <input type="hidden" name="move" value="ROCK">
            <button type="submit" style="border: none; background: none; padding: 0;">
                <img src="${pageContext.request.contextPath}/images/rock.png" alt="바위">
            </button>
        </form>
        <form action="/jwbook/userControl" method="post" class="game-option">
            <input type="hidden" name="move" value="PAPER">
            <button type="submit" style="border: none; background: none; padding: 0;">
                <img src="${pageContext.request.contextPath}/images/paper.png" alt="보">
            </button>
        </form>
        <form action="/jwbook/userControl" method="post" class="game-option">
            <input type="hidden" name="move" value="SCISSORS">
            <button type="submit" style="border: none; background: none; padding: 0;">
                <img src="${pageContext.request.contextPath}/images/scissors.png" alt="가위">
            </button>
        </form>
    </div>
</body>
</html>
 --%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>미니게임</title>
    <style>
        body {
            background-color: #d6cfff;
            font-family: 'Arial', sans-serif;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 20px;
        }

        .container {
            background-color: #fff;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            padding: 20px;
            text-align: center;
            width: 600px;
        }

        .header {
            font-size: 2em;
            margin-bottom: 20px;
        }

        .choices {
            display: flex;
            justify-content: space-around;
            align-items: center;
            margin-bottom: 20px;
        }

        .choice {
            text-align: center;
        }

        .choice img {
            width: 100px;
            height: 100px;
            cursor: pointer;
        }

        .vs {
            font-size: 2em;
            margin: 0 20px;
        }

        .selection img {
            width: 150px;
            height: 150px;
        }

        .footer {
            display: flex;
            justify-content: space-around;
            margin-top: 20px;
        }

        .footer img {
            width: 80px;
            height: 80px;
            cursor: pointer;
            transition: transform 0.3s ease;
        }

        .footer img:hover {
            transform: scale(1.1);
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            ★ 가위 바위 보 게임 ★
        </div>
        <div class="choices">
            <div class="choice">
                <h2>YOU</h2>
                <img id="yourChoice" src="${pageContext.request.contextPath}/images/rock.png" alt="Your choice">
                <p id="yourChoiceText">Rock</p>
            </div>
            <div class="vs">VS</div>
            <div class="choice">
                <h2>COMPUTER</h2>
                <img id="computerChoice" src="${pageContext.request.contextPath}/images/rock.png" alt="Computer's choice">
                <p id="computerChoiceText">Rock</p>
            </div>
        </div>
        <div class="footer">
            <form action="/jwbook/userControl" method="post" style="margin: 0;">
                <input type="hidden" name="move" value="ROCK">
                <button type="submit" style="border: none; background: none; padding: 0;">
                    <img src="${pageContext.request.contextPath}/images/rock.png" alt="Rock">
                </button>
            </form>
            <form action="/jwbook/userControl" method="post" style="margin: 0;">
                <input type="hidden" name="move" value="PAPER">
                <button type="submit" style="border: none; background: none; padding: 0;">
                    <img src="${pageContext.request.contextPath}/images/paper.png" alt="Paper">
                </button>
            </form>
            <form action="/jwbook/userControl" method="post" style="margin: 0;">
                <input type="hidden" name="move" value="SCISSORS">
                <button type="submit" style="border: none; background: none; padding: 0;">
                    <img src="${pageContext.request.contextPath}/images/scissors.png" alt="Scissors">
                </button>
            </form>
        </div>
    </div>

    <script>
        // 이미지와 텍스트를 매핑
        const moves = ['ROCK', 'PAPER', 'SCISSORS'];
        const moveImages = {
            'ROCK': '${pageContext.request.contextPath}/images/rock.png',
            'PAPER': '${pageContext.request.contextPath}/images/paper.png',
            'SCISSORS': '${pageContext.request.contextPath}/images/scissors.png'
        };
        const moveTexts = {
            'ROCK': 'Rock',
            'PAPER': 'Paper',
            'SCISSORS': 'Scissors'
        };

        function getRandomMove() {
            return moves[Math.floor(Math.random() * moves.length)];
        }

        function updateChoices() {
            const yourMove = getRandomMove();
            const computerMove = getRandomMove();

            document.getElementById('yourChoice').src = moveImages[yourMove];
            document.getElementById('yourChoiceText').innerText = moveTexts[yourMove];

            document.getElementById('computerChoice').src = moveImages[computerMove];
            document.getElementById('computerChoiceText').innerText = moveTexts[computerMove];
        }

        // 일정 시간 간격으로 이미지 변경
        setInterval(updateChoices, 100);
    </script>
</body>
</html>
 