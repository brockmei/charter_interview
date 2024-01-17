import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http"
import { Observable, map } from "rxjs";
import { IUserPasswordResponseContent } from "src/app/types/user-password-content.interface";
import { IUserPasswordResponse } from "src/app/types/user-password-response.interface";
import { IUserPasswordRequest } from "src/app/types/user-password-request.interface";

@Injectable({
    providedIn:'root',
})
export class ValidationService {
    constructor(private http : HttpClient,
        ) {}

    validate(data:IUserPasswordRequest): Observable<IUserPasswordResponseContent> {
        const url = "http://localhost:8082/user/update";
        console.log("url is "+ url);
         
        return this.http.post<IUserPasswordResponse>(url, data).pipe(map((response) => response.content))
    }
}