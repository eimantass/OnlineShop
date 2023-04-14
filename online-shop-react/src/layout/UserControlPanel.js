import './css/AdminEditPage.css';
import { Link, useParams, useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import userService from '../services/user.service';

const UserControlPanel = () => {
  console.log(useParams());
  const { id } = useParams();
  const [customers, setCustomers] = useState([]); // Added state for customers
  const [successMessage, setSuccessMessage] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [customersResponse] = await Promise.all([
          userService.getCustomerByIdMethod(id), // Fetching customer data from API
        ]);
        setCustomers(customersResponse.data); // Setting the fetched customers data to state
      } catch (error) {
        console.log(error);
      }
    };
    fetchData();
  }, [id]);

  // Define separate functions for each input field

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };
  const handleNumberChange = (e) => {
    setNumber(e.target.value);
  };
  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const [newEmail, setEmail] = useState('');
  const [newNumber, setNumber] = useState('');
  const [newPassword, setPassword] = useState('');

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    const newCustomerData = {
      email: newEmail,
      password: newPassword,
      number: newNumber,
      
    };

    console.log('newCustomerData:', newCustomerData); // Debugging statement

    try {
      const response = await userService.updateCustomerMethod(id, newCustomerData); // Updating customer data
      console.log('Customer updated successfully:', response.data);
      setSuccessMessage('User updated successfully.'); // Set success message
      setTimeout(() => {
        setSuccessMessage(''); // Clear success message after 2 seconds
        navigate('/customer'); // Redirect to /customers page
      }, 2000);
    } catch (error) {
      console.log('Error updating customer:', error);
      // Show error message to user
    }
  };

  return (
    <div className="table-container">
      <Link to="/customer" className="btn btn-primary">
        Back to Customer Board
      </Link>

      <br></br>

      {/* Render customer data */}
      <li>
        <b>E-mail</b> {customers.email}
      </li>
      <li>
        <b>Number:</b> {customers.number}
      </li>
      <li>
        <b>Money:</b> {customers.money}
      </li>

      <br></br>

        <h2>Update User Form:</h2>
        <form onSubmit={handleFormSubmit}>
          
          <label className="form-label">
            Email:
            <input className="form-control" 
                  type="email" 
                  value={newEmail} 
                  onChange={handleEmailChange}
                  style={{ width: '500px' }} />
          </label>
          <label className="form-label">
            Tel.number:
            <input className="form-control" 
                   type="number" 
                   value={newNumber} 
                   onChange={handleNumberChange}
                   style={{ width: '500px' }} />
          </label>
          <label className="form-label">
            Password:
            <input className="form-control" 
                   type="password" 
                   value={newPassword} 
                   onChange={handlePasswordChange}
                   style={{ width: '500px' }} />
          </label>
          
          <button className="btn btn-primary" type="submit">Update</button>
        </form>

        {successMessage && (
          <p className="success-message">{successMessage}</p>
        )}
        {/* Render error message */}
     
    </div>
  );
}

export default UserControlPanel;