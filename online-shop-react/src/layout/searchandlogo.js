import './css/searchandlogo.css'; // Import your CSS file
import {useState} from 'react'

function SeachAndLogo() {
  const [val, setVal] = useState('')
  const click = () => {
    //alert(val)
  }
  const change = event => {
    const newvalue = event.target.value
    setVal(newvalue)
  }

    return (
<div className="logo-container">
        <a href="http://localhost:3000/">
          <img
            src="https://thumbs.dreamstime.com/b/computer-logo-pc-logo-vector-computer-logo-pc-logo-vector-142583250.jpg"
            alt="Logo"
          />
        </a>

        <div className="search-form">
              <input value={val} onChange={change}/>
              <a href={'http://localhost:8081/search/'+val}  rel="noopener noreferrer">
              <button onClick={click}>Search</button>
              </a>
        </div>
      </div>
    );
}

export default SeachAndLogo;