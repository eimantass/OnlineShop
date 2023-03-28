import './css/TopMenu.css';

function TopMenu() {
    return (
      <>
      <div className="App">
        {/* Create your menu */}
        <nav>
          <ul className="menu">
            <li><a href="/">Home</a></li>
            <li><a href="/registracija">Registracija</a></li>
            <li><a href="/prisijungti">Prisijungimas</a></li>
            <li><a href="/prekes">Prekės</a></li>
            <li><a href="/akcijos">Akcijos</a></li>
            <li><a href="/parduok">Parduok nereikalingą techniką!</a></li>
            <li><a href="/krepselis">Pirkinių krepšelis</a></li>
          </ul>
        </nav>
  
      </div>

      </>
      
    );
  }
  
  export default TopMenu;