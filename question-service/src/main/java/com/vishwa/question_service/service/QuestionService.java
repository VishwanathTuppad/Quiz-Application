package com.vishwa.question_service.service;

import com.vishwa.question_service.dao.QuestionDao;
import com.vishwa.question_service.exception.NoQuestionFound;
import com.vishwa.question_service.exception.NoQuestionsFoundWithCategory;
import com.vishwa.question_service.model.Question;
import com.vishwa.question_service.model.QuestionWrapper;
import com.vishwa.question_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        List<Question> allQuestions = null;
        try {
            allQuestions = questionDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allQuestions;
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> questionsByCategory = questionDao.findByCategory(category);
        if (questionsByCategory.isEmpty()) {
            throw new NoQuestionsFoundWithCategory("No questions found for category :" + category);
        } else {
            return questionsByCategory;
        }
    }

    public void addQuestion(Question question) {
        questionDao.save(question);
    }

    public List<Integer> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> selectedQuestionNums = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
        return selectedQuestionNums;
    }

    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for (Integer id : questionIds) {
            questions.add(questionDao.findById(id)
                    .orElseThrow(() -> new NoQuestionFound("No question found for id :" + id)));
        }

        for (Question question : questions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }
        return wrappers;
    }

    public Integer getScore(List<Response> responses) {
        int right = 0;
        for (Response response : responses) {
            Question question = questionDao.findById(response.getId())
                    .orElseThrow(() -> new NoQuestionFound("No question found for id :" + response.getId()));
            if (response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return right;
    }
}
