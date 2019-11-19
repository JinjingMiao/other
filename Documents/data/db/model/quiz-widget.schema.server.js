const mongoose = require('mongoose');
const questionSchema = require('./question.shcema.server');

const quizWidgetSchema = mongoose.Schema({
    questions: [{
        type: mongoose.Schema.Types.ObjectId,
        ref: 'QuestionModel'
    }]
}, {collection: 'question_widgets'});
