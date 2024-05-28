import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8080/api/v1/employee/';

  constructor(private httpClint: HttpClient) {}

  // Get all list of employee
  getEmployeeList(): Observable<Employee[]> {
    return this.httpClint.get<Employee[]>(`${this.baseUrl}`);
  }

  // create a method to take the employee data
  createEmployee(employee: Employee): Observable<Object> {
    return this.httpClint.post<Employee>(`${this.baseUrl}`, employee);
  }
}
