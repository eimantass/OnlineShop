import './css/AdminEditPage.css';
import {Link, useParams} from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './css/Customers.css';



const TestPage = () => {
  console.log(useParams());
  const {id} = useParams();
  const [customers, setCustomers] = useState([]);


  useEffect(() => {
    axios.get('http://localhost:8080/api/user-access/customers/'+id)
      .then(useR => setCustomers(useR.data))
      .catch(err => console.log(err));
  }, []);

  const [newUsername, setUsername] = useState('');
  const [newEmail, setEmail] = useState('');
  const [newNumber, setNumber] = useState('');
  const [newPassword, setPassword] = useState('');
  const [newMoney, setMoney] = useState('');
  const [newRole, setRole] = useState('');

  const handleFormSubmit = (e) => {
    e.preventDefault();
    const newCustomerData = { newUsername, newEmail, newPassword, newNumber, newMoney, newRole};

    axios.post('http://localhost:8080/api/user-access/customers/'+id, newCustomerData)
      .then((response) => {
        console.log('Customer registered successfully:', response.data);
      })
      .catch((error) => {
        console.log('Error registering customer:', error);
        // Show error message to user
      });
  };

  return (
<div className="table-container">
  <ul>
    <li>
       {id}
    </li>
    <li>
  <Link to='/controll-panel'>back to list</Link>
    </li>
    <li>
      hello
    </li>
    <li>{customers.id}</li>
    <li>{customers.username}</li>
    <li>{customers.email}</li>
    <li>{customers.number}</li>
    <li>{customers.money}</li>
    <li>{customers.role}</li>


    <h1>change value to</h1>
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
      <input type="text" value={newNumber} onChange={(e) =>setNumber(e.target.value)}/>
    </label>
    <label>
      Password:
      <input type="text" value={newPassword} onChange={(e) =>setPassword(e.target.value)}/>
    </label>
    <label>
      Money:
      <input type="text" value={newMoney} onChange={(e) =>setMoney(e.target.value)}/>
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

export default TestPage;