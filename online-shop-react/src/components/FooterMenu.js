import React from 'react';
import { Link } from 'react-router-dom';
import './css/footerMenu.css'; // Import your CSS file

function FooterMenu() {
  return (
    <div className='aligner'>
      <nav className="footer-menu">
        <ul className="menu">
          <li><Link to="/about">Apie mus</Link></li>
          <li><Link to="/contacts">Kontaktai</Link></li>
          <li><Link to="/terms">Pirkimo/Pardavimo taisyklės</Link></li>
          <li><Link to="/shipping">Prekių pristatymas</Link></li>
          <li><Link to="/returns">Prekių grąžinimas</Link></li>
          <li><Link to="/warranty">Garantinis aptarnavimas</Link></li>
          <li><Link to="/privacy">Privatumo politika</Link></li>
          <li><Link to="/atsiliepimai">Atsiliepimai</Link></li>
          <li><Link to="/help">Pagalba</Link></li>
        </ul>
      </nav>
    </div>
  );
}

export default FooterMenu;