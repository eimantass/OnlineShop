import FooterMenu from "../FooterMenu";
import TopMenu from "../TopMenu";
import SeachAndLogo from "../searchandlogo";

import '../css/App.css'

export function Returns() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Returns page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }