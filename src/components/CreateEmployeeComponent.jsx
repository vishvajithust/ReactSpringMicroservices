import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService';

class CreateEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            fullName: '',
            mobile: '',
            emailId: '',
            address: '',
            project: '',
            manager: ''
        }
        this.changefullNameHandler = this.changefullNameHandler.bind(this);
        this.changemobileHandler = this.changemobileHandler.bind(this);
        this.changeEmailIdHandler = this.changeEmailIdHandler.bind(this);
        this.changeaddressHandler = this.changeaddressHandler.bind(this);
        this.changemanagerHandler = this.changemanagerHandler.bind(this);
        this.changeprojectHandler = this.changeprojectHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            EmployeeService.getEmployeeById(this.state.id).then( (res) =>{
                let employee = res.data;
                this.setState({fullName: employee.fullName,
                    mobile: employee.mobile,
                    emailId : employee.emailId,
                    address : employee.address,
                    manager : employee.manager,
                    project : employee.project
                });
            });
        }        
    }
    saveOrUpdateEmployee = (e) => {
        e.preventDefault();
        let employee = {fullName: this.state.fullName, mobile: this.state.mobile, emailId: this.state.emailId, address: this.state.address, manager: this.state.manager, project: this.state.project};
        console.log('employee => ' + JSON.stringify(employee));

        // step 5
        if(this.state.id === '_add'){
            EmployeeService.createEmployee(employee).then(res =>{
                this.props.history.push('/employees');
            });
        }else{
            EmployeeService.updateEmployee(employee, this.state.id).then( res => {
                this.props.history.push('/employees');
            });
        }
    }
    
    changefullNameHandler= (event) => {
        this.setState({fullName: event.target.value});
    }

    changemobileHandler= (event) => {
        this.setState({mobile: event.target.value});
    }

    changeEmailIdHandler= (event) => {
        this.setState({emailId: event.target.value});
    }
    changeaddressHandler= (event) => {
        this.setState({address: event.target.value});
    }
    changemanagerHandler= (event) => {
        this.setState({manager: event.target.value});
    }
    changeprojectHandler= (event) => {
        this.setState({project: event.target.value});
    }


    cancel(){
        this.props.history.push('/employees');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Employee</h3>
        }else{
            return <h3 className="text-center">Update Employee</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Full Name: </label>
                                            <input placeholder="Full Name" name="fullName" className="form-control" 
                                                value={this.state.fullName} onChange={this.changefullNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Mobile </label>
                                            <input placeholder="Mobile" name="mobile" className="form-control" 
                                                value={this.state.mobile} onChange={this.changemobileHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Email Id: </label>
                                            <input placeholder="Email Address" name="emailId" className="form-control" 
                                                value={this.state.emailId} onChange={this.changeEmailIdHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Address: </label>
                                            <input placeholder="Address" name="address" className="form-control" 
                                                value={this.state.address} onChange={this.changeaddressHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Manager: </label>
                                            <input placeholder="Manager" name="manager" className="form-control" 
                                                value={this.state.manager} onChange={this.changemanagerHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>Project: </label>
                                            <input placeholder="Project" name="project" className="form-control" 
                                                value={this.state.project} onChange={this.changeprojectHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEmployee}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateEmployeeComponent
