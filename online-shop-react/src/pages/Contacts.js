import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

export function Contacts() {
    return (
      <div>
         <TopMenu/>
         <SeachAndLogo/>
        <h1>Kontaktai</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }