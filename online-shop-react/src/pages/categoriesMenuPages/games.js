import Categories from "../../components/categories-menu";
import GamesProductList from "../../components/games-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function Games() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <GamesProductList/>
      </div>
        
      );
      
    }