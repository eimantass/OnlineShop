import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


import '../css/App.css'
import RegistrationPage from "../layout/RegistrationForm";
import CustomerList from "../layout/Customers";

export function Registracija() {
    return (
      <div className="FooterPlacer">
        <TopMenu/>
        <SeachAndLogo/>
        {/* Registration Page */}
        <RegistrationPage/>

        <h1>Customers List</h1> 
        <CustomerList/>
        
        <FooterMenu/>
      </div>
    );
    
  }