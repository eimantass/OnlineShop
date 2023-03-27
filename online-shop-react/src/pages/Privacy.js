import FooterMenu from "../FooterMenu";
import SeachAndLogo from "../searchandlogo";
import TopMenu from "../TopMenu";

export function Privacy() {
    return (
      <div>
        <TopMenu/>
        <SeachAndLogo/>
        <h1>Privacy page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }