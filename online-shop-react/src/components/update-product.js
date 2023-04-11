import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ProductService from "../services/product.service";

function UpdateProduct() {
  const { id } = useParams();
  const [product, setProduct] = useState({});
  const [brands, setBrands] = useState([]); // Added state for brands
  const [message, setMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [productResponse, brandsResponse] = await Promise.all([
          ProductService.getProductById(id), // Fetching name, price, description, photo from API
          ProductService.getBrands(), // Fetching brands from API
      
        ]);
        setProduct(productResponse.data);
        setBrands(brandsResponse.data); // Setting the fetched brands to state
      
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [id]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setProduct((prevState) => ({
      ...prevState,
      [name]: name === 'brand' ? String(value) : value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
  
    try {
      const { id, ...productData } = product;
      const updatedProduct = { ...productData };
      await ProductService.updateProduct(id, updatedProduct);
      setMessage("The product was updated successfully!");
      navigate("/home");
    } catch (error) {
      setMessage("Could not update the product. Please try again.");
      console.log(error);
    }
  };

  return (
    <main>
      <h2 className="center">Update Product:</h2>
      {message && <p>{message}</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            id="name"
            type="text"
            name="name"
            value={product.name || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
      <label htmlFor="brand">Brand:</label>
        <select
           id="brand"
           name="brand"
           value={product.brand || ''}
           onChange={handleInputChange}
           >
       <option value="">Select a brand</option>
           {brands.map((brand) => (
           <option key={brand} value={brand}>
           {brand}
       </option>
    ))}
  </select>
</div>
        <div>
          <label htmlFor="price">Price:</label>
          <input
            id="price"
            type="number"
            name="price"
            value={product.price || ''}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <textarea
            id="description"
            name="description"
            value={product.description || ''}
            onChange={handleInputChange}
          ></textarea>
        </div>

        <div>
          <label htmlFor="photo">Photo:</label>
          <input
            id="photo"
            type="text"
            name="photo"
            value={product.photo || ''}
            onChange={handleInputChange}
          />
        </div>
        {/* <div>
          <label htmlFor="category">Category:</label>
          <select
                id="category"
                name="category"
                value={product.category || ''}
                onChange={handleInputChange} >
                <option value="">Select a category</option> 
                 {categories.map((category) => (
                <option key={category} value={category}>
                 {category}
               </option>
  ))}
</select>
        </div> */}
        <button type="submit">Update Product</button>
      </form>
    </main>
  );
}

export default UpdateProduct;