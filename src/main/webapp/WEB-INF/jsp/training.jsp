<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <a id="${i}" href="/select?id=${i}#${i}"><c:out value="Вопрос ${i}"></c:out></a>
            </p>
        </c:forEach>
    </div>
    <div class="right">
        <span>Текст вопроса</span>
        <div class="with_border" id="question">
            <p><span>Вопрос ${requestScope.id}:</span> ${requestScope.question}</p>
        </div>
        <span>Варианты ответов</span>
        <div class="with_border" id="answer_options">
            <form action="/checker" method="post">
                <c:forEach var="answer" items="${requestScope.answerOptions}">
                    <p>
                        <input type="checkbox" name="answer" value="${answer}"> ${answer}
                    </p>
                </c:forEach>
                <button type="submit">Ответить</button>
            </form>
        </div>
        <span>Результат</span>
        <div class="with_border" id="result">
<%--            <c:if test="${isRight == true}">--%>
<%--                <c:out value="Верно"/>--%>
<%--            </c:if>--%>
<%--            <c:if test="${isRight == false}">--%>
<%--                <c:out value="Неверно"/><br>--%>
<%--                <c:out value="Правильный ответ:"/><br>--%>
<%--                <c:forEach var="correctAnswer" items="${requestScope.correctAnswer}">--%>
<%--                    <p><c:out value="${requestScope.correctAnswer}"/></p>--%>
<%--                </c:forEach>--%>
<%--            </c:if>--%>
        </div>
        <button onclick='location.href="index.html"'>На главную</button>
    </div>
</body>
</html>