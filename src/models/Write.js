import mongoose from "mongoose";

const writeSchma = new mongoose.Schema({
  title: { type: String, requied: true, trim: true, maxLength: 80 }, // it's same code-> {type: String}
  description: { type: String, requied: true, trim: true, minLength: 20 },
  createdAt: { type: Date, required: true, default: Date.now },
});

const Write = mongoose.model("Write", writeSchma);
export default Write;
