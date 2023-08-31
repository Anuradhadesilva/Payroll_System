import { NavLink } from "react-router-dom";
const Navbar = () => {
  return (
    <>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand fw-bold fs-4s" href="/">
            Pay Roll
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <ul className="navbar-nav  mb-2 mb-lg-0">
              <li className="nav-item">
                  <NavLink
                    className="nav-link"
                    aria-current="page"
                    to="/Reg"
                  >
                    Reg
                  </NavLink>
                </li>
              <li className="nav-item">
                  <NavLink
                    className="nav-link"
                    aria-current="page"
                    to="/"
                  >
                    Home
                  </NavLink>
                </li>
                <li className="nav-item">
                  <NavLink
                    className="nav-link"
                    aria-current="page"
                    to="/Employee"
                  >
                    Employee
                  </NavLink>
                </li>
                <li className="nav-item">
                  <NavLink className="nav-link" to="/Salary">
                    Salary
                  </NavLink>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </>
  );
};
export default Navbar;
