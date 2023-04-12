import './css/AdminEditPage.css';
import { Link, useParams, useNavigate } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import userService from '../services/user.service';
import './css/Customers.css';

const ControlPanel = () => {
  console.log(useParams());
  const { id } = useParams();
  const [customers, setCustomers] = useState([]);
  const navigate = useNavigate();
  const [successMessage, setSuccessMessage] = useState('');

  useEffect(() => {
    userService
      .getCustomerByIdMethod(id)
      .then(response => setCustomers(response.data))
      .catch(error => console.log(error));
  }, []);

  const [newUsername, setUsername] = useState('');
  const [newEmail, setEmail] = useState('');
  const [newNumber, setNumber] = useState('');
  const [newPassword, setPassword] = useState('');
  const [newMoney, setMoney] = useState('');
  const [newRole, setRole] = useState('');

  const handleFormSubmit = async e => {
    e.preventDefault();
    const newCustomerData = {
      username: newUsername,
      email: newEmail,
      password: newPassword,
      number: newNumber,
      money: newMoney
    };

    console.log('newCustomerData:', newCustomerData); // Debugging statement

    try {
      const response = await userService.updateCustomerMethod(id, newCustomerData);
      console.log('Customer updated successfully:', response.data);
      setSuccessMessage('User updated successfully.'); // Set success message
      setTimeout(() => {
        setSuccessMessage(''); // Clear success message after 2 seconds
        navigate('/customers'); // Redirect to /customers page
      }, 2000);
    } catch (error) {
      console.log('Error updating customer:', error);
      // Show error message to user
    }
  };

  return (
    <div className="table-container">
      <ul>
        <li>
          <Link to='/customers'>Back to customerlist</Link> 
        </li>
        
        <li><b>ID:</b>        {customers.id}</li>
        <li><b>Username:</b>  {customers.username}</li>
        <li><b>E-mail</b>     {customers.email}</li>
        <li><b>Number:</b>    {customers.number}</li>
        <li><b>Money:</b>     {customers.money}</li>
        {/* <li>{customers.role}</li> // Wont work, because there is no role in user table*/} 

        <h2>Update User:</h2>
        <form onSubmit={handleFormSubmit}>
          <label>
            Username:
            <input type="text" value={newUsername} onChange={(e) =>setUsername(e.target.value)}/>
          </label>
          <label>
            Email:
            <input type="email" value={newEmail} onChange={(e) =>setEmail(e.target.value)}/>
          </label>
          <label>
            Tel.number:
            <input type="number" value={newNumber} onChange={(e) =>setNumber(e.target.value)}/>
          </label>
          <label>
            Password:
            <input type="password" value={newPassword} onChange={(e) =>setPassword(e.target.value)}/>
          </label>
          <label>
            Money:
            <input type="number" value={newMoney} onChange={(e) =>setMoney(e.target.value)}/>
          </label>
          <label>
            Role:
            <input type="text" value={newRole} onChange={(e) =>setRole(e.target.value)}/>
          </label>
          <button type="submit">Update</button>
        </form>
      </ul>
    </div>
  );
}

export default ControlPanel;