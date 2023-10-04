import React, { useState } from 'react';
import { BrowserRouter,Routes, Route } from 'react-router-dom';
import './App.css';

import Home from './routes/Home';
import Login from './routes/Login';
import SignUp from './routes/SignUp';


function App() {
  return (
  <div>
    <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
      </Routes>
   </div>
  );
}

export default App;
