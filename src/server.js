import express from "express";
import path from "path";
import morgan from "morgan";
import homeRouter from "./routers/homeRouter";

const app = express();
const logger = morgan("dev");

app.use(express.urlencoded({ extended: true })); 
app.use(express.static(path.join(__dirname, "public")));

app.use("/", homeRouter);

export default app;
