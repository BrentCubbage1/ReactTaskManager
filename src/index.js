import { createRoot } from "react-dom/client";
import React, { StrictMode } from "react";
import "./styles.css";
import TaskBar from './TaskBar'


import Square from "./App";

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <Square />
    <TaskBar />
  </StrictMode>
);