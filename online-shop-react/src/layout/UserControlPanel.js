import './css/AdminEditPage.css';
import { Link, useParams, useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import userService from '../services/user.service';
import {useTranslation} from 'react-i18next';

const UserControlPanel = () => {
  console.log(useParams());
  
  const { id } = useParams();
  const [customers, setCustomers] = useState([]);
  const [successMessage, setSuccessMessage] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const [customersResponse] = await Promise.all([
          userService.getCustomerByIdMethod(id), // Fetching customer data from API
        ]);
        setCustomers(customersResponse.data); // Setting the fetched customers data to state
        setEmail(customersResponse.data.email || '');
        setNumber(customersResponse.data.number || '');
        //setPassword(customersResponse.data.password || '');
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
        navigate('/profile'); // Redirect to /customers page
      }, 2000);
    } catch (error) {
      console.log('Error updating customer:', error);
      // Show error message to user
    }
  };
  const { t } = useTranslation();
  return (
    <div className="table-container">
      <Link to="/profile" className="btn btn-primary">
      {t('back')}
      </Link>

      <br></br>

      {/* Render customer data */}
      <li>
        <b>{t('email1')}</b> {customers.email}
      </li>
      <li>
        <b>{t('number')}</b> {customers.number}
      </li>
      <li>
        <b>{t('money')}</b> {customers.money}
      </li>

      <br></br>

        <h2>{t('updateform')}</h2>
        <form onSubmit={handleFormSubmit}>
          
          <label className="form-label">
          {t('email1')}
            <input className="form-control" 
                  type="email" 
                  value={newEmail} 
                  onChange={handleEmailChange}
                  style={{ width: '500px' }} />
          </label>
          <label className="form-label">
          {t('number')}
            <input className="form-control" 
                   type="number" 
                   value={newNumber} 
                   onChange={handleNumberChange}
                   style={{ width: '500px' }} />
          </label>
          <label className="form-label">
          {t('password1')}
            <input className="form-control" 
                   type="password" 
                   value={newPassword} 
                   onChange={handlePasswordChange}
                   style={{ width: '500px' }} />
          </label>
          
          <button className="btn btn-primary" type="submit"> {t('update')}</button>
        </form>

        {successMessage && (
          <p className="success-message">{successMessage}</p>
        )}
        {/* Render error message */}
     
    </div>
  );
}

export default UserControlPanel;