import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


import '../css/App.css'
import CustomerList from "../layout/Customers";

export function Help() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        <h1 style={{textAlign: "center"}}>Help page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }