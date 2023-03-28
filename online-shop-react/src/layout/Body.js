import { Link } from 'react-router-dom';
import './css/Body.css';

function Body() {
  return (
    <div>
      <div className="categories">
        <ul>
          <li><Link to="/prekes">Staliniai kompiuteriai</Link></li>
          <li><Link to="/prekes">Nesiojamieji kompiuteriai</Link></li>
          <li><Link to="/prekes">Kompiuteriu komponentai</Link></li>
          <li><Link to="/prekes">Monitoriai</Link></li>
          <li><Link to="/prekes">Mobilieji telefonai</Link></li>
          <li><Link to="/prekes">Plansetiniai kompiuteriai</Link></li>
          <li><Link to="/prekes">Spausdintuvai</Link></li>
          <li><Link to="/prekes">Žaidimu konsoles</Link></li>
          <li><Link to="/prekes">Žaidimai</Link></li>
        </ul>
      </div>

      <main>
        <h2 class="center">Test Text1</h2>

        <h1 class="center">Text2</h1>

        <h1 class="center">Text3</h1>

        <h1 class="center">Text4</h1>

        <h1>Text5</h1>

        <h1>Text6</h1>

        <h1>Text7</h1>

        <h1>Text8</h1>

        <h1>Text9</h1>

        <h1>Text10</h1>
      </main>
    </div>
  );
}

export default Body;