import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './css/Customers.css';

function AdminControllMenu() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/user-access/users')
      .then(useR => setCustomers(useR.data))
      .catch(err => console.log(err));
  }, []);

  return (
<div className="table-container">
  <table className="table">
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
          <td>{c.username}</td>
          <td>{c.email}</td>
          <td>{c.number}</td>
          <td>{c.money}</td>
          <td>{c.role}</td>
        </tr>
      )}
    </tbody>
  </table>
</div>
  );
}

export default AdminControllMenu;