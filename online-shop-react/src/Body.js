import './css/Body.css';

function Body() {
  return (
    <div>
      <div className="logo-container">
        <a href="http://localhost:3000/#">
          <img
            src="https://thumbs.dreamstime.com/b/computer-logo-pc-logo-vector-computer-logo-pc-logo-vector-142583250.jpg"
            alt="Logo"
          />
        </a>

        <form action="/search" method="get" className="search-form">
          <input type="text" placeholder="Search..." name="q" />
          <button type="submit">Ieškoti</button>
        </form>
      </div>

      <div className="categories">
        <ul>
          <li><a href="http://localhost:3000/#">Staliniai kompiuteriai</a></li>
          <li><a href="http://localhost:3000/#">Nesiojamieji kompiuteriai</a></li>
          <li><a href="http://localhost:3000/#">Kompiuteriu komponentai</a></li>
          <li><a href="http://localhost:3000/#">Monitoriai</a></li>
          <li><a href="http://localhost:3000/#">Mobilieji telefonai</a></li>
          <li><a href="http://localhost:3000/#">Plansetiniai kompiuteriai</a></li>
          <li><a href="http://localhost:3000/#">Spausdintuvai</a></li>
          <li><a href="http://localhost:3000/#">Žaidimu konsoles</a></li>
          <li><a href="http://localhost:3000/#">Žaidimai</a></li>
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