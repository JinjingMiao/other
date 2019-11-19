const mongoose = require('mongoose');
questionSchema = require('./question.shcema.server');

const questionModel = mongoose.model('QuestionModel', questionSchema);

module.exports = questionModel;
