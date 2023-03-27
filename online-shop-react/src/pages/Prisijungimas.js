import TopMenu from "../TopMenu";
import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";

import '../css/App.css'

export function Prisijungimas() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Prisijungimas funkcija</h1>
        <h1 style={{textAlign: "center"}}> 1</h1>
        <h1 style={{textAlign: "center"}}> 1 </h1>
        {/* rest of your contact page content */}
        <FooterMenu/>

        
      </div>
    );
    
  }