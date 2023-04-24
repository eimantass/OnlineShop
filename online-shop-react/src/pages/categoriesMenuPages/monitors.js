import Categories from "../../components/categories-menu";
import MonitorsProductList from "../../components/monitors-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function Monitors() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <MonitorsProductList/>
      </div>
        
      );
      
    }