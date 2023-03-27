import {Route, Routes } from 'react-router-dom';
import {Home} from "./pages/Home"
import {Registracija} from './pages/Registracija';
import {Prisijungimas} from "./pages/Prisijungimas";
import {Prekes} from "./pages/Prekes";
import {Akcijos} from "./pages/Akcijos";
import {Contacts} from './pages/Contacts';
import {Parduok} from './pages/Parduok';
import {Krepselis} from './pages/Krepselis';
import {About} from "./pages/About";
import {Terms} from './pages/Terms';
import {Shipping} from './pages/Shipping';
import {Returns} from './pages/Returns';
import {Warranty} from './pages/Warranty';
import {Privacy} from './pages/Privacy';
import {Atsiliepimai} from './pages/Atsiliepimai';
import {Help} from './pages/Help';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home/>} />
      <Route path="/registracija" element={<Registracija/>} />
      <Route path="/prisijungti" element={<Prisijungimas/>} />
      <Route path="/prekes" element={<Prekes/>} />
      <Route path="/akcijos" element={<Akcijos/>} />
      <Route path="/parduok" element={<Parduok/>} />
      <Route path="/krepselis" element={<Krepselis/>} />
      <Route path="/about" element={<About/>} />
      <Route path="/contacts" element={<Contacts/>} />
      <Route path="/terms" element={<Terms/>} />
      <Route path="/shipping" element={<Shipping/>} />
      <Route path="/returns" element={<Returns/>} />
      <Route path="/warranty" element={<Warranty/>} />
      <Route path="/Privacy" element={<Privacy/>} />
      <Route path="/Atsiliepimai" element={<Atsiliepimai/>} />
      <Route path="/help" element={<Help/>} />
  </Routes>
  );
}

export default App;
