import './css/searchandlogo.css'; // Import your CSS file

function SeachAndLogo() {
    return (
<div className="logo-container">
        <a href="http://localhost:3000/">
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
    );
}

export default SeachAndLogo;