import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

import '../css/App.css'

export function Atsiliepimai() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Atsileipimai page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }