import Categories from "../../components/categories-menu";
import LaptopProductList from "../../components/laptop-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function Laptops() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <LaptopProductList/>
      </div>
        
      );
      
    }