import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './css/Customers.css';

function CustomerList() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/customers/all')
      .then(res => setCustomers(res.data))
      .catch(err => console.log(err));
  }, []);

  function handleDelete(id) {
    axios.delete(`http://localhost:8080/customers/${id}`)
      .then(() => setCustomers(customers.filter(c => c.id !== id)))
      .catch(err => console.log(err));
  }

  return (
<div class="table-container">
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Money</th>
        <th>Role</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {customers.map(c =>
        <tr key={c.id}>
          <td>{c.id}</td>
          <td>{c.fullName}</td>
          <td>{c.email}</td>
          <td>{c.number}</td>
          <td>{c.money}</td>
          <td>{c.role}</td>
          <td>
            <button class="btn-delete" onClick={() => handleDelete(c.id)}>Delete</button>
            <button class="btn-edit">Edit</button>
          </td>
        </tr>
      )}
    </tbody>
  </table>
</div>
  );
}

export default CustomerList;