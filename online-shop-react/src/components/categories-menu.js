import React from 'react';
import { Link } from 'react-router-dom';

import './css/Body.css';

function Categories() {
  return (
    <div>
      <div className="categories">
        <ul>
          <li><Link to="/processors">Processors(CPU)</Link></li>
          <li><Link to="/laptops">Laptops</Link></li>
          <li><Link to="/graphics-cards">Grpahics Cards</Link></li>
          <li><Link to="/mainboards">Mainboards</Link></li>
          <li><Link to="/mobile-phones">Mobile Phones</Link></li>
          <li><Link to="/monitors">Monitors</Link></li>
          <li><Link to="/printers">Printers</Link></li>
          <li><Link to="/consoles">Consoles</Link></li>
          <li><Link to="/games">Games</Link></li>
        </ul>
      </div>
    </div>
  );
}

export default Categories;