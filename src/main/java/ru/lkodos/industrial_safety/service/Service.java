package ru.lkodos.industrial_safety.service;

import ru.lkodos.industrial_safety.dao.ServiceDao;

import java.util.List;

public class Service {

    private static final Service INSTANCE = new Service();

    private static final ServiceDao serviceDao = ServiceDao.getINSTANCE();

    private Service() {
    }

    public List<String> getCorrectAnswer(int id) {
        return serviceDao.getCorrectAnswer(id);
    }

    public List<String> getAnswerOptions(int id) {
        return serviceDao.getAnswerOptions(id);
    }

    public String getQuestionById(int id) {
        return serviceDao.getQuestionById(id).getQuestion();
    }

    public int getNumberOfQuestions() {
        return serviceDao.getNumberOfQuestions();
    }

    public static Service getINSTANCE() {
        return INSTANCE;
    }
}