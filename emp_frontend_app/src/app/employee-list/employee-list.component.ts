import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css',
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = []; // Initialize employees array
  constructor(private employeeService: EmployeeService) {}

  ngOnInit(): void {
    this.getListOfEmployees();
  }
  private getListOfEmployees() {
    this.employeeService.getEmployeeList().subscribe((data) => {
      this.employees = data;
      console.log(data);
    });
  }
}
