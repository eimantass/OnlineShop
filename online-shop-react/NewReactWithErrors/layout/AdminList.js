import React, { useState, useEffect } from 'react';

function AdminList() {
  const [admins, setAdmins] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/admins')
      .then(response => response.json())
      .then(data => setAdmins(data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h2>Admin List</h2>
      <ul>
        {admins.map(admin => (
          <li key={admin.id}>
            <p>{admin.fullName}</p>
            <p>{admin.email}</p>
            <p>{admin.role}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AdminList;