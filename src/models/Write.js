import mongoose from "mongoose";

const writeSchma = new mongoose.Schema({
  id: { type: String, requied: true, trim: true },
  name: { type: String, requied: true, trim: true },
  galaxy: { type: Date, trim: true },
  type: { type: String, trim: true },
});

const Write = mongoose.model("Write", writeSchma);
export default Write;
