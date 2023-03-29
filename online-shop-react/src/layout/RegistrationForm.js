import React, { useState } from 'react';
import axios from 'axios';

const RegistrationPage = () => {
  const [fullName, setFullName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [matchingPassword, setMatchingPassword] = useState('');

  const handleFormSubmit = (e) => {
    e.preventDefault();
    const newCustomer = { fullName, email, password, matchingPassword };

    axios.post('http://localhost:8080/add-customer', newCustomer)
      .then((response) => {
        console.log('Customer registered successfully:', response.data);
        // Redirect to login page or show success message
      })
      .catch((error) => {
        console.log('Error registering customer:', error);
        // Show error message to user
      });
  };

  return (
    <div>
      <h1>Registration Page</h1>
      <form onSubmit={handleFormSubmit}>
        <label>
          Full Name:
          <input type="text" value={fullName} onChange={(e) => setFullName(e.target.value)} required />
        </label>
        <label>
          Email:
          <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        </label>
        <label>
          Password:
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
        </label>
        <label>
          Confirm Password:
          <input type="password" value={matchingPassword} onChange={(e) => setMatchingPassword(e.target.value)} required />
        </label>
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default RegistrationPage;