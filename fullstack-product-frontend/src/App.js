import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import SubHome from './pages/SubHome';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddProduct from './products/AddProduct';


function App() {
  return (
    <div className="App">
      Nghĩa Pé Try To Learn React
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<SubHome />} />
          <Route exact path="/addProduct" element={<AddProduct />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
