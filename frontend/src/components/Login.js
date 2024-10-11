import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();


    const formData = new URLSearchParams();
    formData.append('username', username);
    formData.append('password', password);

    try {
      const response = await fetch('http://localhost:8080/user/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
        credentials: 'include',
        body: formData.toString(),
      });

        if (response.ok) {
          console.log('Login successful');
          navigate("/home"); // Redirect to home after successful login
        } else {
          alert("Login failed");
        }
    }
    catch (error) {
        console.error('Error:', error);
    }
  };

  return (
    <div>
        <h1>Login Page</h1>    
        <form onSubmit={handleLogin}>
        <div>
            <label>Username:</label>
            <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            />
        </div>
        <div>
            <label>Password:</label>
            <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            />
        </div>
        <button type="submit">Login</button>
        </form>
    </div>
  );
};

export default Login;
