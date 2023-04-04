import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";

import '../css/App.css'
import CartView from "../layout/Cart";

export function Krepselis() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Krepselis page</h1>
        <CartView/>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }