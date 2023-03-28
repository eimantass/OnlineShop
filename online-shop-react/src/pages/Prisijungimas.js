import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


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