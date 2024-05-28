import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css',
})
export class CreateEmployeeComponent {
  // define employee object
  employee: Employee = new Employee();
  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {} // calling the service

  // save employee
  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        this.goToEmployeeList();
      },
      (error) => console.log(error)
    );
  }
  // go to employee list page
  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
  // create funtion
  onSubmit() {
    this.saveEmployee();
    // console.log(this.employee);
  }
}
