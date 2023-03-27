import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

import '../css/App.css'

export function Help() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Help page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }