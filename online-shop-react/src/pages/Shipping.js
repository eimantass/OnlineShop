import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


import '../css/App.css'

export function Shipping() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Shipping page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }