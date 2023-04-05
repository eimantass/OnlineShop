import React from 'react';
import './css/FooterMenu.css'; // Import your CSS file

function FooterMenu() {
    return (
  <div className='aligner'>
    {/* Create your footer menu */}
      <nav className="footer-menu">
        <ul className="menu">

          <li><a href="/about">Apie mus</a></li>
          <li><a href="/contacts">Kontaktai</a></li>
          <li><a href="/terms">Pirkimo/Pardavimo taisyklės</a></li>
          <li><a href="/shipping">Prekių pristatymas</a></li>
          <li><a href="/returns">Prekių grąžinimas</a></li>
          <li><a href="/warranty">Garantinis aptarnavimas</a></li>
          <li><a href="/privacy">Privatumo politika</a></li>
          <li><a href="/atsiliepimai">Atsiliepimai</a></li>
          <li><a href="/help">Pagalba</a></li>
        </ul>
      </nav>
    </div>
  );
}

export default FooterMenu;