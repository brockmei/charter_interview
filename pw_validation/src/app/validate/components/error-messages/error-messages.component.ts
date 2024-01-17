import { CommonModule } from "@angular/common";
import { Component, Input, OnInit } from "@angular/core";
import { IUserValidationErrors } from "src/app/types/user-validation-errors.interface";
import { IValidateErrors } from "src/app/types/validate-errors.interface";

@Component({
    selector:'pw-validate-error-messages',
    templateUrl: './error-messages.component.html',
    standalone:true,
    imports:[CommonModule]
})

export class ValidateErrorMessages implements OnInit{
    @Input() errorMessages:IUserValidationErrors = {};
    
    errors: string[] = [];
    constructor() {}
    ngOnInit(){
        this.errors = Object.keys(this.errorMessages).map((name:string) => {
            const messages = this.errorMessages[name];
            return `${messages}`
        })
    }

}

