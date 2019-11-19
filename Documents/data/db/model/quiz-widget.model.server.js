const mongoose = require('mongoose');
quizWidgetSchema = require('./quiz-widget.shcema.server');

const quizWidgetModel = mongoose.model('QuizWidgetModel', quizWidgetSchema);

module.exports = quizWidgetModel;
