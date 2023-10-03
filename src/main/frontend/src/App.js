import React, { useState } from 'react';
import './App.css';
import { styled, alpha } from '@mui/material/styles';
import Container from '@mui/material/Container';
import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';

//import MenuItem from '@mui/material/MenuItem';
//import Menu from '@mui/material/Menu';
//import MenuIcon from '@mui/icons-material/Menu';
import AccountCircle from '@mui/icons-material/AccountCircle';
import Banner from './home/Banner.js';
import Recommend from './home/Recommend.js';
import NavBar from './common/NavBar.js';


function App() {
  return (
  <div>
        <NavBar />
        <Banner />
        <Recommend />
   </div>
  );
}

export default App;
