import Categories from "../../components/categories-menu";
import MobilePhonesProductList from "../../components/mobilePhones-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function MobilePhones() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <MobilePhonesProductList/>
      </div>
        
      );
      
    }