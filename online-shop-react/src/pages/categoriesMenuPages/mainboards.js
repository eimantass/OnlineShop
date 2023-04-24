import Categories from "../../components/categories-menu";
import MainboardsProductList from "../../components/mainboards-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function Mainboards() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <MainboardsProductList/>
      </div>
        
      );
      
    }