import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleRegister = (e) => {
    e.preventDefault();

    // Send registration details to backend
    fetch("http://localhost:8080/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    })
      .then((response) => {
        if (response.ok) {
          navigate("/login"); // Redirect to login page after successful registration
        } else {
          alert("Registration failed");
        }
      });
  };

  return (
    <div>
      <h1>Register</h1>
      <form onSubmit={handleRegister}>
        <label>Username:</label>
        <input type="text" value={username} onChange={e => setUsername(e.target.value)} required />
        <br />
        <label>Password:</label>
        <input type="password" value={password} onChange={e => setPassword(e.target.value)} required />
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
