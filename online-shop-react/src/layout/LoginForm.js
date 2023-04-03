import React, { useState } from "react";
import axios from "axios";
import './css/LoginForm.css';

function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8080/login",
        {
          username: username,
          password: password,
        },
        { withCredentials: true }
      );
      console.log("Logged in successfully", response);
    } catch (error) {
      console.error("Error logging in", error);
    }
  };

  return (
<form className="login-form" onSubmit={handleFormSubmit}>
  <div className="form-group">
    <label htmlFor="username">Username:</label>
    <input
      type="text"
      id="username"
      className="form-control"
      value={username}
      onChange={(event) => setUsername(event.target.value)}
    />
  </div>
  <div className="form-group">
    <label htmlFor="password">Password:</label>
    <input
      type="password"
      id="password"
      className="form-control"
      value={password}
      onChange={(event) => setPassword(event.target.value)}
    />
  </div>
  <button type="submit" className="btn btn-primary">Login</button>
</form>
  );
}

export default LoginForm;