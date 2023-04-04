import React, { useState, useEffect } from 'react';

function MainBody() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch('/products')
      .then(response => response.json())
      .then(data => setProducts(data));
  }, []);

  return (
    <main>
      <h2 className="center">Test Text1</h2>
      <h1 className="center">Text2</h1>
      <h1 className="center">Text3</h1>

      <ul>
        {products.map(product => (
          <li key={product.id}>{product.name}</li>
        ))}
      </ul>
    </main>
  );
}

export default MainBody;