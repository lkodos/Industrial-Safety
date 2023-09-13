package ru.lkodos.industrial_safety.dao;

import ru.lkodos.industrial_safety.entity.Question;
import ru.lkodos.industrial_safety.util.ConnectionMnager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements Dao {

    private static final ServiceDao INSTANCE = new ServiceDao();

    private static final String GET_NUMBER_OF_QUESTIONS_SQL = "SELECT count(*) FROM questions";
    private static final String GET_QUESTION_SQL = "SELECT id, question FROM questions WHERE id = ?";
    private static final String GET_ANSWER_OPTIONS_SQL = "SELECT answer FROM answer_options WHERE question_id = ?";
    private static final String GET_CORRECT_ANSWER_SQL = "SELECT correct_answer FROM correct_answers WHERE question_id = ?";

    private ServiceDao() {
    }

    public List<String> getCorrectAnswer(int id) {
        try (Connection connection = ConnectionMnager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CORRECT_ANSWER_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> correctAnswer = new ArrayList<>();
            while (resultSet.next()) {
                correctAnswer.add(resultSet.getString("correct_answer"));
            }
            return correctAnswer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getAnswerOptions(int id) {
        try (Connection connection = ConnectionMnager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ANSWER_OPTIONS_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> answerOptions = new ArrayList<>();
            while (resultSet.next()) {
                answerOptions.add(resultSet.getString("answer"));
            }
            return answerOptions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Question getQuestionById(int id) {
        try (Connection connection = ConnectionMnager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_QUESTION_SQL)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Question question = new Question();
            if (resultSet.next()) {
                question.setId(resultSet.getInt("id"));
                question.setQuestion(resultSet.getString("question"));
            }
            return question;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getNumberOfQuestions() {
        try (Connection connection = ConnectionMnager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_NUMBER_OF_QUESTIONS_SQL)) {

            int numberOfQuestions = 0;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                numberOfQuestions = resultSet.getInt(1);
            }
            return numberOfQuestions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ServiceDao getINSTANCE() {
        return INSTANCE;
    }
}