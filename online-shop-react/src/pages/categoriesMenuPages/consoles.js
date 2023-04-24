import Categories from "../../components/categories-menu";
import ConsolesProductList from "../../components/consoles-productlist";
import SeachAndLogo from "../../layout/searchandlogo";
export default function Consoles() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <ConsolesProductList/>
      </div>
        
      );
      
    }