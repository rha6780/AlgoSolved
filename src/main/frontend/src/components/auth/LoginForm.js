import React from 'react';
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
  const [value, setValue] = React.useState(0);

  const handleChange = (event: React.SyntheticEvent, newValue: number) => {
    setValue(newValue);
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
               <Tab label="Login" {...a11yProps(0)} />
               <Tab label="SignUp" {...a11yProps(1)} />
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
                 />
                 <TextField
                   required
                   id="outlined-password-input"
                   label="Password"
                   sx={{ margin: 2}}
                 />
                 <Button >OK!</Button>
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
             />
             <TextField
                required
                id="outlined-password-input"
                label="Password"
                sx={{ margin: 2}}
             />
             <TextField
                required
                id="outlined-password-input"
                label="Re-Password"
                sx={{ margin: 2}}
             />
             <TextField
                required
                id="outlined-required"
                label="Name"
                sx={{ margin: 2}}
             />
          <Button>OK!</Button>
          </ Paper>
          </CustomTabPanel>
    </ Grid>
  </Container>
  );
}

export default LoginForm;