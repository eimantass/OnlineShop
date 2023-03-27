import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

export function Krepselis() {
    return (
      <div>
        <TopMenu/>
        <SeachAndLogo/>
        <h1>Krepselis page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }