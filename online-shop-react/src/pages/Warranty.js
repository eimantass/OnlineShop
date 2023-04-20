import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Warranty() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('warranty')}</h1>
        <h1>Damaged or defective items</h1>
        <h3>
          If you receive a damaged or defective item, we will promptly send you a replacement or issue you a full refund after you have returned the damaged or defective product.
          You will not be charged any additional shipping or handling fees for replacement shipments.
        </h3>
        <h3>
        All items on our website come with at least a 1-year warranty, unless specified otherwise.
        </h3>
        <h3>
         In order to return goods please always contact us first at "Email" so we can send you the packing and shipping instructions.
          We will always refund you the same way you paid us (ie credit card or wire transfer).
          You will receive the refund within 14 days after we received the return shipment.
        </h3>
      </div>
    );
    
  }