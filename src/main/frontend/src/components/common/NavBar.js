import { Link } from 'react-router-dom';
import React, { useState } from 'react';
import { styled, alpha } from '@mui/material/styles';
import Container from '@mui/material/Container';
import Box from '@mui/material/Box';
import ButtonGroup from '@mui/material/ButtonGroup';
import Button from '@mui/material/Button';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import InputBase from '@mui/material/InputBase';
import IconButton from '@mui/material/IconButton';
import SearchIcon from '@mui/icons-material/Search';

import AccountCircle from '@mui/icons-material/AccountCircle';


const Search = styled('div')(({ theme }) => ({
  position: 'relative',
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha(theme.palette.common.white, 0.15),
  '&:hover': {
    backgroundColor: alpha(theme.palette.common.white, 0.25),
  },
  marginRight: theme.spacing(2),
  marginLeft: 0,
  width: '100%',
  [theme.breakpoints.up('sm')]: {
    marginLeft: theme.spacing(3),
    width: 'auto',
  },
}));

const SearchIconWrapper = styled('div')(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: '100%',
  position: 'absolute',
  pointerEvents: 'none',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: 'inherit',
  '& .MuiInputBase-input': {
    padding: theme.spacing(1, 1, 1, 0),
    // vertical padding + font size from searchIcon
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('md')]: {
      width: '30ch',
    },
  },
}));

const Logo = styled(Link)(({theme}) => ({
    color: 'white',
    textDecoration: 'none'
}));

const isLoggedIn = false;


function NavBar() {
//  const [isLoggedIn, setIsLoggedIn] = useState(false);
//
//  useEffect(() => {
//    const fetchData = async() => {
//      const res = await fetch('https://localhost:8080/api/v1/auth/current');
//      const result = res.json();
//      return result;
//    }
//
//    fetchData().then(res => setData(res));
//  }, []);

  return (
    <Container>
        <AppBar position="static">
            <Toolbar>
                <Logo to={'/'} >
                    <Typography variant="h5" styled={{ color: "white"}}>
                        Algo Solved
                    </Typography>
                </Logo>
                <Box sx={{ flexGrow: 1 }} />
                <Search>
                    <SearchIconWrapper>
                        <SearchIcon />
                    </SearchIconWrapper>
                    <StyledInputBase
                        placeholder="Search..."
                        inputProps={{ 'aria-label': 'search' }}
                    />
                </Search>
                <Box sx={{ display: { xs: 'none', md: 'flex'} }}>
                { isLoggedIn ?
                    <IconButton
                      size="large"
                      edge="end"
                      aria-label="account of current user"
                        //aria-controls={menuId}
                      aria-haspopup="true"
                        //onClick={handleProfileMenuOpen}
                      color="inherit"
                    >
                      <AccountCircle />
                    </IconButton>
                    :

                    <ButtonGroup
                      disableElevation
                      variant="contained"
                      aria-label="Disabled elevation buttons"
                    >
                      <Link to={'/login'}><Button>Login</Button></Link>
                    </ButtonGroup>

                }
                </Box>
            </Toolbar>
        </AppBar>
        <br/>
    </Container>
   );
}

export default NavBar;