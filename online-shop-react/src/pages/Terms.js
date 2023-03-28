import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


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
