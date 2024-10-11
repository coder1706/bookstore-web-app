import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/home" element={<Home />} />
          <Route path="/user/login" element={<Login />} />
          <Route path="/user/register" element={<Register />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
