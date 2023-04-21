import './css/searchandlogo.css'; // Import your CSS file
import {useState} from 'react'
import { useTranslation } from 'react-i18next';
import {useNavigate} from 'react-router-dom';

function SeachAndLogo() {
  const navigate = useNavigate();
  const [val, setVal] = useState('')
  const click = () => {
    if(val.length===0){
      navigate('/home')
    } else {
      navigate('/search/'+val)
    }
  }
  const change = event => {
    const newvalue = event.target.value
    setVal(newvalue)
  }
    const { t } = useTranslation();
    return (
<div className="logo-container">
        <a href="http://localhost:8081/">
          <img
            src="https://thumbs.dreamstime.com/b/computer-logo-pc-logo-vector-computer-logo-pc-logo-vector-142583250.jpg"
            alt="Logo"
          />
        </a>

        <div className="search-form">
              <input value={val} onChange={change}/>
              {/* <a href={'http://localhost:8081/search/'+val}  rel="noopener noreferrer"> */}
              <button onClick={click}>{t('search')}</button>
              {/*</a>*/}
        </div>
      </div>
    );
}

export default SeachAndLogo;