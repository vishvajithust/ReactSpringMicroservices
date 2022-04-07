import React, { Component } from 'react'
import EmployeeService from '../services/EmployeeService'

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            employee: {}
        }
    }

    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then( res => {
            this.setState({employee: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Employee Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Employee Name &nbsp; : &nbsp;&nbsp; <b>{ this.state.employee.fullName }</b> </label>
                            
                        </div>
                        <div className = "row">
                            <label> Contact Number &nbsp;: &nbsp;&nbsp;<b>{ this.state.employee.mobile }</b> </label>
                            
                        </div>
                        <div className = "row">
                            <label> Employee Email ID &nbsp;:&nbsp;&nbsp; <b>{ this.state.employee.emailId }</b> </label>
                            
                        </div>
                        <div className = "row">
                            <label> Manager Name &nbsp;: &nbsp;&nbsp;<b>{ this.state.employee.manager }</b> </label>
                            
                        </div>
                        <div className = "row">
                            <label> Project Assigned &nbsp;:&nbsp;&nbsp; <b>{ this.state.employee.project }</b> </label>
                            
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewEmployeeComponent
