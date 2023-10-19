import React, { useState } from 'react';
import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import FormControl from '@mui/material/FormControl';
import FormControlLabel from '@mui/material/FormControlLabel';
import Typography from '@mui/material/Typography';
import RadioGroup from '@mui/material/RadioGroup';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import FilledInput from '@mui/material/FilledInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormHelperText from '@mui/material/FormHelperText';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import IconButton from '@mui/material/IconButton';
import Input from '@mui/material/Input';

import { signUp } from 'api/v1/auth/signUp';
import { signIn } from 'api/v1/auth/signIn';

interface TabPanelProps {
  children?: React.ReactNode;
  index: number;
  value: number;
}

function CustomTabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

function a11yProps(index: number) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  };
}


function LoginForm() {
  const [value, setValue] = useState(0);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [rePassword, setRePassword] = useState("");
  const [name, setName] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [showRePassword, setShowRePassword] = useState(false);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
  }

  const handleClickShowPassword = () => setShowPassword((show) => !show);
  const handleClickShowRePassword = () => setShowRePassword((show) => !show);

  const handleMouseDownPassword = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
  };

  const handleMouseDownRePassword = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
  };

  const handleEmail = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(event.target.value);
  };

  const handlePassword = (event: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
  };

  const handleRePassword = (event: React.ChangeEvent<HTMLInputElement>) => {
    setRePassword(event.target.value);
  };

  const handleName = (event: React.ChangeEvent<HTMLInputElement>) => {
    setName(event.target.value);
  };

  const clearData = (event: React.ChangeEvent<HTMLButtonElement>) => {
    setEmail("");
    setPassword("");
    setRePassword("");
    setName("");
  };

  //TODO: 응답에 따라 에러 메세지 또는 화면 전환
  const submitSignIn = () => {
    signIn( {email, password} )
  }

  const submitSignUp = () => {
    signUp( {email, password, name} )
  };


  return (
  <Container>
    <Grid sx={{
                 marginTop: 10,
                 display: 'flex',
                 flexDirection: 'column',
                 alignItems: 'center',
             }}>

           <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
             <Tabs value={value} onChange={handleChange} aria-label="basic tabs example">
               <Tab label="Login" {...a11yProps(0)} onClick={clearData}/>
               <Tab label="SignUp" {...a11yProps(1)} onClick={clearData}/>
             </Tabs>
           </Box>
           <CustomTabPanel value={value} index={0}>
             <Paper sx={{
                padding: 10,
                display: 'flex',
                flexDirection: 'column',
                width: 700,
                height: 400,
             }}>
                <Typography variant="h5" component="h5">
                  로그인하기
                </Typography>

                 <TextField
                   required
                   id="outlined-required"
                   label="Email"
                   sx={{ margin: 2}}
                   onChange ={handleEmail}
                 />
                 <FormControl sx={{ margin: 2 }} variant="outlined">
                   <InputLabel htmlFor="outlined-adornment-password">Password *</InputLabel>
                     <OutlinedInput
                       id="outlined-adornment-password"
                       type={showPassword ? 'text' : 'password'}
                       endAdornment={
                         <InputAdornment position="end">
                           <IconButton
                             aria-label="toggle password visibility"
                             onClick={handleClickShowPassword}
                             onMouseDown={handleMouseDownPassword}
                             edge="end"
                           >
                             {showPassword ? <VisibilityOff /> : <Visibility />}
                           </IconButton>
                         </InputAdornment>
                       }
                       required
                       label="password"
                       onChange={handlePassword}
                     />
                 </FormControl>
                 <Button onClick={submitSignIn} >OK!</Button>
             </ Paper>
           </CustomTabPanel>
           <CustomTabPanel value={value} index={1}>
             <Paper sx={{
                 padding: 10,
                 display: 'flex',
                 flexDirection: 'column',
                 width: 700,
                 height: 400,
             }}>
             <Typography variant="h5" component="h5">
               회원가입하기
             </Typography>

             <TextField
                required
                id="outlined-required"
                label="Email"
                sx={{ margin: 2}}
                onChange ={handleEmail}
             />
             <FormControl sx={{ margin: 2 }} variant="outlined">
              <InputLabel htmlFor="outlined-adornment-password">Password *</InputLabel>
                <OutlinedInput
                  id="outlined-adornment-password"
                  type={showPassword ? 'text' : 'password'}
                  endAdornment={
                    <InputAdornment position="end">
                      <IconButton
                        aria-label="toggle password visibility"
                        onClick={handleClickShowPassword}
                        onMouseDown={handleMouseDownPassword}
                        edge="end"
                      >
                        {showPassword ? <VisibilityOff /> : <Visibility />}
                      </IconButton>
                    </InputAdornment>
                  }
                  required
                  label="password"
                  onChange={handlePassword}
                />
             </FormControl>
             <FormControl sx={{ margin: 2 }} variant="outlined">
             <InputLabel htmlFor="outlined-adornment-password">Re-Password *</InputLabel>
               <OutlinedInput
                 id="outlined-adornment-password"
                 type={showRePassword ? 'text' : 'password'}
                 endAdornment={
                   <InputAdornment position="end">
                     <IconButton
                       aria-label="toggle password visibility"
                       onClick={handleClickShowRePassword}
                       onMouseDown={handleMouseDownRePassword}
                       edge="end"
                     >
                       {showRePassword ? <VisibilityOff /> : <Visibility />}
                     </IconButton>
                   </InputAdornment>
                 }
                 required
                 label="re-password"
                 onChange={handleRePassword}
               />
             </FormControl>
             <TextField
                required
                id="outlined-required"
                label="Name"
                sx={{ margin: 2}}
                onChange={handleName}
             />
          <Button onClick={submitSignUp}>OK!</Button>
          </ Paper>
          </CustomTabPanel>
    </ Grid>
  </Container>
  );
}

export default LoginForm;