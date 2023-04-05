import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


import '../css/App.css'
import ProductList from "../layout/ProductList";

export function Prekes() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Prekes</h1>
        <ProductList/>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }
