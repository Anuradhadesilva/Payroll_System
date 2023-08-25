import "./App.css";

import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./Components/Navbar";
import Employee from "./Components/Employee/Employee";
import Salary from "./Components/Salary";
import Home from "./Components/Home/Home";


function App() {
  return (
    <Router>
      <div>
        <Navbar />
        <Routes>
          <Route exact path="/" Component={Home}></Route>
          <Route exact path="/Employee" Component={Employee}></Route>
          <Route exact path="/Salary" Component={Salary}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
