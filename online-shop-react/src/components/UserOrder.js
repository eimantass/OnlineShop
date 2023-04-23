import React, { useEffect, useState } from "react";
import './css/product-list.css';
import CartService from "../services/cart.service";
import UserService from "../services/user.service";
import { useTranslation} from 'react-i18next';

function UserOrder() {
  const [inactiveCarts, setInactiveCarts] = useState([]);
  const currentUser = JSON.parse(localStorage.getItem('user'));

  useEffect(() => {
    async function fetchInactiveCarts() {
      try {
        const data = await CartService.GetInactiveCarts(currentUser.id);
        setInactiveCarts(data);
      } catch (error) {
        console.log(error);
      }
    }

    fetchInactiveCarts();
  }, []);

  const {t} = useTranslation();
  if (inactiveCarts.length === 0) {
    return (
      <main className="container">
        <h1>{t('noorders')}</h1>
      </main>
    );
  }
    

  return (
<main className="container">
  <h1>{t('orderhistory')}</h1>
  <div className="row">
    {inactiveCarts.map((cart) => (
      <div key={cart.id} className="col-md-4 mb-4">
        <div className="card">
          <div className="card-body">
            <h5 className="card-title">{t('ordernumber')}{cart.id}</h5>
            <p className="card-text"><b>{t('username1')}</b> {cart.user.username}</p>
            <p><b>{t('orderprice')}</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(cart.totalPrice)}</p>
           
            {/* <p className="card-text"><b>Date of Purchase:</b>  </p> */}
            {/*    {cart.items[0].date}  */}
            
            <h6 className="card-subtitle mb-2 text-muted"><b>{t('orderitems')}</b></h6>
            <ul className="list-group">
            {cart.items.map((item) => (
  <li key={item.id} className="list-group-item">
    <p><b>{t('productname')}</b> {item.product.name}</p>
    <p><b>{t('productprice')}</b> {new Intl.NumberFormat('de-DE', { style: 'currency', currency: 'EUR' }).format(item.product.price)}</p>
    <p><b>{t('quantity1')}</b> {item.quantity}</p>
    {item && item.date && <p><b>{t('date')}</b> {item.date}</p>}
  </li>
))}
            </ul>
          </div>
        </div>
      </div>
    ))}
  </div>
</main>
  );
}

export default UserOrder;