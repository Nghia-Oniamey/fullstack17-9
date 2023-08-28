import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import SubHome from './pages/SubHome';



function App() {
  return (
    <div className="App">
      Nghĩa Pé Try To Learn React
      <Navbar/>
      <SubHome/>
    </div>
  );
}

export default App;
