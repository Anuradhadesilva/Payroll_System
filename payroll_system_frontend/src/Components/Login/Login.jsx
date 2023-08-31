import React from "react";
import "./Login.css";
const Login = () => {
  return (
    <div>
      <div className="logincontainer ">
        <form action="" className="loginForm">
          <div className="image">
            <img
              src="Image/Login.jpg"
              class="d-block w-100"
              alt="..."
              height="200px"
            />
            <h2>LOGIN</h2>
          </div>
          <div className="inputColumn">
            <label htmlFor="username">Username:</label>
            <input type="text" id="username" />
          </div>
          <div className="inputColumn">
            <label htmlFor="password">Password:</label>
            <input type="password" id="password" />
          </div>
          <div className="register">
            Not registered? <a href="#" className="sign-tag">Sign up</a>
          </div>
          <button className="btn1">Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;
