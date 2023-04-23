import React from 'react';
import { Link } from 'react-router-dom';
import './css/footerMenu.css';// Import your CSS file


import { useTranslation } from 'react-i18next';

function FooterMenu() {
  const { t } = useTranslation();
  return (
    <div className='aligner'>
      <nav className="footer-menu">
        <ul className="menu">
          <li><Link to="/about">{t('about')}</Link></li>
          <li><Link to="/contacts">{t('contact')}</Link></li>
          <li><Link to="/terms">{t('terms')}</Link></li>
          <li><Link to="/shipping">{t('shipping')}</Link></li>
          <li><Link to="/returns">{t('returns')}</Link></li>
          <li><Link to="/warranty">{t('warranty')}</Link></li>
          <li><Link to="/privacy">{t('privacy')}</Link></li>
          <li><Link to="/help">{t('help')}</Link></li>
        </ul>
      </nav>
    </div>
  );
}

export default FooterMenu;