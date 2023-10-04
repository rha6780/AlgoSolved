import { Link } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import FormControl from '@mui/material/FormControl';
import FormControlLabel from '@mui/material/FormControlLabel';
import RadioGroup from '@mui/material/RadioGroup';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import BottomNavigation from '@mui/material/BottomNavigation';


const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  height: 200,
  color: theme.palette.text.secondary,
}));

function Footer() {
  return (
    <Container>
        <Box
          sx={{
            py: 3,
            px: 2,
            mt: 'auto',
          }}
          component="footer"
        >
          <Container maxWidth="sm">
            <Typography variant="body2" color="text.secondary" align="center">
              {"Copyright © "}
              <Link color="inherit" href="https://.com/">
                Algo Solved
              </Link>{" "}
              {new Date().getFullYear()}
              {"."}
            </Typography>
          </Container>
        </Box>
    </ Container>
  );
}

export default Footer;