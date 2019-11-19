const mongoose = require('mongoose');
const quizWidgetModel = require('../models/quiz-widget.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');
const studentModel = require('../models/student.model.server');
const assert = require('assert');


createStudent = student =>
    studentModel.create(student);


deleteStudent = id =>
    studentModel.remove({_id: id});


createQuestion = question =>
    questionModel.create(question);


deleteQuestion = id =>
    questionModel.remove({_id: id});

answerQuestion = answer =>
    answerModel.create(answer);


deleteAnswer = id =>
    answerModel.remove({_id: id});


findAllStudents = () => 
    studentModel.find();


findStudentById = id =>
    studentModel.findById(id);


findAllQuestions = () =>
    questionModel.find();


findQuestionById = id =>
    questionModel.findById(id);


findAllAnswers = () =>
    answerModel.find();


findAnswerById = id =>
    answerModel.findById(id);


findAnswerByStudent = studentId =>
    answerModel.find({student: studentId});


findAnswerByQuestion = questionId =>
    answerModel.find({question: questionId});


module.exports = {truncateDatabase, populateDatabase, createStudent, deleteStudent, createQuestion, deleteQuestion, answerQuestion,
                  deleteAnswer, findAllStudents, findStudentById, findAllQuestions, findQuestionById, findAllAnswers,
                  findAnswerById, findAnswerByStudent, findAnswerByQuestion};



truncateDatabase = () =>

studentModel.remove(function (err, data) {
        if (err){
            throw err;
        } else {
            console.log('Documents deleted' + data);
        }

    });

answerModel.remove(function (err, data) {
        if (err) {
            throw err;
        } else {
            console.log('Documents deleted' + data);
        }
    });
questionModel.remove(function (err, data) {
        if (err) {
            throw err;
        } else {
            console.log('Documents deleted' + data);
        }
    });
quizWidgetModel.remove(function (err, data) {
        if (err) {
            throw err;
        } else {
            console.log('Documents deleted' + data);
        }
    });


populateDatabase = () => {
    return populateStudent().then(
        () => populateQuestion()).then(
            () => polulateAnswer());
};
populateStudent = () => {
    return createStudent({
        _id: 123,
        username: 'alice',
        password: 'alice',
        firstName: 'Alice',
        lastName: 'Wonderland',
        gradYear: 2020,
        scholarship: 15000
    }).then(newUser => console.log(newUser)).then(
        createStudent({
            _id: 234,
            username: 'bob',
            password: 'bob',
            firstName: 'Bob',
            lastName: 'Hope',
            gradYear: 2021,
            scholarship: 12000
        }).then(newUser => console.log(newUser)))};
    populateQuestion = () => {
        return createQuestion({
        _id: 321,
        question: 'Is the following schema valid?',
        points: 10,
        questionType: 'TRUE_FALSE',
        trueFalse:
            {
                _id: 321,
                isTrue: false
            }
    }).then(newQuestion => console.log(newQuestion)).then(
            createQuestion({
                _id: 432,
                question: 'DAO stands for Dynamic Access Object.',
                points: 10,
                questionType: 'TRUE_FALSE',
                trueFalse:
                    {
                        _id: 432,
                        isTrue: false
                    }
            }).then(newQuestion => console.log(newQuestion)).then(
                createQuestion({
                    _id: 543,
                    question: 'What does JPA stand for?',
                    points: 10,
                    questionType: 'MULTIPLE_CHOICE',
                    multipleChoice:
                        {
                            _id: 543,
                            choices: 'Java Persistence API,Java Persisted Application,JavaScript Persistence API,JSON Persistent Associations',
                            correct: 1
                        }
                }).then(newQuestion => console.log(newQuestion)).then(
                    createQuestion({
                        _id: 654,
                        question: 'What does ORM stand for?',
                        points: 10,
                        questionType: 'MULTIPLE_CHOICE',
                        multipleChoice:
                            {
                                _id: 654,
                                choices: 'Object Relational Model,Object Relative Markup,Object Reflexive Model,Object Relational Mapping',
                                correct: 4
                            }
                    }).then(newQuestion => console.log(newQuestion)))))};


    polulateAnswer = () => {
    answerQuestion({
        _id: 123,
        student: 123,
        question: 321,
        trueFalseAnswer: true
        }, {studentId:123}, {questionId:321}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 234,
        student: 123,
        question: 432,
        trueFalseAnswer: false
    }, {studentId: 123}, {questionId: 432}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 345,
        student: 123,
        question: 543,
        multipleChoiceAnswer: 1
    }, {studentId: 123}, {questionId: 543}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 456,
        student: 123,
        question: 654,
        multipleChoiceAnswer: 2
    }, {studentId: 123}, {questionId: 654}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 567,
        student: 234,
        question: 321,
        trueFalseAnswer: false
    }, {studentId: 234}, {questionId: 321}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 678,
        student: 234,
        question: 432,
        trueFalseAnswer: true
    }, {studentId: 234}, {questionId: 432}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 789,
        student: 234,
        question: 543,
        multipleChoiceAnswer: 3
    }, {studentId: 234}, {questionId: 543}).then(newQuestion => console.log(newQuestion));
    answerQuestion({
        _id: 890,
        student: 234,
        question: 654,
        multipleChoiceAnswer: 4
    }, {studentId: 234}, {questionId: 654}).then(newQuestion => console.log(newQuestion));
};



