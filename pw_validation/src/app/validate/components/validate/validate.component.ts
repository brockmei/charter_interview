import { CommonModule } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import { FormBuilder, ReactiveFormsModule, Validators } from "@angular/forms";
import { Actions } from "@ngrx/effects";
import { Store } from "@ngrx/store";
import { Subscription, combineLatest } from "rxjs";
import { validateActions } from "src/app/store/actions";
import { selectIsSubmitting, selectIsSuccessfulValidation, selectValidationErrors } from "src/app/store/reducer";
import { IUserPasswordRequest } from "src/app/types/user-password-request.interface";
import { ValidateErrorMessages } from "../error-messages/error-messages.component";

@Component({
    selector: 'pw_validate',
    templateUrl: './validate.component.html',
    standalone: true,
    imports: [ReactiveFormsModule, CommonModule, ValidateErrorMessages]
})

export class ValidateComponent {

    constructor(private fb:FormBuilder, private store:Store){}
    clearFormSubscription = new Subscription();

    data$ = combineLatest({
        isSubmitting:this.store.select(selectIsSubmitting),
        validationErrors:this.store.select(selectValidationErrors),
        isSuccessfulValidation:this.store.select(selectIsSuccessfulValidation),
    })
    
     form = this.fb.nonNullable.group({
      password: ['', Validators.required],
    })
  
    onSubmit() {
      console.log("form", this.form.getRawValue());
      const request:IUserPasswordRequest = {password:this.form.getRawValue().password}
      this.store.dispatch(validateActions.validate(({request})))
    }
  
  }


