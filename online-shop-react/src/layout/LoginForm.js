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
<form class="login-form" onSubmit={handleFormSubmit}>
  <div class="form-group">
    <label for="username">Username:</label>
    <input
      type="text"
      id="username"
      class="form-control"
      value={username}
      onChange={(event) => setUsername(event.target.value)}
    />
  </div>
  <div class="form-group">
    <label for="password">Password:</label>
    <input
      type="password"
      id="password"
      class="form-control"
      value={password}
      onChange={(event) => setPassword(event.target.value)}
    />
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
  );
}

export default LoginForm;