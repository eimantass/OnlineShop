import React from 'react';
import { Link } from 'react-router-dom';

import './css/Body.css';

function Categories() {
  return (
    <div>
      <div className="categories">
        <ul>
          <li><Link to="/staliniai-kompiuteriai">Staliniai kompiuteriai</Link></li>
          <li><Link to="/nesiojamieji-kompiuteriai">Nesiojamieji kompiuteriai</Link></li>
          <li><Link to="/kompiuteriu-komponentai">Kompiuteriu komponentai</Link></li>
          <li><Link to="/monitoriai">Monitoriai</Link></li>
          <li><Link to="/mobilieji-telefonai">Mobilieji telefonai</Link></li>
          <li><Link to="/plansetiniai-kompiuteriai">Plansetiniai kompiuteriai</Link></li>
          <li><Link to="/spausdintuvai">Spausdintuvai</Link></li>
          <li><Link to="/zaidimu-konsoles">Žaidimu konsoles</Link></li>
          <li><Link to="/zaidimai">Žaidimai</Link></li>
        </ul>
      </div>
    </div>
  );
}

export default Categories;