import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
    const [authData, setAuthData] = useState({ isAuthenticated: false, username: null });

    useEffect(() => {
      fetch('http://localhost:8080/home', {
        credentials: 'include', // Include cookies for session-based authentication
      })
        .then(response => response.json())
        .then(data => setAuthData(data))
        .catch(error => console.error('Error fetching authentication data:', error));
    }, []);

  return (
    <div>
      {authData.isAuthenticated  ? (
        <div>
          <h1>Welcome, {authData.username}!</h1>
          <form action="/logout" method="post">
            <button type="submit">Logout</button>
          </form>
        </div>
      ) : (
        <div>
          <h1>Welcome to the Online Bookstore!</h1>
          <Link to="/user/login">Login</Link> | <Link to="/user/register">Register</Link>
        </div>
      )}
    </div>
  );
};

export default Home;