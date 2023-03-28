import './css/TopMenu.css';
import { Link } from 'react-router-dom';

function TopMenu() {
    return (
      <>
      <div className="App">
        {/* Create your menu */}
        <nav>
          <ul className="menu">
            <li><Link to="/">Home</Link></li>
            <li><Link to="/registracija">Registracija</Link></li>
            <li><Link to="/prisijungti">Prisijungimas</Link></li>
            <li><Link to="/prekes">Prekės</Link></li>
            <li><Link to="/akcijos">Akcijos</Link></li>
            <li><Link to="/parduok">Parduok nereikalingą techniką!</Link></li>
            <li><Link to="/krepselis">Pirkinių krepšelis</Link></li>
          </ul>
        </nav>
  
      </div>

      </>
      
    );
  }
  
  export default TopMenu;