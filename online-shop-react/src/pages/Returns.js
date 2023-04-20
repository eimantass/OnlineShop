
import Categories from "../components/categories-menu";

export default function Returns() {
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>Returns page</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1>RETURNS AND REFUNDS</h1>
        <h2 style={{ fontWeight: 'bold' }}>30-Day Money-Back Guarantee</h2>
        <h3>
          We guarantee your satisfaction with all knivesandtools merchandise.
          You can always cancel your order at any time for a full refund within 30 days of delivery in accordance with your rights under the Consumer Protection (Distance Selling) Regulations 2000.
          Only unused items in original packaging may be returned for a full refund.
        </h3>
        <h3>
         In order to return goods please always contact us first at "Email" so we can send you the packing and shipping instructions.
          We will always refund you the same way you paid us (ie credit card or wire transfer).
          You will receive the refund within 14 days after we received the return shipment.
        </h3>
        <h3>
          NOTE: The 30-day money back guarantee does not apply to products that have been used and/or are damaged.
        </h3>
        {/*----------------------------------------------------------------------------------*/}
     
      </div>
    );
    
  }