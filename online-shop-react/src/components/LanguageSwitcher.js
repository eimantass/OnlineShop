import React from 'react';
import { useTranslation } from 'react-i18next';

function LanguageSwitcher() {
  const { i18n } = useTranslation();

  const handleChangeLanguage = (lng) => {
    i18n.changeLanguage(lng);
  };

  return (
    <div className="d-flex justify-content-center">
  <button
    className="btn btn-primary mx-2"
    onClick={() => handleChangeLanguage(i18n.language === 'en' ? 'lt' : 'en')}
  >
    {i18n.language === 'en' ? 'LT' : 'EN'}
  </button>
</div>
  );
}

export default LanguageSwitcher;