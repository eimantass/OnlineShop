import TopMenu from "../layout/TopMenu";
import SeachAndLogo from "../layout/searchandlogo";
import FooterMenu from "../layout/FooterMenu";


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