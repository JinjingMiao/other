const mongoose = require ('mongoose');
const studentSchema = require('./student.schema.server');
const questionSchema = require('./question.shcema.server');

const answerSchema = mongoose.Schema({
    _id: Number,
    student: {type: Number, ref: 'StudentModel'},
    question: {type: Number, ref: 'QuestionModel'},
    trueFalseAnswer: Boolean,
    multipleChoiceAnswer: Number
},{collection: 'answers'});
module.exports = answerSchema;