mongoose = require('mongoose');
require('./db')();
mongoose.Promise = global.Promise;
const assert = require('assert');
const universityDao = require('../data/daos/university.dao.server');

universityDao.truncateDatabase()
    .then(() =>
        universityDao.populateDatabase()
    )
    .then(() =>
        testStudentsInitialCount())
    .then(() =>
        testQuestionsInitialCount())
    .then(() =>
        testAnswersInitialCount())
    .then(() =>
        testDeleteAnswer())
    .then(() =>
        testDeleteQuestion())
    .then(() =>
        testDeleteStudent());

const testStudentsInitialCount = () => {
     return universityDao.findAllStudents().then(reply =>
     assert.equal(reply.length, 2))
};

const testQuestionsInitialCount = () => {
    return universityDao.findAllQuestions().then(reply =>
    assert.equal(reply.length, 4))
};

const testAnswersInitialCount = () => {
    return universityDao.findAllAnswers().then(reply =>
        assert.equal(reply.length, 8))
};

const testDeleteAnswer = () => {
    return universityDao.deleteAnswer(890).then(() => {
        universityDao.findAllAnswers().then(reply =>
            assert.equal(reply.length, 7));
        universityDao.findAnswerByStudent(234)
            .then(reply => assert.equal(reply.length, 3));
    });
};

const testDeleteQuestion = () => {
    return universityDao.deleteQuestion(321).then(() => {
        universityDao.findAllQuestions().then(reply =>
            assert.equal(reply.length, 3));
    });
};

const testDeleteStudent = () => {
    return universityDao.deleteStudent(234).then(() =>
        universityDao.findAllStudents().then(reply =>
            assert.equal(reply.length, 1)))
};