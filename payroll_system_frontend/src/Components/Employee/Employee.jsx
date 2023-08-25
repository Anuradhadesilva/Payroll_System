import React, { useState, useEffect } from "react";
import "./Employee.css";
import axios from "axios";

const Employee = () => {
  const [employees, setEmployees] = useState([]);
  const [newEmployee, setNewEmployee] = useState({
    fullName: "",
    monthlySalary: 0,
    overtimeRates: 0,
    allowance: 0,
  });
  const [editedEmployee, setEditedEmployee] = useState(null);
  const [SearchEmployee,setSearchEmployee]=useState("");
  const [message, setMessage] = useState("");

  useEffect(() => {
    const url = `http://localhost:8080/api/v1/employee/getAll`;
    axios
      .get(url)
      .then((response) => setEmployees(response.data))
      .catch((error) => console.error("Error fetching employees:", error));
  }, []);

  const HandleEmployeeAdd = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/api/v1/employee/register", newEmployee)
      .then((response) => {
        setEmployees([...employees, response.data]);
        setNewEmployee({
          fullName: "",
          monthlySalary: 0,
          overtimeRates: 0,
          allowance: 0,
        });
        window.location.reload();
      })
      .catch((error) => console.error("Error registering employee:", error));
  };

  const handleEditSubmit = (event, employeeId) => {
    event.preventDefault();

    axios
      .put(`http://localhost:8080/api/v1/employee/edit/${employeeId}`, editedEmployee)
      .then((response) => {
        setEmployees((prevEmployees) =>
          prevEmployees.map((employee) =>
            employee.id === employeeId ? response.data : employee
          )
        );
        setEditedEmployee(null);
        window.location.reload();
      })
      .catch((error) => console.error("Error updating employee:", error));
  };

  const handleEditClick = (employee) => {
    setEditedEmployee({ ...employee });
  };

  const handleDeleteClick = (employeeId) => {
    if (window.confirm("Are you sure that you want to delete..?")) {
      axios
        .delete(`http://localhost:8080/api/v1/employee/delete/${employeeId}`)
        .then(() => {
          setEmployees((prevEmployees) =>
            prevEmployees.filter(
              (employee) => employee.employeeId !== employeeId
            )
          );
        })
        .catch((error) => console.error("Error deleting employee:", error));
    }
  };
  return (
    <div className="container mt-2">
      <div className="header d-flex justify-content-between ">
        <h2 className="h2 ">EMPLOYEE</h2>
        <button
          type="button"
          className="btn btn-primary"
          data-bs-toggle="modal"
          data-bs-target="#addEmployeeModal"
        >
          Add Employee
        </button>
        <div
          class="modal fade"
          id="addEmployeeModal"
          tabindex="-1"
          aria-labelledby="exampleModalLabel"
          aria-hidden="true"
        >
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">
                  ADD EMPLOYEE
                </h1>
                <button
                  type="button"
                  class="btn-close"
                  data-bs-dismiss="modal"
                  aria-label="Close"
                ></button>
              </div>
              <div class="modal-body">
                <div className="form">
                  <form onSubmit={HandleEmployeeAdd}>
                    <div className="name">
                      <label>Full Name:</label>
                      <input
                        type="text"
                        value={newEmployee.fullName}
                        onChange={(e) =>
                          setNewEmployee({
                            ...newEmployee,
                            fullName: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="salary">
                      <label>Monthly Salary:</label>
                      <input
                        type="number"
                        value={newEmployee.monthlySalary}
                        onChange={(e) =>
                          setNewEmployee({
                            ...newEmployee,
                            monthlySalary: parseFloat(e.target.value),
                          })
                        }
                        required
                      />
                    </div>
                    <div className="overtime">
                      <label>Overtime Rates:</label>
                      <input
                        type="number"
                        value={newEmployee.overtimeRates}
                        onChange={(e) =>
                          setNewEmployee({
                            ...newEmployee,
                            overtimeRates: parseFloat(e.target.value),
                          })
                        }
                        required
                      />
                    </div>
                    <div className="allowance">
                      <label>Allowance:</label>
                      <input
                        type="number"
                        value={newEmployee.allowance}
                        onChange={(e) =>
                          setNewEmployee({
                            ...newEmployee,
                            allowance: parseFloat(e.target.value),
                          })
                        }
                        required
                      />
                    </div>
                    <button type="submit" className="btn btn-primary">
                      ADD Employee
                    </button>
                  </form>
                </div>
              </div>
              {/* <div class="modal-footer">
              <button
                type="button"
                class="btn btn-secondary"
                data-bs-dismiss="modal"
              >
                Close
              </button>
              <button type="button" class="btn btn-primary">
                Save changes
              </button>
            </div> */}
            </div>
          </div>
        </div>
      </div>
      <div className="empTable ">
        <table class="table ">
          <thead>
            <tr>
              <th>Id</th>
              <th>Name</th>
              <th>Monthly Salary (Rs:)</th>
              <th>Overtime Rate (Hourly)</th>
              <th>Allowances (Rs:)</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {employees.map((employee) => (
              <tr key={employee.employeeId}>
                <td>{employee.employeeId}</td>
                <td>{employee.fullName}</td>
                <td>{employee.monthlySalary}</td>
                <td>{employee.overtimeRates}</td>
                <td>{employee.allowance}</td>
                <td className="td-btn">
                  <button
                    type="button"
                    className="btn btn-primary"
                    data-bs-toggle="modal"
                    data-bs-target="#exampleModal"
                    onClick={() => handleEditClick(employee)}
                  >
                    Edit
                  </button>
                  <div
                    class="modal fade"
                    id="exampleModal"
                    tabindex="-1"
                    aria-labelledby="exampleModalLabel"
                    aria-hidden="true"
                  >
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h1 class="modal-title fs-5" id="exampleModalLabel">
                            Edit Employee
                          </h1>
                          <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"
                          ></button>
                        </div>
                        <div class="modal-body">
                          <div className="form">
                            {editedEmployee && (
                              <form
                                onSubmit={(e) =>
                                  handleEditSubmit(e, editedEmployee.employeeId)
                                }
                              >
                                <div className="name">
                                  <label>Full Name:</label>
                                  <input
                                    type="text"
                                    value={editedEmployee.fullName}
                                    onChange={(e) =>
                                      setEditedEmployee({
                                        ...editedEmployee,
                                        fullName: e.target.value,
                                      })
                                    }
                                    required
                                  />
                                </div>
                                <div className="salary">
                                  <label>Monthly Salary:</label>
                                  <input
                                    type="number"
                                    value={editedEmployee.monthlySalary}
                                    onChange={(e) =>
                                      setEditedEmployee({
                                        ...editedEmployee,
                                        monthlySalary: parseFloat(
                                          e.target.value
                                        ),
                                      })
                                    }
                                    required
                                  />
                                </div>
                                <div className="overtime">
                                  <label>Overtime Rates:</label>
                                  <input
                                    type="number"
                                    value={editedEmployee.overtimeRates}
                                    onChange={(e) =>
                                      setEditedEmployee({
                                        ...editedEmployee,
                                        overtimeRates: parseFloat(
                                          e.target.value
                                        ),
                                      })
                                    }
                                    required
                                  />
                                </div>
                                <div className="allowance">
                                  <label>Allowance:</label>
                                  <input
                                    type="number"
                                    value={editedEmployee.allowance}
                                    onChange={(e) =>
                                      setEditedEmployee({
                                        ...editedEmployee,
                                        allowance: parseFloat(e.target.value),
                                      })
                                    }
                                    required
                                  />
                                </div>
                                <button
                                  type="submit"
                                  className="btn btn-primary"
                                >
                                  Save Changes
                                </button>
                              </form>
                            )}
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <button
                    type="submit"
                    className="btn btn-primary"
                    onClick={() => handleDeleteClick(employee.employeeId)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Employee;
