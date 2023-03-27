import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

import '../css/App.css'

export function Terms() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Terms page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }
