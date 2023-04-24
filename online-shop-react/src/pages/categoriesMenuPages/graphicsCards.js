import Categories from "../../components/categories-menu";
import GraphicsCardsProductList from "../../components/graphics-cards-productlist";
import SeachAndLogo from "../../layout/searchandlogo";

export default function GraphicsCards() {
    return (
      <div>
        <Categories/>
        <SeachAndLogo/>
        <GraphicsCardsProductList/>
      </div>
        
      );
      
    }