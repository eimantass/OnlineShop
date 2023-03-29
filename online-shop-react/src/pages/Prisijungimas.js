import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";

import '../css/App.css'
import LoginForm from "../layout/LoginForm";

export function Prisijungimas() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1>Prisijungti</h1>
        <LoginForm/>
        <FooterMenu/>
      </div>
    );
    
  }