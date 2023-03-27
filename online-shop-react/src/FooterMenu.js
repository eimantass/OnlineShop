import React from 'react';
import './css/FooterMenu.css'; // Import your CSS file

function FooterMenu() {
    return (
        <div className="aligner">
    {/* Create your footer menu */}
      <nav className="footer-menu">
        <ul className="menu">
          <li><a href="http://localhost:3000/ApieMus">Apie mus</a></li>
          <li><a href="#">Kontaktai</a></li>
          <li><a href="#">Pirkimo/Pardavimo taisyklės</a></li>
          <li><a href="#">Prekių pristatymas</a></li>
          <li><a href="#">Prekių grąžinimas</a></li>
          <li><a href="#">Garantinis aptarnavimas</a></li>
          <li><a href="#">Privatumo politika</a></li>
          <li><a href="#">Atsiliepimai</a></li>
          <li><a href="#">Pagalba</a></li>
        </ul>
      </nav>
    </div>
  );
}

export default FooterMenu;