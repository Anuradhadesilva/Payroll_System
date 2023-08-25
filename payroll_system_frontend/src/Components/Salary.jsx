import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Salary.css";
const Salary = () => {
  const [salary, setSalary] = useState([]);
  const [newSalary, setNewSalary] = useState({
    fullName: "",
    monthlySalary: 0,
    overtimeRates: 0,
    allowance: 0,
  });

  useEffect(() => {
    const url = `http://localhost:8080/api/v1/salary/getAll`;
    axios
      .get(url)
      .then((response) => setSalary(response.data))
      .catch((error) => console.error("Error fetching employees:", error));
  }, []);

  const HandleSalaryAdd = (e) => {
    e.preventDefault();
    axios
      .post("http://localhost:8080/api/v1/salary/register", newSalary)
      .then((response) => {
        setSalary([...salary, response.data]);
        setNewSalary({
          empID: 0,
          startDate: "",
          endDate: "",
          leavesTaken: 0,
          absentDays: 0,
          overtimeHours: 0,
        });
        window.location.reload();
      })
      .catch((error) =>
        console.error("Error Calculate employee Salarya:", error)
      );
  };
  const handleDelete = (salaryId) => {
    if (window.confirm("Are you sure that you want to delete..?")) {
      axios
        .delete(`http://localhost:8080/api/v1/salary/delete/${salaryId}`)
        .then(() => {
          setSalary((prevSalaries) =>
            prevSalaries.filter(
              (salary) => salary.salaryId !== salaryId
            )
          );
        })
        .catch((error) => console.error("Error deleting employee:", error));
    }
  };
  return (
    <div className="container mt-2">
      <div className="header d-flex justify-content-between ">
        <h2 className="h2 ">SALARY</h2>
        <button
          type="button"
          className="btn btn-primary"
          data-bs-toggle="modal"
          data-bs-target="#exampleModal"
        >
          Calculate Salary
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
                  Calculate Salary
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
                  <form onSubmit={HandleSalaryAdd}>
                    <div className="Id">
                      <label>Employee Id:</label>
                      <input
                        type="number"
                        value={newSalary.empID}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            empID: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="salary">
                      <label>Start Date</label>
                      <input
                        type="date"
                        value={newSalary.startDate}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            startDate: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="endDate">
                      <label>Start Date</label>
                      <input
                        type="date"
                        value={newSalary.endDate}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            endDate: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="leaves">
                      <label>Leaves Taken:</label>
                      <input
                        type="number"
                        value={newSalary.leavesTaken}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            leavesTaken: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="Absent">
                      <label>Absent Days:</label>
                      <input
                        type="number"
                        value={newSalary.absentDays}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            absentDays: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <div className="Over Time">
                      <label>Over Time</label>
                      <input
                        type="number"
                        value={newSalary.overtimeHours}
                        onChange={(e) =>
                          setNewSalary({
                            ...newSalary,
                            overtimeHours: e.target.value,
                          })
                        }
                        required
                      />
                    </div>
                    <button type="submit" className="btn btn-primary">
                      Calulate Salary
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
              <th>Base_Pay</th>
              <th>Start_date</th>
              <th>End_Date</th>
              <th>Absent_Days</th>
              <th>No_Of_Leaves</th>
              <th>Overtime (HOUR)</th>
              <th>Gross_Pay</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {salary.map((salary) => (
              <tr key={salary.salaryId}>
                <td>{salary.empID}</td>
                <td>{salary.basePay}</td>
                <td>{salary.startDate}</td>
                <td>{salary.endDate}</td>
                <td>{salary.absentDays}</td>
                <td>{salary.leavesTaken}</td>
                <td>{salary.overtimeHours}</td>
                <td>{salary.grossPay}</td>
                <td className="td-btn">
                  <button
                    type="submit"
                    className="btn btn-primary"
                    onClick={() => handleDelete(salary.salaryId)}
                  >
                    Delete
                  </button>
                </td>
                {/* <td className="td-btn">
                  <button type="submit" className="btn btn-primary ">
                    Edit
                  </button>
                  <button type="submit" className="btn btn-primary" onClick={() => handleDeleteClick(employee.employeeId)}>
                    Delete
                  </button>
                </td> */}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};
export default Salary;
