import React from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter } from "react-router-dom";
import "./i18nextConf";
import { useTranslation, initReactI18next } from 'react-i18next';
import App from "./App";
import FooterMenu from "./components/FooterMenu";
import './App.css';
import i18n from "./i18nextConf";

i18n
  .use(initReactI18next)
  .init({
    recouces:{
      en:{
        translation: {
          "Welcome to react" : "Welcome to React and react-i18next"
        }
      },
      lt:{
        translation: {
          "Sveiki cia react" : "Sveiki cia react ir spring boot"
        }
      }
    },
    lng: document.querySelector('html').lang,
    fallbackLng: "en",

    interpolation: {
      escapeValue: false
    }
  });

  function App(){
    const { t } = useTranslation();
    return <h2>{t('Welcome to react')}</h2>;
  }

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
