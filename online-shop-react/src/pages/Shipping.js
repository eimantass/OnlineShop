import Categories from "../components/categories-menu";

export default function Shipping() {
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>Shipping page</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1>SHIPPING AND SHIPPING COSTS</h1>
        <h3>
          We keep stock at "our groups" Group's local warehouse in "Place", the "Country".
          Every product has a stock label indicating if a product is in stock and ready for shipment or not.
          Orders will be shipped with "Shipping service1" and "Shipping service2" (who hand our parcels over to local mail carriers).
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1>PRICES AND VAT</h1>
        <h3>
          Prices listed on our website include VAT.
          Depending on the destination of the parcel the VAT will be deducted in the checkout.
          The same applies when ordering as a company with a valid VAT number.
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1>LOCAL LAWS AND REGULATIONS</h1>
        <h3>
        Every country has its own laws when it comes to knives and other items.
        When you order from "PageName" you agree to being fully accountable for importing the ordered item(s) to the country of destination.
        "PageName" is not liable when and if items are confiscated by authorities.
        </h3>
        {/*----------------------------------------------------------------------------------*/}
      
      </div>
    );
    
  }