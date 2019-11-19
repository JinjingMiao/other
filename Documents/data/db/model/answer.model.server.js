const mongoose = require('mongoose');
answerSchema = require('./answer.schema.server');

const answerModel = mongoose.model('AnswerModel', answerSchema);

module.exports = answerModel;