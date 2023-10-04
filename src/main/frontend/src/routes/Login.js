import { Link } from 'react-router-dom';
import React, { useState } from 'react';
import { styled, alpha } from '@mui/material/styles';
import Container from '@mui/material/Container';
import NavBar from 'components/common/NavBar';
import Footer from 'components/common/Footer';

import LoginForm from 'components/auth/LoginForm';


function Login() {
  return (
    <div>
        <Container sx={{
           display: 'flex',
           flexDirection: 'column',
           minHeight: '100vh',
        }}>
            <NavBar />
            <LoginForm />
        </Container>
        <Footer />
    </ div>
   );
}

export default Login;