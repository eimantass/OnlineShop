import './css/TopMenu.css';

function TopMenu() {
    return (
      <div className="App">
        {/* Create your menu */}
        <nav>
          <ul className="menu">
            <li><a href="#">Home</a></li>
            <li><a href="#">Registracija</a></li>
            <li><a href="#">Prisijungimas</a></li>
            <li><a href="#">Prekės</a></li>
            <li><a href="#">Akcijos</a></li>
            <li><a href="#">Parduok nereikalingą techniką!</a></li>
            <li><a href="#">Pirkinių krepšelis</a></li>
          </ul>
        </nav>
  
      </div>
    );
  }
  
  export default TopMenu;