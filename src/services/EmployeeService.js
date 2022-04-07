import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:8088/employee/api/employees";
const EMPLOYEE_API_BASE_URL_MICRO = "http://localhost:8089/microservice-api/get-all";

class EmployeeService {

    getEmployees(){
        return axios.get(EMPLOYEE_API_BASE_URL_MICRO);
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }

    updateEmployee(employee, employeeId){
        return axios.put(EMPLOYEE_API_BASE_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_API_BASE_URL + '/' + employeeId);
    }
}

export default new EmployeeService()
