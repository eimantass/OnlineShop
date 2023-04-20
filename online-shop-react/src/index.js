import React from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";

import App from "./App";
import FooterMenu from "./components/FooterMenu";
import i18n from "i18next";
import { initReactI18next } from "react-i18next";

import './App.css';


i18n
  .use(initReactI18next)
  .init({
    resources: {
      en: {
        translation: require('./locales/en.json')
      },
      lt: {
        translation: require('./locales/lt.json')
      },
    },
    lng: "lt", // default language
    fallbackLng: "en",
    interpolation: {
      escapeValue: false
    }
  });

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