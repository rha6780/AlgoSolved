import { styled } from '@mui/material/styles';
import Grid from '@mui/material/Grid';
import Container from '@mui/material/Container';
import FormControl from '@mui/material/FormControl';
import FormControlLabel from '@mui/material/FormControlLabel';
import RadioGroup from '@mui/material/RadioGroup';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';


const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  height: 200,
  color: theme.palette.text.secondary,
}));

function Banner() {
  return (
  <Container>
    <Grid container spacing={2}>
      <Grid item xs={15}>
        <Item>
          <Grid item xs={12} sm container>
            <Grid item xs container direction="column" spacing={2}>
            <Grid item xs>
                <Typography gutterBottom variant="subtitle1" component="div">
                    광고 협찬 중!
                </Typography>
             </Grid>
            </Grid>
          </Grid>
        </Item>
      </Grid>
    </Grid>
  </Container>
  );
}

export default Banner;