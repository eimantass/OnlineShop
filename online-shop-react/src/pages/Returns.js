import FooterMenu from "../FooterMenu";
import TopMenu from "../TopMenu";
import SeachAndLogo from "../searchandlogo";

export function Returns() {
    return (
      <div>
        <TopMenu/>
        <SeachAndLogo/>
        <h1>Returns page</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }