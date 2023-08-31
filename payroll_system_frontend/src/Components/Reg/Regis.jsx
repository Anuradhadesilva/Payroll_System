import React from "react";
import "./Reg.css";
const Regis = () => {
  return (
    <div className="formContainer">
      <form action="" className="regForm">
        <div className="image">
          <img
            src="Image/Login.jpg"
            className="img"
            alt="..."
            height="150px"
            width="150px"
          />
          <h2>Register</h2>
        </div>
        <div className="inputColumn">
          <label htmlFor="">Full Name:</label>
          <input type="text" />
        </div>
        <div className="inputColumn">
          <label htmlFor="">Email(Username):</label>
          <input type="email" />
        </div>
        <div className="inputColumn">
          <label htmlFor="">Password:</label>
          <input type="text" />
        </div>
        <button>Register</button>
      </form>
    </div>
  );
};

export default Regis;
