
const mongoose = require('mongoose')
const TrueFalseSchema = require('./true-false.schema.server.js')
const MultipleChoiceSchema = require('./multiple-choice.schema.server.js')
modules.exports = mongoose.Schema({
 _id: Number,
 question: String,
 points: Number,
 questionType: String,
 multipleChoice: MultipleChoiceSchema,
 trueFalse: TrueFalseSchema
}, {collection: 'questions'})
