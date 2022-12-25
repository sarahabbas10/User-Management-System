import {BrowserRouter,Routes,Route} from "react-router-dom";
import Login from './components/Login';
import './App.css';
import User from "./components/User";
import Users from "./components/Users";
function App() {
  return (
    <BrowserRouter>
    <div >
     <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/user/:username" element={<User />} />
      <Route path="/users" element={<Users />} />
      </Routes>
    </div>
    </BrowserRouter>
  );
}
export default App;