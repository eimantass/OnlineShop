import React from 'react';
import { Link } from 'react-router-dom';

import './css/Body.css';
import { useTranslation } from 'react-i18next';

function Categories() {
  const { t } = useTranslation();
  return (
    <div>
      <div className="categories">
        <ul>
          <li><Link to="/processors">{t('processors')}</Link></li>
          <li><Link to="/laptops">{t('laptops')}</Link></li>
          <li><Link to="/graphics-cards">{t('graphics')}</Link></li>
          <li><Link to="/mainboards">{t('mainboards')}</Link></li>
          <li><Link to="/mobile-phones">{t('phones')}</Link></li>
          <li><Link to="/monitors">{t('monitors')}</Link></li>
          <li><Link to="/printers">{t('printers')}</Link></li>
          <li><Link to="/consoles">{t('consoles')}</Link></li>
          <li><Link to="/games">{t('games')}</Link></li>
        </ul>
      </div>
    </div>
  );
}

export default Categories;