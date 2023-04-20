import React from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";

import App from "./App";
import FooterMenu from "./components/FooterMenu";

import './App.css';

const container = document.getElementById("root");
const root = createRoot(container);

root.render(
  <div className="FooterPlacer">
  <BrowserRouter>
    <App />
    <FooterMenu/>
  </BrowserRouter>
  </div>
);