import TopMenu from "../TopMenu";
import SeachAndLogo from "../searchandlogo";
import FooterMenu from "../FooterMenu";

import '../css/App.css'

export function About() {
    return (
      <div className="FooterPlacer">
         <TopMenu/>
         <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Apie Mus</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }