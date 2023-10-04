import { Link } from 'react-router-dom';
import React, { useState } from 'react';
import { styled, alpha } from '@mui/material/styles';
import Container from '@mui/material/Container';

import Box from '@mui/material/Box';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';

import AccountCircle from '@mui/icons-material/AccountCircle';
import Banner from 'components/home/Banner.js';
import Recommend from 'components/home/Recommend.js';
import NavBar from 'components/common/NavBar.js';


function Home() {
  return (
    <Container>
        <NavBar />
        <Banner />
        <Recommend />
    </Container>
   );
}

export default Home;