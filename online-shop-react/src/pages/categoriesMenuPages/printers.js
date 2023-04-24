import Categories from "../../components/categories-menu";
import PrintersProductList from "../../components/printers-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function Printers() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <PrintersProductList/>
      </div>
        
      );
      
    }