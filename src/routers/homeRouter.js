import express from "express";
import { home } from "../controllers/home";

const homeRouter = express.Router();

homeRouter.get("/", home);

export default homeRouter;
