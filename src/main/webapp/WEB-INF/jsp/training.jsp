<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Training</title>
    <link rel="stylesheet" type="text/css" href="css/training.css">
</head>
<body>
<header>
    <p>
        Сборник вопросов по курсу "Эксплуатация электроустановок непромышленных потребителей До 1000 В -
        III группа"
    </p>
</header>
    <div class="with_border" id="all_questions">
        <c:forEach var="i" begin="1" end="${applicationScope.numberOfQuestions}">
            <p>
                <a id="${i}" href="<c:url value="/select?id=${i}#${i}"/>">Вопрос ${i}</a>

            </p>
        </c:forEach>
    </div>
    <div class="right">
        <span>Текст вопроса</span>
        <div class="with_border" id="question">
            <p><span>Вопрос ${applicationScope.id}:</span> ${applicationScope.question}</p>
        </div>
        <span>Варианты ответов</span>
        <div class="with_border" id="answer_options">
            <form action="<c:url value="/checker"/>" method="post">
                <c:forEach var="answer" items="${applicationScope.answerOptions}">
                    <p id="answer_option">
                        <input type="checkbox" name="answer" value="${answer}"> ${answer}
                    </p>
                </c:forEach>
                <button type="submit">Ответить</button>
            </form>
        </div>
        <span>Результат</span>
        <div class="with_border" id="result">
            <c:if test="${isRight == true}">
                <span id="correct">ВЕРНО</span><br><br>
            </c:if>
            <c:if test="${isRight == false}">
                <span id="incorrect">НЕВЕРНО</span><br><br>
                <span>Правильный ответ:</span><br>
                <ul>
                    <c:forEach var="correctAnswer" items="${applicationScope.correctAnswer}">
                        <li>${correctAnswer}</li>
                    </c:forEach>
                </ul>

            </c:if>
        </div>
        <button onclick='location.href="index.html"#${i}'>На главную</button>
    </div>
</body>
</html>