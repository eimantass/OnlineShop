import React from 'react';

function CartView(props) {
  const { cart, removeFromCart } = props;

  if (!cart) {
    return <div>Cart is empty</div>;
  }

  const totalPrice = cart.reduce((total, item) => total + item.product.price * item.quantity, 0);

  return (
    <div>
      <h2>Cart</h2>
      <div>Number of items: {cart.length}</div>
      <div>Total price: {totalPrice}</div>
      <ul>
        {cart.map((item, index) => (
          <li key={index}>
            {item.product.name} - {item.product.price} x {item.quantity}{' '}
            <button onClick={() => removeFromCart(index)}>Remove from cart</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CartView;