import { createRoot } from "react-dom/client";
import React, { StrictMode } from "react";
import "./styles.css";

import Square from "./App";

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <Square />
  </StrictMode>
);