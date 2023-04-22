import React from 'react';
import { useTranslation } from 'react-i18next';

function LanguageSwitcher() {
  const { i18n } = useTranslation();

  const handleChangeLanguage = (lng) => {
    i18n.changeLanguage(lng);
  };

  return (
    <div>
      {i18n.language === 'en' ? (
        <button onClick={() => handleChangeLanguage('lt')}>LT</button>
      ) : (
        <button onClick={() => handleChangeLanguage('en')}>EN</button>
      )}
    </div>
  );
}

export default LanguageSwitcher;