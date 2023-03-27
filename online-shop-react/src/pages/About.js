import TopMenu from "../TopMenu";
import SeachAndLogo from "../searchandlogo";
import FooterMenu from "../FooterMenu";

export function About() {
    return (
      <div>
         <TopMenu/>
         <SeachAndLogo/>
        <h1>Apie Mus</h1>
        {/* rest of your contact page content */}
        <FooterMenu/>
      </div>
    );
    
  }